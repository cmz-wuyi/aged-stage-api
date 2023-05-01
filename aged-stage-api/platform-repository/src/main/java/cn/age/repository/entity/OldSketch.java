package cn.age.repository.entity;

import cn.age.common.entity.BaseEntity;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import com.alibaba.fastjson.annotation.JSONField;
import java.time.LocalDateTime;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.*;


/**
* 老人信息实体
* @title: OldSketch.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Entity
@Data
@Table(name="old_sketch")
public class OldSketch extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务主键ID->"oldSketchId"
     */
    @Column(name = "old_sketch_id")
    private String oldSketchId = SnowflakeIdWorker.uniqueSequenceStr();


    /**
     * 姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 性别，跟随枚举
     */
    @Column(name = "gender")
    private String gender;

    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 身体状况
     */
    @Column(name = "body_state")
    private String bodyState;

    /**
     * 户籍
     */
    @Column(name = "census_register")
    private String censusRegister;

    /**
     * 身份证号码
     */
    @Column(name = "id_card_num")
    private String idCardNum;

    /**
     * 联系人
     */
    @Column(name = "contacts")
    private String contacts;

    /**
     * 联系人号码
     */
    @Column(name = "contacts_phone")
    private String contactsPhone;

    /**
     * 家庭住址
     */
    @Column(name = "home_address")
    private String homeAddress;

    /**
     * 志愿者编号
     */
    @Column(name = "nursing_worker_num")
    private String nursingWorkerNum;

    /**
     * 登记时间
     */
    @Column(name = "intake_time")
    private LocalDateTime intakeTime;


}
