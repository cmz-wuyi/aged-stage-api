package cn.age.interaction.resp;

import cn.age.common.interaction.base.BaseResp;
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
public class VolunteerInfoResp extends BaseResp implements Serializable {


    private static final long serialVersionUID = 5845051977394799816L;

    /**
     * 业务主键ID->"nursingSalaryId"
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
