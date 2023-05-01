package cn.age.interaction.req;

import cn.age.common.interaction.base.page.BasePageReq;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.io.*;

/**
* 床位实体
* @title: BedSketch.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Data
public class ActivityReq extends BasePageReq implements Serializable {


    private static final long serialVersionUID = -6950082399018830918L;

    /**
     * 业务主键ID->"activityId"
     */
    private String activityId;


    /**
     * 床位编号
     */
    private String activityName;

    /**
     * 是否有效
     */
    private Boolean status;

    /**
     * 床位备注
     */
    private String remark;


    /**
     * 活动人数
     */
    private Integer activityNum;

    /**
     * 活动内容
     */
    private String activityPlace;


    /**
     * 活动开始时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime activityStartTime;


    /**
     * 活动结束时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime activityEndTime;

    /**
     * 活动内容
     */
    private String activityContent;

}
