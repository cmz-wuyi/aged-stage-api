package cn.age.repository.entity;

import cn.age.common.entity.BaseEntity;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import com.alibaba.fastjson.annotation.JSONField;
import java.time.LocalDateTime;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.*;


/**
* 服务记录实体
* @title: AccidentRecord.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Entity
@Data
@Table(name="service_record")
public class ServiceRecord extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务主键ID->"service_record_id"
     */
    @Column(name = "service_record_id")
    private String serviceRecordId = SnowflakeIdWorker.uniqueSequenceStr();


    /**
     * 老人ID
     */
    @Column(name = "old_sketch_id")
    private String oldSketchId;

    /**
     * 事故详情
     */
    @Column(name = "other_sketch")
    private String otherSketch;

    /**
     * 发生时间
     */
    @Column(name = "start_time")
    private LocalDateTime startTime;

    /**
     * 模板id
     */
    @Column(name = "service_template_id")
    private String serviceTemplateId;

    /**
     * 时长
     */
    @Column(name = "duration")
    private String duration;

    /**
     * 接单人
     */
    @Column(name = "auth_user_id")
    private String authUserId;

    /**
     * 派单状态 1.待接单 2.进行 3.已完成 9.已取消
     */
    private Integer status;

    @Column(name = "temp_name")
    private String tempName;

}
