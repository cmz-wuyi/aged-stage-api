package cn.age.repository.entity;

import cn.age.common.entity.BaseEntity;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.*;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @packageName cn.singer.repository.entity
 * @Description: 角色-菜单中间实体
 * @date 2019-08-12
 */
@Entity
@Data
@Table(name="auth_role_menu")
public class AuthRoleMenu extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 6572903078111541733L;


    /**
     * 角色-部门中间实体主键ID
     */
    @Column(name = "auth_role_menu_id",nullable = false)
    private String authRoleMenuId = SnowflakeIdWorker.uniqueSequenceStr();

    /**
     * 角色ID
     */
    @Column(name = "auth_role_id",nullable = false)
    private String authRoleId;


    /**
     * 菜单ID
     */
    @Column(name = "menu_id",nullable = false)
    private String menuId;

}
