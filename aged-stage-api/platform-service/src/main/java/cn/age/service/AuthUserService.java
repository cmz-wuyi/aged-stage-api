package cn.age.service;


import cn.age.common.entity.VueRouter;
import cn.age.interaction.internal.auth.ActiveUser;
import cn.age.interaction.internal.auth.AuthUserMeta;
import cn.age.interaction.req.auth.AuthLoginReq;
import cn.age.interaction.req.auth.AuthUserAddReq;
import cn.age.interaction.req.auth.AuthUserPageReq;
import cn.age.interaction.req.auth.AuthUserUpdateReq;
import cn.age.interaction.req.auth.UserSketchReq;
import cn.age.interaction.req.user.AuthUserConfigUpdateReq;
import cn.age.interaction.req.user.UserProfileUpdateReq;
import cn.age.interaction.resp.auth.AuthorizedUserResp;
import cn.age.interaction.resp.auth.AuthorizedUserWrapResp;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.role.AuthRoleResp;
import cn.age.interaction.resp.statistics.StatisticsVisitCountResp;
import cn.age.interaction.resp.user.AuthUserPageQueryResp;
import cn.age.interaction.resp.user.AuthUserSketchResp;
import cn.age.interaction.resp.user.UserSketchResp;
import cn.age.repository.entity.AuthUser;
import cn.age.repository.result.AuthMenuQueryResult;
import cn.age.repository.result.AuthPermissionQueryResult;
import cn.age.repository.result.AuthUserResult;

import java.util.List;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @packageName aged-stage
 * @Description: 用户Service
 * @date 2019-08-13
 */
public interface AuthUserService {

    /**
     * 根据当前用户ID查询当前用户所有权限
     * @author: create by singer - Singer email:singer-coder@qq.com

     * @param authUserId 用户ID
     * @return java.util.List
     */
    List<AuthPermissionQueryResult> currentUserPermList(String authUserId);

    /**
     * 查询用户的详情信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/12/14
     * @param authUserId 用户ID
     * @return cn.age.interaction.resp.user.AuthUserSketchResp
     */
    AuthUserSketchResp querySketchByUserId(String authUserId);

    /**
     * 返回当前用户的业务主键ID
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/5/22
     * @return java.lang.String
     */
    String currentAuthUserId();

    /**
     * 返回当前用户的角色代码
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/5/22
     * @return java.lang.String
     */
    String currentUserRoleCode();

    /**
     * 当前用户的缓存信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-29
     * @param needThrow 为空是否需要抛出
     * @return AuthUserCache
     */
    AuthUserMeta currentUserMeta(Boolean needThrow);

    /**
     *  统计系统访问总量
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-22
     * @param  userName 用户名
     * @return StatisticsVisitCountResp
     */
    StatisticsVisitCountResp statisticsVisitCount(String userName);

    /**
     * 根据用户名查询用户能访问的菜单
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-22
     * @param userName 用户名称
     * @return java.util.List
     */
    List<VueRouter<AuthMenuQueryResult>> queryVueRouterByUserName(String userName);

    /**
     * 根据角色代码查询用户信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/12/14
     * @param roleCode 角色代码
     * @return java.util.List
     */
    List<UserSketchResp> queryUserSketchByRoleCode(String roleCode);

    /**
     * 用户信息分页查询
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-21
     * @param authUserPageReq 用户信息分页查询Req
     * @return Pagination
     */
    Pagination<AuthUserPageQueryResp> queryUserByPage(AuthUserPageReq authUserPageReq);

    /**
     * 根据用户名称查询用户信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-21
     * @param userName 用户名称
     * @return AuthorizedUserResp
     */
    AuthorizedUserResp queryAuthorizedUserByUserName(String userName);

    /**
     * 根据用户名称判断用户是否存在
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-21
     * @param userName 用户名称
     * @return Boolean
     */
    Boolean judgeUserExistByUserName(String userName);


    /**
     * 当前用户登出
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-21
     * @param authUserId 当前用户的ID
     */
    void authUserLogOut(String authUserId);


    /**
     * 用户登陆逻辑
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-21
     * @param loginReq 登录请求参数
     * @return cn.age.interaction.resp.auth.AuthorizedUserWrapResp
     */
    AuthorizedUserWrapResp authUserLogin(AuthLoginReq loginReq);

    /**
     * 根据当前用户名查询当前活跃的用户
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-23
     * @param userName 当前用户名
     * @return List
     */
    List<ActiveUser> queryActiveUserByUserName(String userName);

    /**
     * 查询当前所有在线的用户
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-23
     * @return List
     */
    List<ActiveUser> queryAllActiveUser();

    /**
     * 根据用户名查询用户信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-21
     * @param userName 用户名
     * @return AuthUserResult
     */
    AuthUserResult queryAuthUserByName(String userName);

    /**
     * 系统定制修改
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/8/29
     * @param userConfig 系统定制修改参数
     */
    void updateUserConfig(AuthUserConfigUpdateReq userConfig);

    /**
     * 更新用户资料
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/4/18
     * @param userProfileUpdateReq 更新用户资料请求参数
     */
    void updateAuthUserProfile(UserProfileUpdateReq userProfileUpdateReq);

    /**
     * 查询所有用户的简略信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/4/6
     * @return List
     */
    List<AuthUserSketchResp> queryAllAuthUserSketch();

    /**
     * 更新密码
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/8/29
     * @param userName 用户名
     * @param password 密码
     */
    void updatePassword(String userName, String password);

    /**
     * 检验旧密码
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/8/30
     * @param  userName 用户名
     * @param  password 密码
     */
    void checkOldPassword(String userName, String password);


    /**
     * 修改用户信息
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/8/31
     * @param updateReq 修改用户信息请求参数
     */
    void updateItem(AuthUserUpdateReq updateReq);

    /**
     * 查询所有角色
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/4/6
     * @return List
     */
    List<AuthRoleResp> queryAllAuthRole();

    /**
     * 检验用户名
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/8/30
     * @param  userName 用户名
     */
    void checkUserName(String userName);


    /**
     * 新增用户
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/8/31
     * @param addReq 用户新增请求参数
     * @return AuthUser
     */
    AuthUser addNewAuthUser(AuthUserAddReq addReq);

    /**
     * 设置用户的简略信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/5/8
     * @param sketchData 用户简略信息新增请求参数
     * @param authUserId
     */
    void setUserSketch(String authUserId, UserSketchReq sketchData);

    /**
     * 用户注册
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/4/6
     * @param addReq 用户注册
     */
    void register(AuthUserAddReq addReq);

    /**
     * 删除用户
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/9/2
     * @param mainIdList id集合
     */
    void batchDeleteItem(String mainIdList);


    /**
     * 重置密码
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/9/2
     * @param userNameList 用户名集合
     */
    void resetPassword(String userNameList);

}
