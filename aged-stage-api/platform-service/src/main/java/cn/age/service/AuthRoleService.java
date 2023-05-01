package cn.age.service;

import cn.age.interaction.req.role.AuthRoleAddReq;
import cn.age.interaction.req.role.AuthRolePageReq;
import cn.age.interaction.req.role.AuthRoleUpdateReq;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.role.AuthRolePageQueryResp;
import cn.age.interaction.resp.role.AuthRoleResp;

import java.util.List;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 系统角色Service
 * @date 2019-08-23
 */
public interface AuthRoleService {


    /**
     * 分页查询用户角色
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-23
     * @param authRolePageReq 分页查询用户角色参数
     * @return Pagination
     */
    Pagination<AuthRolePageQueryResp> queryAuthRoleByPage(AuthRolePageReq authRolePageReq);


    /**
     * 查询角色列表---不分页
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/9/2
     * @return List
     */
    List<AuthRoleResp> queryAllRoles();

    /**
     * 询角色对应的权限菜单
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/9/4
     * @param authRoleId 角色ID
     * @return List
     */
    List<String> queryMenuIdList(String authRoleId);

    /**
     * 更新信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/30
     * @param updateReq 更新请求参数
     */
    void updateItem(AuthRoleUpdateReq updateReq);

    /**
     * 删除角色
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/9/4
     * @param authRoleIdList
     */
    void batchDeleteItem(String authRoleIdList);

    /**
     * 判断角色代码是否存在
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/5/21
     * @param roleCode 角色代码
     * @return Boolean
     */
    Boolean roleCodeExisted(String roleCode);

    /**
     * 判断角色名称是否存在
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/5/21
     * @param roleName 角色名称
     * @return Boolean
     */
    Boolean roleNameExisted(String roleName);

    /**
     * 校验角色代码的唯一性
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/4/27
     * @param roleCode 角色代码
     */
    void verifyRoleCode(String roleCode);


    /**
      * 新增角色
      * @author: create by singer - Singer email:singer-coder@qq.com
      * @date 2021/3/30
      * @param addReq 新增请求参数
      */
    void addItem(AuthRoleAddReq addReq);
}
