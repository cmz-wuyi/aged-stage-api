package cn.age.interaction.resp.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description:
 * @date 2019-08-13
 */
@Data
public class AuthUserPageQueryResp implements Serializable {

    private static final long serialVersionUID = 6406324700781728599L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户主键ID
     */
    private String authUserId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss",name = "updateTime")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 最后登录时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    /**
     * 描述
     */
    private String description;

    /**
     * 性别 0:男1:女,2:保密
     */
    private Integer sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 权限认证缓存key 可以为空
     */
    private String authCacheKey;

    /**
     * 角色ID
     */
    private String authRoleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 排序字段 可以为空
     */
    private String sortField;

    /**
     * 排序顺序 可以为空
     */
    private String sortOrder;

    /**
     * 用户信息
     */
    private AuthUserSketchResp sketch;

}
