package cn.age.repository.result;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 用户分页查询结果
 * @date 2019-08-13
 */
@Data
public class AuthUserPageQueryResult implements Serializable {


    private static final long serialVersionUID = -7646035909879732704L;


    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 用户锁定状态 1:锁定,2:有效
     */
    private String lockFlag;

    /**
     * 0-正常，1-删除
     */
    private String deleteStatus;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 非数据库字段
     * 岗位名称
     */
    private String jobName;
}
