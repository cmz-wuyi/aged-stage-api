package cn.age.interaction.resp;

import cn.age.common.interaction.base.BaseResp;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.*;

/**
* 服务记录实体
* @title: ServiceRecord.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Data
public class ServiceRecordResp extends BaseResp implements Serializable {


    private static final long serialVersionUID = -7496218157643926848L;

    /**
     * 业务主键ID->"serviceRecordId"
     */
    private String serviceRecordId;


    /**
     * 老人ID
     */
    private String oldSketchId;

    /**
     * 其他详情
     */
    private String otherSketch;

    /**
     * 开始时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 服务时长
     */
    private String duration;

    /**
     * 服务模板ID
     */
    private String serviceTemplateId;

    /**
     * 服务名称
     */
    private String tempName;

}
