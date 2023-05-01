package cn.age.interaction.resp;

import cn.age.common.interaction.base.BaseResp;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 服务配置实体
*/
@Data
public class TemplateServiceResp extends BaseResp implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 业务主键ID
     */
    private String serviceTemplateId;

    /**
     * 服务内容_名称
     */
    private String serviceName;

    /**
     * 服务费
     */
    private String serviceMoney;

    /**
     * 是否删除 1删除 2未删除
     */
    private Integer deleteStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 操作人
     */
    private String operatorId;

}
