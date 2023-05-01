package cn.age.interaction.req.auth;

import cn.age.common.validation.Length;
import cn.age.common.validation.NotEmpty;
import lombok.Data;

import java.io.*;
import java.util.List;

/**
 * @author create by Singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 后台用户新增Req
 * @date 2019-08-31
 */
@Data
public class AuthUserAddReq implements Serializable {

    private static final long serialVersionUID = 5931132329242443717L;

    /**
     * 用户主键ID
     */
    private String authUserId ;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 密码 最少六位
     */
    @Length(min = 6,message = "用户密码最少6位")
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
     * 性别 0:男1:女,2:保密
     */
    private Integer sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 角色ID
     */
     private String authRoleId;

    /**
     * 用户简略信息
     */
    @NotEmpty(message = "用户简略信息->不可为空")
    private UserSketchReq sketchData;

}
