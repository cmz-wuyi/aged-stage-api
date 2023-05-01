package cn.age.interaction.req;

import cn.age.common.interaction.base.page.BasePageReq;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.*;

/**
* 护工请假实体
* @title: NursingTimeOff.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Data
public class NursingTimeOffReq extends BasePageReq implements Serializable {


    private static final long serialVersionUID = 1799682363545139084L;

    /**
     * 业务主键ID->"nursingTimeOffId"
     */
    private String nursingTimeOffId;


    /**
     * 护工ID
     */
    private String authUserId;

    /**
     * 请假开始时间
     */
    @JSONField(format="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDateTime timeOffBegin;

    /**
     * 请假结束时间
     */
    @JSONField(format="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDateTime timeOffEnd;

    /**
     * 请假缘由
     */
    private String timeOffRemark;

}
