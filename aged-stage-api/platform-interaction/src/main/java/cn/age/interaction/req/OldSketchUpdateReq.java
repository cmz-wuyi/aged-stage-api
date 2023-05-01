package cn.age.interaction.req;

import java.time.LocalDateTime;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.*;

/**
* 老人信息实体
* @title: OldSketch.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Data
public class OldSketchUpdateReq implements Serializable {


    private static final long serialVersionUID = -5621685997184323762L;

    /**
     * 业务主键ID->"oldSketchId"
     */
    private String oldSketchId;


    /**
     * 姓名
     */
    private String realName;

    /**
     * 性别，跟随枚举
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 身体状况
     */
    private String bodyState;

    /**
     * 户籍
     */
    private String censusRegister;

    /**
     * 身份证号码
     */
    private String idCardNum;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系人号码
     */
    private String contactsPhone;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 床位号
     */
    private String bedNum;

    /**
     * 护工编号
     */
    private String nursingWorkerNum;

    /**
     * 入住时间
     */
    @JSONField(format="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDateTime intakeTime;

    /**
     * 出院时间
     */
    @JSONField(format="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDateTime dischargedTime;

}
