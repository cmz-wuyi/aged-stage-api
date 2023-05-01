package cn.age.interaction.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.*;
import java.time.LocalDateTime;

/**
* 床位实体
* @title: BedSketch.java
* @author create by Singer - Singer email:singer-coder@qq.com
* @date 2019/4/24 11:13
*/
@Data
public class ActivityUpdateReq implements Serializable {


    private static final long serialVersionUID = -6666503423384452774L;

    /**
     * 业务主键ID->"activityId"
     */
    private String activityId;


    /**
     * 活动名称
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
     * 活动地点
     */
    private String activityPlace;

    /**
     * 活动内容
     */
    private String activityContent;


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

}
