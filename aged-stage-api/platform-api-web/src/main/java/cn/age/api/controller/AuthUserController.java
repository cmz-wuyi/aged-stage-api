package cn.age.api.controller;

import cn.age.common.anon.ApiLog;
import cn.age.common.redis.RedisRepository;
import cn.age.interaction.internal.auth.ActiveUser;
import cn.age.interaction.req.auth.AuthLoginReq;
import cn.age.interaction.req.auth.AuthUserAddReq;
import cn.age.interaction.req.auth.AuthUserPageReq;
import cn.age.interaction.req.auth.AuthUserUpdateReq;
import cn.age.interaction.req.user.AuthUserConfigUpdateReq;
import cn.age.interaction.req.user.UserProfileUpdateReq;
import cn.age.interaction.resp.auth.AuthorizedUserResp;
import cn.age.interaction.resp.auth.AuthorizedUserWrapResp;
import cn.age.interaction.resp.base.ApiResponse;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.role.AuthRoleResp;
import cn.age.interaction.resp.user.AuthUserPageQueryResp;
import cn.age.interaction.resp.user.AuthUserSketchResp;
import cn.age.interaction.resp.user.UserSketchResp;
import cn.age.service.AuthUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description:
 */
@RestController
@RequestMapping(value = "api/v1/authUser")
@Slf4j
public class AuthUserController extends BaseApiController {


    @Resource
    private AuthUserService authUserService;

    @Resource
    private RedisRepository redisRepository;


    /**
     * 根据用户名称查询用户信息
     * @param userName 用户名称
     * @return AuthorizedUserResp
     */
    @GetMapping("/{userName}")
    @ApiLog(value = "根据用户名称查询用户信息")
    public AuthorizedUserResp queryAuthorizedUserByUserName(@PathVariable String userName){
        return authUserService.queryAuthorizedUserByUserName(userName);
    }

    /**
     * 根据用户名称判断用户是否存在
     * @param userName 用户名称
     * @return Boolean
     */
    @GetMapping("check/{userName}")
    @ApiLog(value = "根据用户名称判断用户是否存在")
    public Boolean judgeUserExistByUserName( @PathVariable(name = "userName") String userName){
        return authUserService.judgeUserExistByUserName(userName);
    }

    /**
     * 系统用户登陆
     * @param loginReq 登录请求参数
     * @return cn.age.interaction.resp.base.ApiResponse
     */
    @PostMapping("/authUserLogin")
    @ApiLog(value = "登陆系统")
    public ApiResponse<AuthorizedUserWrapResp> authUserLogin(@RequestBody @Valid
                                                                     AuthLoginReq loginReq){
        return apiResponse(authUserService.authUserLogin(loginReq));
    }

    /**
     * 当前用户登出
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @param authUserId 当前用户的ID
     */
    @DeleteMapping("/authUserLogOut/{authUserId}")
    @RequiresPermissions("user:kickout")
    @ApiLog(value = "当前用户登出")
    public ApiResponse authUserLogOut(@PathVariable(name="authUserId") String authUserId){
       authUserService.authUserLogOut(authUserId);
       return apiResponse();
    }


    /**
     * 查询当前所有在线的用户
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @return List
     */
    @GetMapping("/queryAllActiveUser")
    @RequiresPermissions("user:online")
    @ApiLog(value = "根据当前用户名查询当前活跃的用户")
    public ApiResponse<List<ActiveUser>> queryAllActiveUser(){
        return apiResponse(authUserService.queryAllActiveUser());
    }


    /**
     * 根据角色代码查询用户信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @param roleCode 角色代码
     * @return java.util.List
     */
    @GetMapping("/queryUserSketchByRoleCode")
    public ApiResponse<List<UserSketchResp>> queryUserSketchByRoleCode(@RequestParam(name = "roleCode")
                                                                               String roleCode){
        return apiResponse(authUserService.queryUserSketchByRoleCode(roleCode));
    }

    /**
      *
      * 分页查询用户
      * @param authUserPageReq 分页查询用户请求参数
      * @return ApiResponse
      */
    @PostMapping("/queryUserByPage")
    @RequiresPermissions("user:view")
    @ApiLog(value = "分页查询用户")
    public ApiResponse<Pagination<AuthUserPageQueryResp>> queryUserByPage(@RequestBody AuthUserPageReq authUserPageReq){
        return apiResponse(authUserService.queryUserByPage(authUserPageReq));
    }

    /**
      * 系统定制修改
      * @author: create by Singer email:singer-coder@qq.com
      * @param userConfig
      * @return
      */
    @PostMapping("/updateUserConfig")
    @ApiLog(value = "系统定制修改")
    public ApiResponse updateUserConfig(@RequestBody AuthUserConfigUpdateReq userConfig){
        authUserService.updateUserConfig(userConfig);
        return apiResponse();
    }

