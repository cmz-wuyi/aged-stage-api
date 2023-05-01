package cn.age.repository.result;

import java.io.Serializable;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 最近七位用户访问统计结果
 * @date 2019-08-22
 */
public class LastSevenUserVisitResult implements Serializable {

    /**
      * 访问次数
      */
    private Integer count;


    /**
     * 访问日期
     */
    private Integer days;
}
