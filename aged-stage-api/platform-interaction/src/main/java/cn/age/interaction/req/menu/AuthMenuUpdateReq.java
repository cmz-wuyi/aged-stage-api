package cn.age.interaction.req.menu;

import cn.age.common.validation.NotEmpty;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 菜单更新Req
 * @date 2019-09-05
 */
@Data
public class AuthMenuUpdateReq implements Serializable {

    private static final long serialVersionUID = -6177450587260735174L;




    /**
     * 菜单主键ID
     */
    @JSONField(name = "menuId")
    @NotEmpty(message = "菜单主键ID不可为空")
    private String authMenuId;

    /**
     * 菜单名称
     */
    @JSONField(name = "menuName")
    private String menuName;


    /**
     * 父级菜单ID
     */
    @JSONField(name = "parentId")
    private String parentId;

    /**
     * 前端path / 即跳转路由
     */
    @JSONField(name = "path")
    private String path;


    /**
     * 对应Vue组件
     */
    @JSONField(name = "component")
    private String component;

    /**
     * 权限
     */
    @JSONField(name = "perms")
    private String perms;

    /**
     * 菜单图标
     */
    @JSONField(name = "icon")
    private String menuIcon;

    /**
     * 菜单类型 0->按钮,1->菜单
     */
    @JSONField(name = "type")
    private String menuType;

    /**
     * 序号
     */
    @JSONField(name = "orderNum")
    private Integer orderNum;
}
