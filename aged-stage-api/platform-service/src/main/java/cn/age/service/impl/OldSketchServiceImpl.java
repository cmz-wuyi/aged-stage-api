package cn.age.service.impl;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.common.constants.BaseConstant;
import cn.age.common.utils.collection.CollectionUtils;
import cn.age.common.utils.common.BaseUtil;
import cn.age.common.utils.common.CheckParam;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import cn.age.interaction.helper.PageBuilder;
import cn.age.interaction.internal.auth.AuthUserMeta;
import cn.age.interaction.req.OldSketchAddReq;
import cn.age.interaction.req.OldSketchReq;
import cn.age.interaction.req.OldSketchUpdateReq;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.OldSketchResp;
import cn.age.repository.entity.OldSketch;
import cn.age.repository.repository.ActivityRepository;
import cn.age.repository.repository.OldSketchRepository;
import cn.age.repository.result.AuthPermissionQueryResult;
import cn.age.service.AuthUserService;
import cn.age.service.OldSketchService;
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
@Service("oldSketchService")
@Slf4j
public class OldSketchServiceImpl implements OldSketchService {

    @Resource
    private OldSketchRepository oldSketchRepository;

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
    public void addItem(OldSketchAddReq addReq) {
        log.info(">>>>>>>>>>>>>>>>>新增Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(addReq));
        OldSketch entity = mapperFacade.map(addReq, OldSketch.class);
        try {
            AuthUserMeta authUserMeta = authUserService.currentUserMeta(true);
            String authUserId = authUserMeta.getAuthUserId();
            BaseUtil.setFieldValueNotNull(entity);
            entity.setOldSketchId(SnowflakeIdWorker.uniqueSequenceStr());
            entity.setOperatorId(authUserId);
        } catch (Exception e) {
            log.error("新增->设置为空的属性失败 {} , {} ", e.getMessage(), e);
        }
        oldSketchRepository.insert(entity);
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
        oldSketchRepository.batchUpdateDeleteStatus(baseConstant.getDeleteStatus(), mainIdList);
    }


    /**
     * 查询所有老人信息
     *
     * @return java.util.List
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/12/14
     */
    @Override
    public List<OldSketchResp> allOldSketch() {
        Example example = new Example(OldSketch.class);
        Example.Criteria criteria = example.createCriteria();
        itemCriteriaBuilder.rigidCriteria(criteria, true);
        List<OldSketch> dataList = oldSketchRepository.selectByExample(example);
        if (CollectionUtils.isEmpty(dataList)) {
            return new ArrayList<>();
        }
        return mapperFacade.mapAsList(dataList, OldSketchResp.class);
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
    public Pagination<OldSketchResp> queryByPage(
            OldSketchReq pageReq) {
        log.info(">>>>>>>>>>>>>>>>>分页查询Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(pageReq));
        //构建查询条件
        Example pageExample = new Example(OldSketch.class);
        Example.Criteria pageCriteria = pageExample.createCriteria();

        //判断当前用户是否具备查询所有的老人信息的权限，如不具备则设置为只能查询当前登录用户所属的信息
        String currentAuthUserId = authUserService.currentAuthUserId();
        List<AuthPermissionQueryResult> permList =
                authUserService.currentUserPermList(currentAuthUserId);
        Optional<AuthPermissionQueryResult> queryAllOptional =
                permList.stream().filter(item -> StrUtil.equalsIgnoreCase(item.getPerms(), "oldSketch:queryAll"))
                        .findFirst();
        if (!queryAllOptional.isPresent()) {
            pageCriteria.andEqualTo("nursingWorkerNum", currentAuthUserId);
        }//oldSketch:queryAll

        itemCriteriaBuilder.rigidCriteria(pageCriteria, true);
        setPageCriteria(pageCriteria, pageReq);
        pageExample.orderBy("createTime").desc();
        //开始分页
        Page<Object> page = PageHelper.startPage(pageReq.getCurrentPage(), pageReq.getItemsPerPage());
        List<OldSketch> pageList = oldSketchRepository.selectByExample(pageExample);
        if (CollectionUtils.isEmpty(pageList)) {
            return PageBuilder.buildPageResult(page, new ArrayList<>());
        }
        List<OldSketchResp> respList =
                mapperFacade.mapAsList(pageList, OldSketchResp.class);
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
    private void setPageCriteria(Example.Criteria pageCriteria, OldSketchReq pageReq) {

        if (!CheckParam.isNull(pageReq.getRealName())) {
            pageCriteria.andLike("realName", "%" + pageReq.getRealName() + "%");
        }

        if (!CheckParam.isNull(pageReq.getGender())) {
            pageCriteria.andEqualTo("gender", pageReq.getGender());
        }

        if (!CheckParam.isNull(pageReq.getAge())) {
            pageCriteria.andLike("age", "%" + pageReq.getAge() + "%");
        }

        if (!CheckParam.isNull(pageReq.getBodyState())) {
            pageCriteria.andLike("bodyState", "%" + pageReq.getBodyState() + "%");
        }

        if (!CheckParam.isNull(pageReq.getCensusRegister())) {
            pageCriteria.andLike("censusRegister", "%" + pageReq.getCensusRegister() + "%");
        }

        if (!CheckParam.isNull(pageReq.getIdCardNum())) {
            pageCriteria.andLike("idCardNum", "%" + pageReq.getIdCardNum() + "%");
        }

        if (!CheckParam.isNull(pageReq.getContacts())) {
            pageCriteria.andLike("contacts", "%" + pageReq.getContacts() + "%");
        }

        if (!CheckParam.isNull(pageReq.getContactsPhone())) {
            pageCriteria.andLike("contactsPhone", "%" + pageReq.getContactsPhone() + "%");
        }

        if (!CheckParam.isNull(pageReq.getHomeAddress())) {
            pageCriteria.andLike("homeAddress", "%" + pageReq.getHomeAddress() + "%");
        }


        if (!CheckParam.isNull(pageReq.getNursingWorkerNum())) {
            pageCriteria.andEqualTo("nursingWorkerNum", pageReq.getNursingWorkerNum());
        }

        if (!CheckParam.isNull(pageReq.getIntakeTime())) {
            pageCriteria.andEqualTo("intakeTime", pageReq.getIntakeTime());
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
    public void updateItem(OldSketchUpdateReq updateReq) {
        log.info(">>>>>>>>>>>>>>>>>更新请求参数 {} <<<<<<<<<<<<<<<<", JSON.toJSONString(updateReq));
        String mainId = updateReq.getOldSketchId();
        Example example = Example.builder(OldSketch.class).where(Sqls.custom()
                .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                .andEqualTo("oldSketchId", mainId))
                .build();
        OldSketch result = oldSketchRepository.selectOneByExample(example);
        if (CheckParam.isNull(result)) {
            return;
        }
        setNeedUpdateItem(result, updateReq);
        oldSketchRepository.updateByPrimaryKeySelective(result);
    }

    /**
     * 设置需要更新的字段
     *
     * @param updateReq 更新参数
     * @param entity    产业
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/30
     */
    private void setNeedUpdateItem(OldSketch entity,
                                   OldSketchUpdateReq updateReq) {
        if (!CheckParam.isNull(updateReq.getRealName())) {
            entity.setRealName(updateReq.getRealName());
        }
        if (!CheckParam.isNull(updateReq.getGender())) {
            entity.setGender(updateReq.getGender());
        }
        if (!CheckParam.isNull(updateReq.getAge())) {
            entity.setAge(updateReq.getAge());
        }
        if (!CheckParam.isNull(updateReq.getBodyState())) {
            entity.setBodyState(updateReq.getBodyState());
        }
        if (!CheckParam.isNull(updateReq.getCensusRegister())) {
            entity.setCensusRegister(updateReq.getCensusRegister());
        }
        if (!CheckParam.isNull(updateReq.getIdCardNum())) {
            entity.setIdCardNum(updateReq.getIdCardNum());
        }
        if (!CheckParam.isNull(updateReq.getContacts())) {
            entity.setContacts(updateReq.getContacts());
        }
        if (!CheckParam.isNull(updateReq.getContactsPhone())) {
            entity.setContactsPhone(updateReq.getContactsPhone());
        }
        if (!CheckParam.isNull(updateReq.getHomeAddress())) {
            entity.setHomeAddress(updateReq.getHomeAddress());
        }
        if (!CheckParam.isNull(updateReq.getNursingWorkerNum())) {
            entity.setNursingWorkerNum(updateReq.getNursingWorkerNum());
        }
        if (!CheckParam.isNull(updateReq.getIntakeTime())) {
            entity.setIntakeTime(updateReq.getIntakeTime());
        }
    }
}
