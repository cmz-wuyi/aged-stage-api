package cn.age.interaction.resp.statistics;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 访问量统计Resp
 * @date 2019-08-23
 */
@Data
public class VisitCountResp implements Serializable {

    private static final long serialVersionUID = 7447015171852340899L;


    /**
      * 当天访问数量
      */
    private Long count;


    /**
     * 日期
     */
    private String days;

}
