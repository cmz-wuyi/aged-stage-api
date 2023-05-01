package cn.age.service.impl;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.common.constants.BaseConstant;
import cn.age.common.enums.ErrorCode;
import cn.age.common.exception.ApiException;
import cn.age.common.exception.BusinessException;
import cn.age.common.utils.collection.CollectionUtils;
import cn.age.common.utils.common.BaseUtil;
import cn.age.common.utils.common.CheckParam;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import cn.age.interaction.helper.PageBuilder;
import cn.age.interaction.internal.auth.AuthUserMeta;
import cn.age.interaction.req.NursingTimeOffAddReq;
import cn.age.interaction.req.NursingTimeOffReq;
import cn.age.interaction.req.NursingTimeOffUpdateReq;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.NursingTimeOffResp;
import cn.age.repository.entity.NursingTimeOff;
import cn.age.repository.repository.NursingTimeOffRepository;
import cn.age.repository.result.AuthPermissionQueryResult;
import cn.age.service.AuthUserService;
import cn.age.service.NursingTimeOffService;
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
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.service
 * @Description: 首页分类相关服务方法实现
 * @date 2021-04-23
 */
@Service("nursingTimeOffService")
@Slf4j
public class NursingTimeOffServiceImpl implements NursingTimeOffService {

    @Resource
    private NursingTimeOffRepository nursingTimeOffRepository;

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

    /**
     * 新增
     *
     * @param addReq 新增Req
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/2/15
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addItem(NursingTimeOffAddReq addReq) throws Exception {
        log.info(">>>>>>>>>>>>>>>>>新增Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(addReq));
        NursingTimeOff entity = mapperFacade.map(addReq, NursingTimeOff.class);

        if (addReq.getTimeOffBegin().isAfter(addReq.getTimeOffEnd())) {
            throw new BusinessException("500", "请假开始时间需在请假结束时间之前！");
        }
        AuthUserMeta authUserMeta = authUserService.currentUserMeta(true);
        String authUserId = authUserMeta.getAuthUserId();
        BaseUtil.setFieldValueNotNull(entity);
        entity.setNursingTimeOffId(SnowflakeIdWorker.uniqueSequenceStr());
        entity.setOperatorId(authUserId);
        entity.setStatus(1);
        nursingTimeOffRepository.insert(entity);

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
        nursingTimeOffRepository.batchUpdateDeleteStatus(baseConstant.getDeleteStatus(), mainIdList);
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
    public Pagination<NursingTimeOffResp> queryByPage(
            NursingTimeOffReq pageReq) {
        log.info(">>>>>>>>>>>>>>>>>分页查询Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(pageReq));
        //构建查询条件
        Example pageExample = new Example(NursingTimeOff.class);
        Example.Criteria pageCriteria = pageExample.createCriteria();

        //判断当前用户是否具备查询所有的老人信息的权限，如不具备则设置为只能查询当前登录用户所属的信息
        //nursingTimeOff:queryAll
        String currentAuthUserId = authUserService.currentAuthUserId();
        List<AuthPermissionQueryResult> permList =
                authUserService.currentUserPermList(currentAuthUserId);
        Optional<AuthPermissionQueryResult> queryAllOptional =
                permList.stream().filter(item -> StrUtil.equalsIgnoreCase(item.getPerms(), "nursingTimeOff:queryAll"))
                        .findFirst();
        if (!queryAllOptional.isPresent()) {
            pageCriteria.andEqualTo("authUserId", currentAuthUserId);
        }

        itemCriteriaBuilder.rigidCriteria(pageCriteria, true);
        setPageCriteria(pageCriteria, pageReq);
        pageExample.orderBy("createTime").desc();
        //开始分页
        Page<Object> page = PageHelper.startPage(pageReq.getCurrentPage(), pageReq.getItemsPerPage());
        List<NursingTimeOff> pageList = nursingTimeOffRepository.selectByExample(pageExample);
        if (CollectionUtils.isEmpty(pageList)) {
            return PageBuilder.buildPageResult(page, new ArrayList<>());
        }
        List<NursingTimeOffResp> respList =
                mapperFacade.mapAsList(pageList, NursingTimeOffResp.class);
        Integer startIndex = (pageReq.getItemsPerPage() * pageReq.getCurrentPage()) - pageReq.getItemsPerPage() + 1;
        AtomicInteger idBeginIndex = new AtomicInteger(startIndex);
        respList.stream().forEach(item -> {
            item.setId(Integer.valueOf(idBeginIndex.getAndIncrement()).longValue());
        });
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
    private void setPageCriteria(Example.Criteria pageCriteria, NursingTimeOffReq pageReq) {

        if (!CheckParam.isNull(pageReq.getAuthUserId())) {
            pageCriteria.andEqualTo("authUserId", pageReq.getAuthUserId());
        }

        if (!CheckParam.isNull(pageReq.getTimeOffBegin())) {
            pageCriteria.andGreaterThanOrEqualTo("timeOffEnd", pageReq.getTimeOffBegin());
        }

        if (!CheckParam.isNull(pageReq.getTimeOffEnd())) {
            pageCriteria.andLessThanOrEqualTo("timeOffBegin", pageReq.getTimeOffEnd());
        }

        if (!CheckParam.isNull(pageReq.getTimeOffRemark())) {
            pageCriteria.andEqualTo("timeOffRemark", pageReq.getTimeOffRemark());
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
    public void updateItem(NursingTimeOffUpdateReq updateReq) {
        log.info(">>>>>>>>>>>>>>>>>更新请求参数 {} <<<<<<<<<<<<<<<<", JSON.toJSONString(updateReq));
        String mainId = updateReq.getNursingTimeOffId();
        Example example = Example.builder(NursingTimeOff.class).where(Sqls.custom()
                        .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                        .andEqualTo("nursingTimeOffId", mainId))
                .build();
        NursingTimeOff result = nursingTimeOffRepository.selectOneByExample(example);
        if (CheckParam.isNull(result)) {
            return;
        }
        if (updateReq.getTimeOffBegin().isAfter(updateReq.getTimeOffEnd())) {
            throw new BusinessException("500", "请假开始时间应在结束时间之前！");
        }
        setNeedUpdateItem(result, updateReq);
        nursingTimeOffRepository.updateByPrimaryKeySelective(result);
    }

    /**
     * 设置需要更新的字段
     *
     * @param updateReq 更新参数
     * @param entity    产业
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/30
     */
    private void setNeedUpdateItem(NursingTimeOff entity,
                                   NursingTimeOffUpdateReq updateReq) {
        if (!CheckParam.isNull(updateReq.getAuthUserId())) {
            entity.setAuthUserId(updateReq.getAuthUserId());
        }
        if (!CheckParam.isNull(updateReq.getTimeOffBegin())) {
            entity.setTimeOffBegin(updateReq.getTimeOffBegin());
        }
        if (!CheckParam.isNull(updateReq.getTimeOffEnd())) {
            entity.setTimeOffEnd(updateReq.getTimeOffEnd());
        }
        if (!CheckParam.isNull(updateReq.getTimeOffRemark())) {
            entity.setTimeOffRemark(updateReq.getTimeOffRemark());
        }
    }

    @Override
    public void approved(String mainId, Integer status) {
        Example example = Example.builder(NursingTimeOff.class).where(Sqls.custom()
                        .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                        .andEqualTo("nursingTimeOffId", mainId))
                .build();
        NursingTimeOff result = nursingTimeOffRepository.selectOneByExample(example);
        if (CheckParam.isNull(result)) {
            return;
        }
        result.setStatus(status);
        nursingTimeOffRepository.updateByPrimaryKeySelective(result);
    }
}
