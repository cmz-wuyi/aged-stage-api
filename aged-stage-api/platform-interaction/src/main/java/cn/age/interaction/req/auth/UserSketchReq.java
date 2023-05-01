package cn.age.interaction.req.auth;

import lombok.Data;

import java.io.*;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.interaction.req.auth
 * @Description: 用户简略信息请求
 * @date 2021-05-25
 */
@Data
public class UserSketchReq implements Serializable {


    private static final long serialVersionUID = -7722639909178391290L;


    /**
     * 用户主键ID
     */
    private String authUserId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 业务主键ID
     */
    private String  authUserSketchId;

    /**
     * 用户简略信息类型 绑定其他的业务ID
     */
    private String sketchOtherId;

    /**
     * 关联其他表的类型
     */
    private String sketchOtherType;

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
