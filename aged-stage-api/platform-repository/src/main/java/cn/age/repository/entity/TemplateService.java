package cn.age.repository.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import cn.age.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @TableName se_template_service
 */
@Entity
@Data
@Table(name="se_template_service")
public class TemplateService extends BaseEntity implements Serializable {

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

    private static final long serialVersionUID = 1L;
}