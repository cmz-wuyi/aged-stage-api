package cn.age.interaction.req;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.*;

/**
 * 护工薪资实体
 *
 * @author create by Singer - Singer email:singer-coder@qq.com
 * @title: NursingSalary.java
 * @date 2019/4/24 11:13
 */
@Data
public class VolunteerInfoAddReq implements Serializable {


    private static final long serialVersionUID = 3748219123297896637L;


    /**
     * 业务主键ID->"nursingSalaryId"
     */
    private String volunteerInfoId;


    /**
     * 主要工作职责
     */
    private String mainInfo;

    /**
     * 招募人数
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
