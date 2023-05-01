package cn.age.interaction.resp.user;

import lombok.Data;

import java.io.*;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.interaction.resp.user
 * @Description: 系统用户简略信息
 * @date 2021-04-06
 */
@Data
public class AuthUserSketchResp implements Serializable {

    private static final long serialVersionUID = -3145475107507666377L;

    /**
     * 业务主键ID
     */
    private String  authUserSketchId;

    /**
     * 用户业务主键ID
     */
    private String  authUserId;

    /**
     * 用户名
     */
    private String  userName;

    /**
     * 性别，跟随枚举
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系地址
     */
    private String address;

}
