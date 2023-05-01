package cn.age.interaction.resp.user;

import lombok.Data;

import javax.persistence.Column;
import java.io.*;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.interaction.resp.user
 * @Description: 系统用户简略信息
 * @date 2021-04-06
 */
@Data
public class UserSketchResp implements Serializable {


    private static final long serialVersionUID = -8180662378191616163L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户ID
     */
    private String authUserId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 角色代码
     */
    private String roleCode;
}
