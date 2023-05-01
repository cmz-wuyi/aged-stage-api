package cn.age.interaction.req;

import java.time.LocalDateTime;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.*;

/**
* 事故记录实体
* @title: AccidentRecord.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Data
public class ServiceRecordUpdateReq implements Serializable {


    private static final long serialVersionUID = 3937241560080436176L;

    /**
     * 业务主键ID->"accidentRecordId"
     */
    private String serviceRecordId;


    /**
     * 老人ID
     */
    private String oldSketchId;

    /**
     * 服务名称
     */
    private String otherSketch;

    /**
     * 开始时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;

    /**
     * 时长
     */
    private String duration;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 服务模板ID
     */
    private String serviceTemplateId;

    /**
     * 接单人
     */
    private String authUserId;

}
