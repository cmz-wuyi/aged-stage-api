package cn.age.repository.entity;

import java.io.Serializable;
import java.util.Date;

import cn.age.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @TableName se_old_service
 */
@Entity
@Data
@Table(name="se_old_service")
public class OldService extends BaseEntity implements Serializable {

    /**
     * 业务ID
     */
    private String serviceId;

    /**
     * 服务模板ID
     */
    private String tempId;

    /**
     * 服务老人Id
     */
    private String oldId;

    /**
     * 服务时间
     */
    private Date serviceTime;

    /**
     * 服务时长
     */
    private String serviceDuration;

    /**
     * 志愿者ID
     */
    private String nursingId;

    /**
     * 服务状态：1未开始 2服务中 3已结束 4已取消
     */
    private Byte status;

    private static final long serialVersionUID = 1L;
}