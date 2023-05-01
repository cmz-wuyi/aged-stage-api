package cn.age.service.impl;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.common.constants.BaseConstant;
import cn.age.common.utils.collection.CollectionUtils;
import cn.age.common.utils.common.BaseUtil;
import cn.age.common.utils.common.CheckParam;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import cn.age.interaction.helper.PageBuilder;
import cn.age.interaction.internal.auth.AuthUserMeta;
import cn.age.interaction.req.VolunteerInfoAddReq;
import cn.age.interaction.req.VolunteerInfoReq;
import cn.age.interaction.req.VolunteerInfoUpdateReq;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.VolunteerInfoResp;
import cn.age.repository.entity.VolunteerInfo;
import cn.age.repository.repository.VolunteerInfoRepository;
import cn.age.service.AuthUserService;
import cn.age.service.VolunteerInfoService;
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
@Service("nursingSalaryService")
@Slf4j
public class VolunteerInfoServiceImpl implements VolunteerInfoService {

    @Resource
    private VolunteerInfoRepository volunteerInfoRepository;

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
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/15
    * @param addReq 新增Req
    */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
        public void addItem(VolunteerInfoAddReq addReq){
        log.info(">>>>>>>>>>>>>>>>>新增Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(addReq));
        VolunteerInfo entity = mapperFacade.map(addReq, VolunteerInfo.class);
        try {
            AuthUserMeta authUserMeta = authUserService.currentUserMeta(true);
            String authUserId = authUserMeta.getAuthUserId();
            BaseUtil.setFieldValueNotNull(entity);
            entity.setVolunteerInfoId(SnowflakeIdWorker.uniqueSequenceStr());
            entity.setOperatorId(authUserId);
        } catch (Exception e) {
            log.error("新增->设置为空的属性失败 {} , {} ",e.getMessage(),e);
        }
        volunteerInfoRepository.insert(entity);
    }

    /**
    * 主键ID集合批量
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/2
    * @param mainIdList 主键ID集合
    */
    @Override
    public void batchDeleteItem(List<String> mainIdList){
        if(CollectionUtils.isEmpty(mainIdList)) {
            return;
        }
        volunteerInfoRepository.batchUpdateDeleteStatus(baseConstant.getDeleteStatus(),mainIdList);
    }

    /**
    * 分页查询
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/15
    * @param  pageReq 分页查询Req
    * @return Pagination
    */
    @Override
    public Pagination<VolunteerInfoResp> queryByPage(
        VolunteerInfoReq pageReq){
        log.info(">>>>>>>>>>>>>>>>>分页查询Req {} <<<<<<<<<<<<<<<<", JSON.toJSONString(pageReq));
        //构建查询条件
        Example pageExample = new Example(VolunteerInfo.class);
        Example.Criteria pageCriteria = pageExample.createCriteria();
        itemCriteriaBuilder.rigidCriteria(pageCriteria,true);
        setPageCriteria(pageCriteria,pageReq);

        pageExample.orderBy("createTime").desc();
        //开始分页
        Page<Object> page = PageHelper.startPage(pageReq.getCurrentPage(), pageReq.getItemsPerPage());
        List<VolunteerInfo> pageList = volunteerInfoRepository.selectByExample(pageExample);
        if (CollectionUtils.isEmpty(pageList)) {
            return PageBuilder.buildPageResult(page,new ArrayList<>());
        }
        List<VolunteerInfoResp> respList =
            mapperFacade.mapAsList(pageList, VolunteerInfoResp.class);
        int startIndex = (pageReq.getItemsPerPage() * pageReq.getCurrentPage()) - pageReq.getItemsPerPage() + 1;
        AtomicInteger idBeginIndex = new AtomicInteger(startIndex);
            respList.forEach(item -> item.setId(Integer.valueOf(idBeginIndex.getAndIncrement()).longValue()));
       return PageBuilder.buildPageResult(page,respList);
    }

    /**
    * 设置分页条件
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/5/31
    * @param pageCriteria 查询条件
    * @param pageReq 分页插件
    * @return
    */
    private void setPageCriteria(Example.Criteria pageCriteria, VolunteerInfoReq pageReq){



         if(!CheckParam.isNull(pageReq.getMainInfo())){
            pageCriteria.andLike("mainInfo","%"+pageReq.getMainInfo()+"%");
         }

         if(!CheckParam.isNull(pageReq.getType())){
            pageCriteria.andEqualTo("type",pageReq.getType());
         }

         if(!CheckParam.isNull(pageReq.getServiceTime())){
            pageCriteria.andLike("serviceTime",pageReq.getServiceTime());
         }

         if(!CheckParam.isNull(pageReq.getNum())){
            pageCriteria.andEqualTo("num",pageReq.getNum());
         }
    }

    /**
    * 更新
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/4/2
    * @param updateReq 更新请求参数
    */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateItem(VolunteerInfoUpdateReq updateReq){
        log.info(">>>>>>>>>>>>>>>>>更新请求参数 {} <<<<<<<<<<<<<<<<", JSON.toJSONString(updateReq));
        String mainId = updateReq.getVolunteerInfoId();
        Example example = Example.builder(VolunteerInfo.class).where(Sqls.custom()
        .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
        .andEqualTo("volunteerInfoId", mainId))
        .build();
        VolunteerInfo result = volunteerInfoRepository.selectOneByExample(example);
        if (CheckParam.isNull(result)) {
            return;
        }
        setNeedUpdateItem(result,updateReq);
        volunteerInfoRepository.updateByPrimaryKeySelective(result);
    }

    /**
    * 设置需要更新的字段
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/3/30
    * @param updateReq 更新参数
    * @param entity 产业
    */
    private void setNeedUpdateItem(VolunteerInfo entity,
                                   VolunteerInfoUpdateReq updateReq){
        if(!CheckParam.isNull(updateReq.getMainInfo())){
            entity.setMainInfo(updateReq.getMainInfo());
        }
        if(!CheckParam.isNull(updateReq.getNum())){
            entity.setNum(updateReq.getNum());
        }
        if(!CheckParam.isNull(updateReq.getServiceTime())){
            entity.setServiceTime(updateReq.getServiceTime());
        }
        if(!CheckParam.isNull(updateReq.getType())){
            entity.setType(updateReq.getType());
        }
    }
}
