package cn.age.interaction.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.io.*;

/**
* 服务记录实体
* @title: AccidentRecord.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Data
public class ServiceRecordAddReq implements Serializable {


    private static final long serialVersionUID = -6866404434494765171L;


    /**
     * 业务主键ID->"accidentRecordId"
     */
    private String serviceRecordId;


    /**
     * 老人ID
     */
    private String oldSketchId;

    /**
     * 备注
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

    /**
     * 服务名称
     */
    private String tempName;

}
