package cn.age.repository.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 用户权限查询结果
 * @date 2019-08-20
 */
@Data
public class AuthPermissionQueryResult implements Serializable {

    private static final long serialVersionUID = -7448602895866322178L;


    /**
     * 菜单名称
     */
    private String authMenuId;

    /**
     * 父级菜单ID
     */
    private String parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 前端path / 即跳转路由
     */
    private String path;


    /**
     * 对应Vue组件
     */
    private String component;

    /**
     * 权限
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 菜单类型 0->按钮,1->菜单
     */
    private String menuType;

    /**
     * 序号
     */
    private Integer orderNum;


}
