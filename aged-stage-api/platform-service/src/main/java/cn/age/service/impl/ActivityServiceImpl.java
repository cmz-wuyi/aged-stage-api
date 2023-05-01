package cn.age.service.impl;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.common.constants.BaseConstant;
import cn.age.common.utils.collection.CollectionUtils;
import cn.age.common.utils.common.BaseUtil;
import cn.age.common.utils.common.CheckParam;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import cn.age.interaction.helper.PageBuilder;
import cn.age.interaction.internal.auth.AuthUserMeta;
import cn.age.interaction.req.ActivityAddReq;
import cn.age.interaction.req.ActivityReq;
import cn.age.interaction.req.ActivityUpdateReq;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.ActivityResp;
import cn.age.repository.entity.Activity;
import cn.age.repository.repository.ActivityRepository;
import cn.age.service.ActivityService;
import cn.age.service.AuthUserService;
import cn.age.service.config.data.ItemCriteriaBuilder;
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
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.service
 * @Description: 首页分类相关服务方法实现
 * @date 2021-04-23
 */
@Service("bedSketchService")
@Slf4j
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityRepository activityRepository;

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
    public void addItem(ActivityAddReq addReq) {
        log.info(">>>>>>>>>>>>>>>>>新增Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(addReq));
        Activity entity = mapperFacade.map(addReq, Activity.class);
        try {
            AuthUserMeta authUserMeta = authUserService.currentUserMeta(true);
            String authUserId = authUserMeta.getAuthUserId();
            BaseUtil.setFieldValueNotNull(entity);
            entity.setActivityId(SnowflakeIdWorker.uniqueSequenceStr());
            entity.setOperatorId(authUserId);
        } catch (Exception e) {
            log.error("新增->设置为空的属性失败 {} , {} ", e.getMessage(), e);
        }
        activityRepository.insert(entity);
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
        activityRepository.batchUpdateDeleteStatus(baseConstant.getDeleteStatus(), mainIdList);
    }


    /**
     * 查询所有床位信息
     *
     * @param req 查询Req
     * @return java.util.List
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/12/14
     */
    @Override
    public List<ActivityResp> allBedSketch(ActivityReq req) {
        Example example = new Example(Activity.class);
        Example.Criteria criteria = example.createCriteria();
        setCriteria(criteria, req);
        itemCriteriaBuilder.rigidCriteria(criteria, true);
        List<Activity> dataList = activityRepository.selectByExample(example);
        if (CollectionUtils.isEmpty(dataList)) {
            return new ArrayList<>();
        }
        return mapperFacade.mapAsList(dataList, ActivityResp.class);
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
    public Pagination<ActivityResp> queryByPage(
            ActivityReq pageReq) {
        log.info(">>>>>>>>>>>>>>>>>分页查询Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(pageReq));
        //构建查询条件
        Example pageExample = new Example(Activity.class);
        Example.Criteria pageCriteria = pageExample.createCriteria();
        itemCriteriaBuilder.rigidCriteria(pageCriteria, true);
        setCriteria(pageCriteria, pageReq);
        pageExample.orderBy("createTime").desc();
        //开始分页
        Page<Object> page = PageHelper.startPage(pageReq.getCurrentPage(), pageReq.getItemsPerPage());
        List<Activity> pageList = activityRepository.selectByExample(pageExample);
        if (CollectionUtils.isEmpty(pageList)) {
            return PageBuilder.buildPageResult(page, new ArrayList<>());
        }
        List<ActivityResp> respList =
                mapperFacade.mapAsList(pageList, ActivityResp.class);
        Integer startIndex = (pageReq.getItemsPerPage() * pageReq.getCurrentPage()) - pageReq.getItemsPerPage() + 1;
        AtomicInteger idBeginIndex = new AtomicInteger(startIndex);
        respList.stream().forEach(item -> {
            item.setId(Integer.valueOf(idBeginIndex.getAndIncrement()).longValue());
        });
        return PageBuilder.buildPageResult(page, respList);
    }

    /**
     * 设置查询条件
     *
     * @param pageCriteria 查询条件
     * @param pageReq      查询插件
     * @return
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/5/31
     */
    private void setCriteria(Example.Criteria pageCriteria, ActivityReq pageReq) {

        if (!CheckParam.isNull(pageReq.getStatus())) {
            pageCriteria.andEqualTo("status", pageReq.getStatus());
        }

        if (!CheckParam.isNull(pageReq.getActivityName())) {
            pageCriteria.andEqualTo("activityName", pageReq.getActivityName());
        }

        if (!CheckParam.isNull(pageReq.getActivityPlace())) {
            pageCriteria.andLike("activityPlace", "%" + pageReq.getActivityPlace() + "%");
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
    public void updateItem(ActivityUpdateReq updateReq) {
        log.info(">>>>>>>>>>>>>>>>>更新请求参数 {} <<<<<<<<<<<<<<<<", JSON.toJSONString(updateReq));
        String mainId = updateReq.getActivityId();
        Example example = Example.builder(Activity.class).where(Sqls.custom()
                .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                .andEqualTo("activityId", mainId))
                .build();
        Activity result = activityRepository.selectOneByExample(example);
        if (CheckParam.isNull(result)) {
            return;
        }
        setNeedUpdateItem(result, updateReq);
        activityRepository.updateByPrimaryKeySelective(result);
    }

    /**
     * 设置需要更新的字段
     *
     * @param updateReq 更新参数
     * @param entity    产业
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/30
     */
    private void setNeedUpdateItem(Activity entity,
                                   ActivityUpdateReq updateReq) {
        if (!CheckParam.isNull(updateReq.getActivityName())) {
            entity.setActivityName(updateReq.getActivityName());
        }
        if (!CheckParam.isNull(updateReq.getActivityPlace())) {
            entity.setActivityPlace(updateReq.getActivityPlace());
        }
        if (!CheckParam.isNull(updateReq.getActivityContent())) {
            entity.setActivityContent(updateReq.getActivityContent());
        }
        if (!CheckParam.isNull(updateReq.getActivityEndTime())) {
            entity.setActivityEndTime(updateReq.getActivityEndTime());
        }
        if (!CheckParam.isNull(updateReq.getActivityStartTime())) {
            entity.setActivityStartTime(updateReq.getActivityStartTime());
        }
        if (!CheckParam.isNull(updateReq.getActivityNum())) {
            entity.setActivityNum(updateReq.getActivityNum());
        }
        if (!CheckParam.isNull(updateReq.getRemark())) {
            entity.setRemark(updateReq.getRemark());
        }
    }
}
