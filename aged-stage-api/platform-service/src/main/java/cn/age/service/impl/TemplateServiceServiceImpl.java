package cn.age.service.impl;


import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.common.constants.BaseConstant;
import cn.age.common.utils.collection.CollectionUtils;
import cn.age.common.utils.common.BaseUtil;
import cn.age.common.utils.common.CheckParam;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import cn.age.interaction.helper.PageBuilder;
import cn.age.interaction.internal.auth.AuthUserMeta;
import cn.age.interaction.req.*;
import cn.age.interaction.resp.OldSketchResp;
import cn.age.interaction.resp.TemplateServiceResp;
import cn.age.interaction.resp.page.Pagination;
import cn.age.repository.entity.OldSketch;
import cn.age.repository.entity.TemplateService;
import cn.age.repository.repository.TemplateServiceRepository;
import cn.age.repository.result.AuthPermissionQueryResult;
import cn.age.service.AuthUserService;
import cn.age.service.TemplateServiceService;
import cn.age.service.config.data.ItemCriteriaBuilder;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
@Service
@Slf4j
public class TemplateServiceServiceImpl implements TemplateServiceService {


    @Resource
    private MapperFacade mapperFacade;

    @Resource
    private BaseConstant baseConstant;

    @Resource
    private AuthUserService authUserService;

    @Resource
    private IExcelDictHandler excelDictHandler;

    @Resource
    private ItemCriteriaBuilder itemCriteriaBuilder;

    @Resource
    private TemplateServiceRepository serviceRepository;


    /**
     * 新增
     *
     * @param addReq 新增Req
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/2/15
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addItem(TemplateServiceAddReq addReq) {
        log.info(">>>>>>>>>>>>>>>>>新增Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(addReq));
        TemplateService entity = mapperFacade.map(addReq, TemplateService.class);
        try {
            AuthUserMeta authUserMeta = authUserService.currentUserMeta(true);
            String authUserId = authUserMeta.getAuthUserId();
            BaseUtil.setFieldValueNotNull(entity);
            entity.setServiceTemplateId(SnowflakeIdWorker.uniqueSequenceStr());
            entity.setOperatorId(authUserId);
            entity.setDeleteStatus(2);
        } catch (Exception e) {
            log.error("新增->设置为空的属性失败 {} , {} ", e.getMessage(), e);
        }
        serviceRepository.insert(entity);
    }

    @Override
    public Pagination<TemplateServiceResp> queryByPage(TemplateServiceReq pageReq) {
        log.info(">>>>>>>>>>>>>>>>>分页查询Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(pageReq));
        //构建查询条件
        Example pageExample = new Example(TemplateService.class);
        Example.Criteria pageCriteria = pageExample.createCriteria();


        itemCriteriaBuilder.rigidCriteria(pageCriteria, true);
        setPageCriteria(pageCriteria, pageReq);
        pageExample.orderBy("createTime").desc();
        //开始分页
        Page<Object> page = PageHelper.startPage(pageReq.getCurrentPage(), pageReq.getItemsPerPage());
        List<TemplateService> serviceList = serviceRepository.selectByExample(pageExample);
        if (CollectionUtils.isEmpty(serviceList)) {
            return PageBuilder.buildPageResult(page, new ArrayList<>());
        }
        List<TemplateService> respList =
                mapperFacade.mapAsList(serviceList, TemplateService.class);
        int startIndex = (pageReq.getItemsPerPage() * pageReq.getCurrentPage()) - pageReq.getItemsPerPage() + 1;
        AtomicInteger idBeginIndex = new AtomicInteger(startIndex);
        respList.forEach(item -> item.setId(Integer.valueOf(idBeginIndex.getAndIncrement()).longValue()));
        return PageBuilder.buildPageResult(page, respList);
    }


    /**
     * 设置分页条件
     *
     * @param pageCriteria 查询条件
     * @param pageReq      分页插件
     * @return
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/5/31
     */
    private void setPageCriteria(Example.Criteria pageCriteria, TemplateServiceReq pageReq) {

        if (!CheckParam.isNull(pageReq.getServiceName())) {
            pageCriteria.andLike("service", "%" + pageReq.getServiceName() + "%");
        }

        if (!CheckParam.isNull(pageReq.getServiceMoney())) {
            pageCriteria.andEqualTo("serviceMoney", pageReq.getServiceMoney());
        }


    }


    @Override
    public void batchDeleteItem(List<String> asList) {
        if (CollectionUtils.isEmpty(asList)) {
            return;
        }
        serviceRepository.batchUpdateDeleteStatus(baseConstant.getDeleteStatus(), asList);
    }


    /**
     * 更新
     *
     * @param updateReq 更新请求参数
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/4/2
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateItem(TemplateServiceUpdateReq updateReq) {
        log.info(">>>>>>>>>>>>>>>>>更新请求参数 {} <<<<<<<<<<<<<<<<", JSON.toJSONString(updateReq));
        String mainId = updateReq.getServiceTemplateId();
        Example example = Example.builder(TemplateService.class).where(Sqls.custom()
                .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                .andEqualTo("serviceTemplateId", mainId))
                .build();
        TemplateService templateService = serviceRepository.selectOneByExample(example);
        if (CheckParam.isNull(templateService)) {
            return;
        }
        setNeedUpdateItem(templateService, updateReq);
        serviceRepository.updateByPrimaryKeySelective(templateService);
    }
    /**
     * 设置需要更新的字段
     *
     * @param updateReq 更新参数
     * @param entity    产业
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/30
     */
    private void setNeedUpdateItem(TemplateService entity,
                                   TemplateServiceUpdateReq updateReq) {
        if (!CheckParam.isNull(updateReq.getServiceName())) {
            entity.setServiceName(updateReq.getServiceName());
        }
        if (!CheckParam.isNull(updateReq.getServiceMoney())) {
            entity.setServiceMoney(updateReq.getServiceMoney());
        }

    }

    @Override
    public List<TemplateServiceResp> allServiceSketch() {
        Example example = new Example(TemplateService.class);
        Example.Criteria criteria = example.createCriteria();
        itemCriteriaBuilder.rigidCriteria(criteria, true);
        List<TemplateService> dataList = serviceRepository.selectByExample(example);
        if (CollectionUtils.isEmpty(dataList)) {
            return new ArrayList<>();
        }
        return mapperFacade.mapAsList(dataList, TemplateServiceResp.class);
    }
}
