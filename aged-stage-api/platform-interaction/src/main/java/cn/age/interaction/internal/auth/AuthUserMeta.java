package cn.age.interaction.internal.auth;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 当前用户的缓存信息
 * @date 2019-08-29
 */
@Data
public class AuthUserMeta extends AuthDataMeta implements Serializable {

    private static final long serialVersionUID = -5417862398152424200L;

    /**
     * 用户ID
     */
    private String id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色ID
     */
    private String authRoleId;

    /**
     * 角色代码
     */
    private String roleCode;

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
     * 密码
     */
    private String password;

    /**
     * 密码盐
     */
    private String authSalt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 性别 0:男1:女,2:保密
     */
    private Integer sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 最后登录时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 描述
     */
    private String description;


    /**
     * 部门名称
     */
    private String departmentName;

}
