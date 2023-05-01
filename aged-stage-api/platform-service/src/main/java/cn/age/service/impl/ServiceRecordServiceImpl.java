package cn.age.service.impl;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.common.constants.BaseConstant;
import cn.age.common.exception.ApiException;
import cn.age.common.exception.BusinessException;
import cn.age.common.utils.collection.CollectionUtils;
import cn.age.common.utils.common.BaseUtil;
import cn.age.common.utils.common.CheckParam;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import cn.age.interaction.helper.PageBuilder;
import cn.age.interaction.internal.auth.AuthUserMeta;
import cn.age.interaction.req.ServiceRecordAddReq;
import cn.age.interaction.req.ServiceRecordReq;
import cn.age.interaction.req.ServiceRecordUpdateReq;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.ServiceRecordResp;
import cn.age.repository.entity.ServiceRecord;
import cn.age.repository.entity.TemplateService;
import cn.age.repository.repository.ServiceRecordRepository;
import cn.age.repository.repository.TemplateServiceRepository;
import cn.age.service.AuthUserService;
import cn.age.service.ServiceRecordService;
import cn.age.service.TemplateServiceService;
import cn.age.service.config.data.ItemCriteriaBuilder;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.service
 * @Description: 首页分类相关服务方法实现
 * @date 2021-04-23
 */
@Service("accidentRecordService")
@Slf4j
public class ServiceRecordServiceImpl implements ServiceRecordService {

    @Resource
    private ServiceRecordRepository serviceRecordRepository;

    @Resource
    private MapperFacade mapperFacade;

    @Resource
    private BaseConstant baseConstant;

    @Resource
    private AuthUserService authUserService;

    @Resource
    private IExcelDictHandler excelDictHandler;

    @Resource
    private TemplateServiceRepository serviceRepository;

    @Resource
    private ItemCriteriaBuilder itemCriteriaBuilder;

    public ServiceRecordServiceImpl(IExcelDictHandler excelDictHandler) {
        this.excelDictHandler = excelDictHandler;
    }

    /**
     * 新增
     *
     * @param addReq 新增Req
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/2/15
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addItem(ServiceRecordAddReq addReq) {
        log.info(">>>>>>>>>>>>>>>>>新增Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(addReq));

        if (StringUtils.isBlank(addReq.getServiceTemplateId())) {
            throw new BusinessException("400", "请选择服务内容！");
        }
        ServiceRecord entity = mapperFacade.map(addReq, ServiceRecord.class);
        try {
            TemplateService service = new TemplateService();
            service.setServiceTemplateId(addReq.getServiceTemplateId());
            TemplateService templateService = serviceRepository.selectOne(service);
            AuthUserMeta authUserMeta = authUserService.currentUserMeta(true);
            String authUserId = authUserMeta.getAuthUserId();
            BaseUtil.setFieldValueNotNull(entity);
            entity.setServiceRecordId(SnowflakeIdWorker.uniqueSequenceStr());
            entity.setOperatorId(authUserId);
            entity.setStatus(1);
            entity.setTempName(templateService.getServiceName());
        } catch (Exception e) {
            log.error("新增->设置为空的属性失败 {} , {} ", e.getMessage(), e);
        }
        serviceRecordRepository.insert(entity);
    }

    /**
     * 主键ID集合批量
     *
     * @param mainIdList 主键ID集合
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/2/2
     */
    @Override
    public void batchDeleteItem(List<String> mainIdList) {
        if (CollectionUtils.isEmpty(mainIdList)) {
            return;
        }
        serviceRecordRepository.batchUpdateDeleteStatus(baseConstant.getDeleteStatus(), mainIdList);
    }

