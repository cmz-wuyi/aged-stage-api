package cn.age.interaction.internal.auth;

import lombok.Data;

import java.io.*;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @Title: ActiveUser
 * @ProjectName aged-stage
 * @Description: 当前在线的用户
 * @date 2019/1/5 14:27
 */
@Data
public class ActiveUser implements Serializable {

    private static final long serialVersionUID = -4922553689168848759L;


    /**
     * 唯一编号
     */
    private String id;

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
     * ip地址
     */
    private String ip;

    /**
     * token(加密后)
     */
    private String token;

    /**
     * 登录时间
     */
    private String loginTime;

    /**
     * 登录地点
     */
    private String loginAddress;
}
