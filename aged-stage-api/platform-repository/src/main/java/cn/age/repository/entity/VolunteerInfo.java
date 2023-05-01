package cn.age.repository.entity;

import cn.age.common.entity.BaseEntity;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.*;


/**
* 护工薪资实体
* @title: NursingSalary.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Entity
@Data
@Table(name="volunteer_info")
public class VolunteerInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务主键ID->"nursingSalaryId"
     */
    @Column(name = "volunteer_info_id")
    private String volunteerInfoId = SnowflakeIdWorker.uniqueSequenceStr();



    /**
     * 主要工作职责
     */
    @Column(name = "main_info")
    private String mainInfo;

    /**
     * 实付
     */
    @Column(name = "num")
    private Integer num;

    /**
     * 兼职类型 1.全职 2.兼职
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 工作时间
     */
    @Column(name = "service_time")
    private String serviceTime;

    /**
     * 发布人联系方式
     */
    @Column(name = "phone")
    private String phone;


}