    /**
     * 更新用户资料
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @param userProfileUpdateReq 更新用户资料请求参数
     */
    @PutMapping("/updateAuthUserProfile")
    @ApiLog(value = "更新用户资料")
    public ApiResponse updateAuthUserProfile(@RequestBody @Valid UserProfileUpdateReq userProfileUpdateReq){
        authUserService.updateAuthUserProfile(userProfileUpdateReq);
        return apiResponse();
    }

    /**
     * 查询所有用户的简略信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/4/6
     * @return List
     */
    @GetMapping("/queryAllAuthUserSketch")
    public ApiResponse<List<AuthUserSketchResp>> queryAllAuthUserSketch(){
        return apiResponse(authUserService.queryAllAuthUserSketch());
    }

    /**
     * 查询用户的详情信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/12/14
     * @param authUserId 用户ID
     * @return cn.age.interaction.resp.user.AuthUserSketchResp
     */
    @GetMapping("/querySketchByUserId")
    public ApiResponse<AuthUserSketchResp> querySketchByUserId(@RequestParam(name = "authUserId") String authUserId){
        return apiResponse(authUserService.querySketchByUserId(authUserId));
    }

    /**
     * 更新密码
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/8/29
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @GetMapping("/updatePassword")
    @ApiLog(value = "修改密码")
    public ApiResponse updatePassword(@Valid String userName, @Valid String password){
        authUserService.updatePassword(userName,password);
        return apiResponse();
    }

    /**
      * 校验旧密码
      * @author: create by Singer email:singer-coder@qq.com
      * @date 2019/8/30
      * @param  userName
      * @return ApiResponse
      */
    @GetMapping("/checkOldPassword")
    @ApiLog(value = "校验旧密码")
    public ApiResponse checkOldPassword(@Valid String userName, @Valid String password){
        authUserService.checkOldPassword(userName,password);
        return apiResponse();
    }

    /**
     * 检验用户名
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/8/30
     * @param  userName 用户名
     */
    @GetMapping("/checkUserName")
    @ApiLog(value = "检验用户名")
    public ApiResponse checkUserName(@RequestParam(name = "userName") String userName){
        authUserService.checkUserName(userName);
        return apiResponse();
    }

    /**
     * 修改用户信息
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/8/31
     * @param updateReq 修改用户信息请求参数
     * @return ApiResponse
     */
    @PutMapping("/updateItem")
    @ApiLog(value = "修改用户信息")
    public ApiResponse updateItem(@RequestBody @Valid AuthUserUpdateReq updateReq){
        authUserService.updateItem(updateReq);
        return apiResponse();
    }

    /**
     * 新增用户
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/8/31
     * @param addReq
     * @return ApiResponse
     */
    @PostMapping("/addAuthUser")
    @ApiLog(value = "新增用户")
    public ApiResponse addAuthUser(@RequestBody AuthUserAddReq addReq){
        authUserService.addNewAuthUser(addReq);
        return apiResponse();
    }

    /**
     * 用户注册
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/4/6
     * @param addReq 用户注册请求参数
     */
    @PostMapping("/register")
    @ApiLog(value = "用户注册")
    public ApiResponse register(@RequestBody AuthUserAddReq addReq){
        authUserService.register(addReq);
        return apiResponse();
    }

    /**
      * 删除用户
      * @author: create by Singer email:singer-coder@qq.com
      * @date 2019/9/2
      * @param mainIdList 用户ID集合
      * @return ApiResponse
      */
    @DeleteMapping("/batchDeleteItem/{mainIdList}")
    @RequiresPermissions("dict:delete")
    @ApiLog(value = "删除用户")
    public ApiResponse batchDeleteItem(@PathVariable("mainIdList")String mainIdList){
        authUserService.batchDeleteItem(mainIdList);
        return apiResponse();
    }

    /**
     * 重置密码
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/9/2
     * @param userNameList 用户名集合
     * @return
     */
    @GetMapping("/resetPassword")
    @ApiLog(value = "用户重置密码")
    public ApiResponse resetPassword(@RequestParam("userNameList") String userNameList){
        authUserService.resetPassword(userNameList);
        return apiResponse();
    }

    /**
     * 查询所有角色
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/4/6
     * @return List
     */
    @GetMapping("/queryAllAuthRole")
    @ApiLog(value = "查询所有角色")
    public ApiResponse<List<AuthRoleResp>> queryAllAuthRole(){
        return apiResponse(authUserService.queryAllAuthRole());
    }
}
