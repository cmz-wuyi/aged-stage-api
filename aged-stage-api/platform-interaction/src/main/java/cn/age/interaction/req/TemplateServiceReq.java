package cn.age.interaction.req;

import cn.age.common.interaction.base.page.BasePageReq;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 服务模板请求实体
 */
@Data
public class TemplateServiceReq extends BasePageReq implements Serializable {

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
