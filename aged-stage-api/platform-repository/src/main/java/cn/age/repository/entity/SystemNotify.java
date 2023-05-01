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
 * @TableName system_notify
 */
@Entity
@Data
@Table(name="system_notify")
public class SystemNotify extends BaseEntity implements Serializable {

    /**
     * 业务ID
     */
    private String notifyId;

    /**
     * 通知内容
     */
    private String content;

    /**
     * 要通知的人
     */
    private String userId;

    /**
     * 老人ID
     */
    private String oldId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 1 未读 2 已读 3 已删除
     */
    private Integer status;

    /**
     * 创建人
     */
    private String createUserId;

    private static final long serialVersionUID = 1L;
}