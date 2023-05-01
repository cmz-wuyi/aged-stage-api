package cn.age.common.utils;

import tk.mybatis.mapper.entity.Example;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @Title: CriteriaBuilder
 * @ProjectName aged-stage
 * @Description: 查询条件构建器
 * @date 2018/11/16 14:15
 */
public class CriteriaBuilder {



    /**
     * 设置固有的查询条件
     * @author: create by Singer - Singer email:singer-coder@qq.com
     * @date 2018/11/16 14:16
     * @param criteria
     */
    public static void rigidCriteria(Example.Criteria criteria){
        criteria.andEqualTo("deleteStatus",2);
    }
}
