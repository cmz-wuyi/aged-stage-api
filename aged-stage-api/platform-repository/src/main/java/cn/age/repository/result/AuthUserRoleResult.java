package cn.age.repository.result;

import cn.age.common.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @packageName cn.singer.repository.entity
 * @Description:
 * @date 2019-08-12
 */
@Data
public class AuthUserRoleResult extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -4322094612076860322L;


    /**
     * 用户ID
     */
    private Long userId;


    /**
     * 角色ID
     */
    private Long authRoleId;

}
