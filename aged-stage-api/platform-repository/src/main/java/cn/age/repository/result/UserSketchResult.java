package cn.age.repository.result;

import lombok.Data;

import java.io.*;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.repository.result
 * @Description: 用户简略信息Result
 * @date 2021-12-14
 */
@Data
public class UserSketchResult implements Serializable {

    private static final long serialVersionUID = 4972851009452668042L;

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
