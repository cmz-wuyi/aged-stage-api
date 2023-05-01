package cn.age.service;

import cn.age.common.entity.Tree;
import cn.age.interaction.req.menu.AuthMenuAddReq;
import cn.age.interaction.req.menu.AuthMenuTreeQueryReq;
import cn.age.interaction.req.menu.AuthMenuUpdateReq;
import cn.age.interaction.resp.menu.AuthMenuTreeQueryWrapResp;
import cn.age.interaction.resp.menu.AuthMenuTreeResp;

import java.util.List;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 系统菜单Service
 * @date 2019-08-26
 */
public interface AuthMenuService {


    /**
     * 更新菜单
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-09-05
     * @param authMenuUpdateReq 更新菜单Req
     * @return
     */
    void updateMenu(AuthMenuUpdateReq authMenuUpdateReq);

    /**
     * 删除菜单
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-09-05
     * @param authMenuIdList 需要被删除的菜单的主键ID
     */
    void deleteMenu(List<String> authMenuIdList);

    /**
     * 新增菜单
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-09-05
     * @param authMenuAddReq 新增菜单请求参数
     */
    void addMenu(AuthMenuAddReq authMenuAddReq);

    /**
     * 权限菜单树集合查询
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-26
     * @param authMenuTreeQueryReq 权限菜单树查询Req
     * @return AuthMenuTreeListQueryWrapResp

    AuthMenuTreeListQueryWrapResp queryMenuTreeList(AuthMenuTreeQueryReq authMenuTreeQueryReq); */


    /**
     * 查询部门树
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-26
     * @param authMenuTreeQueryReq
     * @return AuthMenuTreeQueryWrapResp
     */
    Tree<AuthMenuTreeResp> queryAllAuthMenuTree(AuthMenuTreeQueryReq authMenuTreeQueryReq);

    /**
     * 查询所有部门树集合
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-26
     * @param authMenuTreeQueryReq
     * @return AuthMenuTreeQueryWrapResp
     */
    AuthMenuTreeQueryWrapResp queryAllAuthMenuTreeList(AuthMenuTreeQueryReq authMenuTreeQueryReq);
}
