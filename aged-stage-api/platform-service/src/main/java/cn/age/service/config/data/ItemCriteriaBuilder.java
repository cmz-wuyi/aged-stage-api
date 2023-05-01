package cn.age.service.config.data;

import cn.age.common.utils.common.CheckParam;
import cn.age.service.AuthUserService;
import cn.age.common.constants.BaseConstant;
import cn.age.common.enums.factor.ContrastFactorEnum;
import cn.age.common.enums.auth.data.DataRoleCodeEnum;
import cn.age.common.interaction.base.data.BaseDataPageReq;
import cn.age.common.interaction.base.data.ContrastReq;
import cn.age.common.utils.collection.CollectionUtils;
import cn.age.interaction.internal.auth.AuthUserMeta;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @Title: CriteriaBuilder
 * @ProjectName aged-stage
 * @Description: 数据权限查询条件构建器
 * @date 2018/11/16 14:15
 */
@Component("itemCriteriaBuilder")
public class ItemCriteriaBuilder {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private BaseConstant baseConstant;

    /**
     * 设置基础数据查询条件
     * @author: create by Singer - Singer email:singer-coder@qq.com
     * @date 2018/11/16 14:16
     * @param criteria
     */
    public void rigidCriteria(Example.Criteria criteria){
        criteria.andEqualTo("deleteStatus",baseConstant.getUnDeleteStatus());
    }

    /**
     * 设置基础数据查询条件
     * @author: create by Singer - Singer email:singer-coder@qq.com
     * @date 2018/11/16 14:16
     * @param criteria
     * @param needSetDataAuth 是否需要设置数据权限
     */
    public void rigidCriteria(Example.Criteria criteria,Boolean needSetDataAuth){
        criteria.andEqualTo("deleteStatus",baseConstant.getUnDeleteStatus());
        if(!needSetDataAuth){
            return;
        }
        AuthUserMeta authUserMeta = authUserService.currentUserMeta(false);
        if(CheckParam.isNull(authUserMeta)){
            return;
        }
        setAuthDataCriteria(criteria,authUserMeta);
    }

    /**
     * 设置排序条件
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/5/29
     * @param example 查询条件
     * @param pageReq 请求参数
     */
    public void setSortFactor(Example example, BaseDataPageReq pageReq){
        String ascSortName = pageReq.getAscSortName();
        String descSortName = pageReq.getDescSortName();
        if(!CheckParam.isNull(ascSortName)){
            example.orderBy(ascSortName).asc();
        }
        if(!CheckParam.isNull(descSortName)){
            example.orderBy(descSortName).desc();
        }
        example.orderBy("createTime").desc();
    }

    /**
      * 设置对比条件
      * @author: create by singer - Singer email:singer-coder@qq.com
      * @date 2021/5/29
      * @param criteria 查询条件
      * @param pageReq 请求参数
      */
    public void setContrastFactor(Example.Criteria criteria, BaseDataPageReq pageReq){
        String beginTime = pageReq.getBeginTime();
        String endTime = pageReq.getEndTime();

        if(!CheckParam.isNull(beginTime)){
            criteria.andEqualTo("beginTime",beginTime);
        }
        if(!CheckParam.isNull(endTime)){
            criteria.andEqualTo("endTime",endTime);
        }
        //对比查询条件
        List<ContrastReq> contrastList = pageReq.getContrastList();
        String ascSortName = pageReq.getAscSortName();
        String descSortName = pageReq.getDescSortName();
        if(!CollectionUtils.isEmpty(contrastList)){
            contrastList.stream().filter(item -> !CheckParam.isNull(item)).forEach(item -> {
                ContrastFactorEnum contrastFactor = CheckParam.isNull(item.getContrastFactor()) ? ContrastFactorEnum.EQUALS : item.getContrastFactor();
                String itemName = item.getItemName();
                String contrastValue = CheckParam.isNull(item.getContrastValue()) ? BigInteger.ZERO.toString() : item.getContrastValue();
                if(!CheckParam.isNull(itemName)){
                    //等于条件
                    if(contrastFactor.compareTo(ContrastFactorEnum.EQUALS) == 0){
                        criteria.andEqualTo(itemName,contrastValue);
                    }
                    //大于条件
                    if(contrastFactor.compareTo(ContrastFactorEnum.GREATER_THAN) == 0){
                        criteria.andGreaterThan(itemName,contrastValue);
                    }
                    //小于条件
                    if(contrastFactor.compareTo(ContrastFactorEnum.LESS_THAN) == 0){
                        criteria.andLessThan(itemName,contrastValue);
                    }
                    //大于等于
                    if(contrastFactor.compareTo(ContrastFactorEnum.GREATER_THAN_OR_EQUAL_TO) == 0){
                        criteria.andGreaterThanOrEqualTo(itemName,contrastValue);
                    }
                    //小于等于
                    if(contrastFactor.compareTo(ContrastFactorEnum.LESS_THAN_OR_EQUAL_TO) == 0){
                        criteria.andGreaterThanOrEqualTo(itemName,contrastValue);
                    }
                }
            });
        }
    }

    /**
      * 设置数据隔离查询条件
      * @author: create by singer - Singer email:singer-coder@qq.com
      * @date 2021/5/25
      * @param criteria 查询条件
      * @param authUserMeta 用户缓存信息
      */
    public void setAuthDataCriteria(Example.Criteria criteria,AuthUserMeta authUserMeta){
        String roleCode = authUserMeta.getRoleCode();
        //处理管理员账号的权限
        if(StrUtil.equalsIgnoreCase(roleCode,DataRoleCodeEnum.ADMIN_ACCOUNT.toString())){
            return;
        }
    }

}