    /**
     * 分页查询
     *
     * @param pageReq 分页查询Req
     * @return Pagination
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/2/15
     */
    @Override
    public Pagination<ServiceRecordResp> queryByPage(
            ServiceRecordReq pageReq) {
        log.info(">>>>>>>>>>>>>>>>>分页查询Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(pageReq));
        //构建查询条件
        Example pageExample = new Example(ServiceRecord.class);
        Example.Criteria pageCriteria = pageExample.createCriteria();
        itemCriteriaBuilder.rigidCriteria(pageCriteria, true);
        setPageCriteria(pageCriteria, pageReq);
        pageExample.orderBy("createTime").desc();
        //开始分页
        Page<Object> page = PageHelper.startPage(pageReq.getCurrentPage(), pageReq.getItemsPerPage());
        List<ServiceRecord> pageList = serviceRecordRepository.selectByExample(pageExample);
        if (CollectionUtils.isEmpty(pageList)) {
            return PageBuilder.buildPageResult(page, new ArrayList<>());
        }
        List<ServiceRecordResp> respList =
                mapperFacade.mapAsList(pageList, ServiceRecordResp.class);
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
    private void setPageCriteria(Example.Criteria pageCriteria, ServiceRecordReq pageReq) {

        if (!CheckParam.isNull(pageReq.getOldSketchId())) {
            pageCriteria.andEqualTo("oldSketchId", pageReq.getOldSketchId());
        }

        if (!CheckParam.isNull(pageReq.getTempName())) {
            pageCriteria.andLike("tempName", pageReq.getTempName());
        }


        if (!CheckParam.isNull(pageReq.getStartTime())) {
            pageCriteria.andGreaterThanOrEqualTo("startTime", pageReq.getStartTime());
        }

        if (!CheckParam.isNull(pageReq.getEndTime())) {
            pageCriteria.andLessThanOrEqualTo("startTime", pageReq.getEndTime());
        }

        if (!CheckParam.isNull(pageReq.getStatus())) {
            pageCriteria.andEqualTo("status", pageReq.getStatus());
        }
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
    public void updateItem(ServiceRecordUpdateReq updateReq) {
        log.info(">>>>>>>>>>>>>>>>>更新请求参数 {} <<<<<<<<<<<<<<<<", JSON.toJSONString(updateReq));
        String mainId = updateReq.getServiceRecordId();
        Example example = Example.builder(ServiceRecord.class).where(Sqls.custom()
                .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                .andEqualTo("serviceRecordId", mainId))
                .build();
        ServiceRecord result = serviceRecordRepository.selectOneByExample(example);
        if (CheckParam.isNull(result)) {
            return;
        }
        setNeedUpdateItem(result, updateReq);
        AuthUserMeta authUserMeta = authUserService.currentUserMeta(true);
        String authUserId = authUserMeta.getAuthUserId();
        result.setOperatorId(authUserId);
        result.setUpdateTime(LocalDateTime.now());
        serviceRecordRepository.updateByPrimaryKeySelective(result);
    }

    /**
     * 设置需要更新的字段
     *
     * @param updateReq 更新参数
     * @param entity    产业
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/30
     */
    private void setNeedUpdateItem(ServiceRecord entity,
                                   ServiceRecordUpdateReq updateReq) {
        if (!CheckParam.isNull(updateReq.getOldSketchId())) {
            entity.setOldSketchId(updateReq.getOldSketchId());
        }
        if (!CheckParam.isNull(updateReq.getOtherSketch())) {
            entity.setOtherSketch(updateReq.getOtherSketch());
        }
        if (!CheckParam.isNull(updateReq.getStartTime())) {
            entity.setStartTime(updateReq.getStartTime());
        }
        if (!CheckParam.isNull(updateReq.getDuration())) {
            entity.setDuration(updateReq.getDuration());
        }
        if (!CheckParam.isNull(updateReq.getServiceTemplateId())) {
            TemplateService service = new TemplateService();
            service.setServiceTemplateId(updateReq.getServiceTemplateId());
            TemplateService templateService = serviceRepository.selectOne(service);
            entity.setTempName(templateService.getServiceName());
            entity.setServiceTemplateId(updateReq.getServiceTemplateId());
        }

    }

    /**
     * 接单
     *
     * @param serviceRecordId
     */
    @Override
    public void receiving(String serviceRecordId) {
        Example ServiceRecordIdExample = Example.builder(ServiceRecord.class).where(Sqls.custom().andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus()).andEqualTo("serviceRecordId", serviceRecordId)).build();
        ServiceRecord record = serviceRecordRepository.selectOneByExample(ServiceRecordIdExample);
        if (null == record || null == record.getStatus() || record.getStatus() != 1) {
            throw new BusinessException("500", "无此订单或已被其他人接单");
        }
        record.setStatus(2);
        AuthUserMeta authUserMeta = authUserService.currentUserMeta(true);
        String authUserId = authUserMeta.getAuthUserId();
        record.setAuthUserId(authUserId);
        record.setOperatorId(authUserId);
        record.setUpdateTime(LocalDateTime.now());
        serviceRecordRepository.updateByPrimaryKeySelective(record);
    }

    @Override
    public void finish(String serviceRecordId) {
        Example ServiceRecordIdExample = Example.builder(ServiceRecord.class).where(Sqls.custom().andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus()).andEqualTo("serviceRecordId", serviceRecordId)).build();
        ServiceRecord record = serviceRecordRepository.selectOneByExample(ServiceRecordIdExample);
        if (null == record || null == record.getStatus() || record.getStatus() != 2) {
            throw new BusinessException("500", "无此订单或订单已完成！");
        }
        record.setStatus(3);
        record.setUpdateTime(LocalDateTime.now());
        AuthUserMeta authUserMeta = authUserService.currentUserMeta(true);
        String authUserId = authUserMeta.getAuthUserId();
        record.setOperatorId(authUserId);
        serviceRecordRepository.updateByPrimaryKeySelective(record);
    }

    @Override
    public void cancel(String serviceRecordId) {
        Example ServiceRecordIdExample = Example.builder(ServiceRecord.class).where(Sqls.custom().andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus()).andEqualTo("serviceRecordId", serviceRecordId)).build();
        ServiceRecord record = serviceRecordRepository.selectOneByExample(ServiceRecordIdExample);
        if (null == record || null == record.getStatus() || record.getStatus() != 1) {
            throw new BusinessException("500", "无此订单或订单已接单！");
        }
        AuthUserMeta authUserMeta = authUserService.currentUserMeta(true);
        String authUserId = authUserMeta.getAuthUserId();
        record.setOperatorId(authUserId);
        record.setStatus(9);
        serviceRecordRepository.updateByPrimaryKeySelective(record);
    }
}
