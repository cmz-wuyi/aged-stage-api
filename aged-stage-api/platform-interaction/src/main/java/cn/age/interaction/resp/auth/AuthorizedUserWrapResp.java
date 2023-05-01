package cn.age.interaction.resp.auth;

import cn.age.interaction.resp.user.AuthUserSketchResp;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 登陆返回Resp
 * @date 2019-08-21
 */
@Data
public class AuthorizedUserWrapResp implements Serializable {


    private static final long serialVersionUID = 6568420548580082674L;

    /**
      * 权限集合
      */
    private List<String> permissions;

    /**
     * 角色名称集合
     */
    private List<String> roles;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 用户配置
     */
    private AuthUserConfigResp config;

    /**
     * 用户配置
     */
    private AuthorizedUserResp user;

    /**
     * 用户信息
     */
    private AuthUserSketchResp sketch;

    /**
     * token
     */
    private String token;


}
