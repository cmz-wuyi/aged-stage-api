package cn.age.interaction.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.*;

/**
* 老人信息实体
* @title: OldSketch.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Data
public class OldSketchAddReq implements Serializable {


    private static final long serialVersionUID = -2005885231678461049L;

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
     * 志愿者编号
     */
    private String nursingWorkerNum;

    /**
     * 登记时间
     */
    @JSONField(format="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDateTime intakeTime;

}
