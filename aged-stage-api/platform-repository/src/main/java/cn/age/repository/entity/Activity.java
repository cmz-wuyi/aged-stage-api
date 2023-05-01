package cn.age.repository.entity;

import cn.age.common.entity.BaseEntity;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import com.alibaba.fastjson.annotation.JSONField;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.*;


/**
* 床位实体
* @title: BedSketch.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Entity
@Data
@Table(name="se_activity")
public class Activity extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 8586330925401464010L;


    /**
     * 业务主键ID->activityId"
     */
    @Column(name = "activity_id")
    private String activityId = SnowflakeIdWorker.uniqueSequenceStr();


    /**
     * 活动名称
     */
    @Column(name = "activity_name")
    private String activityName;

    /**
     * 活动内容
     */
    @Column(name = "activity_content")
    private String activityContent;


    /**
     * 状态 true 有效 false 无效
     */
    @Column(name = "status")
    private Boolean status = Boolean.TRUE;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 活动人数
     */
    @Column(name = "activity_Num")
    private Integer activityNum;

    /**
     * 活动内容
     */
    @Column(name = "activity_place")
    private String activityPlace;


    /**
     * 活动开始时间
     */
    @Column(name = "activity_start_time")
    @JSONField(format="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime activityStartTime;


    /**
     * 活动结束时间
     */
    @Column(name = "activity_end_time")
    @JSONField(format="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime activityEndTime;
}
