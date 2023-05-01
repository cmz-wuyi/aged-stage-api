package cn.age.interaction.req;

import cn.age.common.interaction.base.page.BasePageReq;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.*;

/**
* 护工薪资实体
* @title: NursingSalary.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Data
public class VolunteerInfoReq extends BasePageReq implements Serializable {


    private static final long serialVersionUID = -3082534768415505175L;


    /**
     * 业务主键ID->"volunteerInfoId"
     */
    private String volunteerInfoId;


    /**
     * 主要工作职责
     */
    private String mainInfo;

    /**
     * 实付
     */

    private Integer num;

    /**
     * 兼职类型 1.全职 2.兼职
     */

    private Integer type;

    /**
     * 工作时间
     */
    private String serviceTime;

    /**
     * 发布人联系方式
     */
    private String phone;

}
