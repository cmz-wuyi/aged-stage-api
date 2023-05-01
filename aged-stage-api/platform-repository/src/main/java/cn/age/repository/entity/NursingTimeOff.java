package cn.age.repository.entity;

import cn.age.common.entity.BaseEntity;
import cn.age.common.utils.spring.SnowflakeIdWorker;

import java.time.LocalDateTime;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.*;


/**
* 护工请假实体
* @title: NursingTimeOff.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Entity
@Data
@Table(name="nursing_time_off")
public class NursingTimeOff extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务主键ID->"nursingTimeOffId"
     */
    @Column(name = "nursing_time_off_id")
    private String nursingTimeOffId = SnowflakeIdWorker.uniqueSequenceStr();


    /**
     * 护工ID
     */
    @Column(name = "auth_user_id")
    private String authUserId;

    /**
     * 请假开始时间
     */
    @Column(name = "time_off_begin")
    private LocalDateTime timeOffBegin;

    /**
     * 请假结束时间
     */
    @Column(name = "time_off_end")
    private LocalDateTime timeOffEnd;

    /**
     * 请假缘由
     */
    @Column(name = "time_off_remark")
    private String timeOffRemark;

    /**
     * 审核状态
     */
    @Column(name = "status")
    private Integer status;

}
