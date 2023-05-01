package cn.age.interaction.req;

import cn.age.common.interaction.base.page.BasePageReq;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.*;

/**
* 事故记录实体
* @title: AccidentRecord.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Data
public class ServiceRecordReq extends BasePageReq implements Serializable {


    private static final long serialVersionUID = -2080619803909548882L;


    /**
     * 业务主键ID->"serviceRecordId"
     */
    private String serviceRecordId;


    /**
     * 老人ID
     */
    private String oldSketchId;

    /**
     * 状态 1.未接单 2.进行中 3.已完成 9.已取消
     */
    private Integer status;



    /**
     * 开始时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;


    /**
     * 结束时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;

    private String tempName;
}
