package cn.age.api.controller;

import cn.age.common.anon.ApiLog;
import cn.age.common.redis.RedisRepository;
import cn.age.interaction.req.role.AuthRoleAddReq;
import cn.age.interaction.req.role.AuthRolePageReq;
import cn.age.interaction.req.role.AuthRoleUpdateReq;
import cn.age.interaction.resp.base.ApiResponse;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.role.AuthRolePageQueryResp;
import cn.age.interaction.resp.role.AuthRoleResp;
import cn.age.service.AuthRoleService;
import cn.age.service.AuthUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 系统角色前端控制器
 */
@RestController
@RequestMapping(value = "api/v1/authRole")
@Slf4j
public class AutoRoleController extends BaseApiController {


    @Resource
    private AuthUserService authUserService;

    @Resource
    private RedisRepository redisRepository;

    @Resource
    private AuthRoleService authRoleService;


    /**
     * 分页查询用户角色
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @param authRolePageReq 分页查询用户角色参数
     * @return Pagination
     */
    @PostMapping(value = "/queryAuthRoleByPage")
    @ApiLog(value = "分页查询用户角色")
    public ApiResponse<Pagination<AuthRolePageQueryResp>> queryAuthRoleByPage(@RequestBody(required = false)
                                                                                      AuthRolePageReq authRolePageReq){
        return apiResponse(authRoleService.queryAuthRoleByPage(authRolePageReq));
    }

    /**
     * 查询角色列表->不分页
     * @author: create by Singer email:singer-coder@qq.com
     * @return ApiResponse
     */
    @GetMapping("/queryAllRoles")
    @ApiLog(value = "查询所有角色")
    public ApiResponse<List<AuthRoleResp>> queryAllRoles(){
        return apiResponse(authRoleService.queryAllRoles());
    }

    /**
     * 根据角色ID查询角色对应的菜单权限信息
     * @param authRoleId 角色ID
     * @return List
     */
    @GetMapping("/queryMenuIdList")
    @ApiLog(value = "查询角色对应的权限菜单")
    public ApiResponse<List<String>> queryMenuIdList(@NotBlank(message = "{required}") @RequestParam(name = "authRoleId") String authRoleId){
        return apiResponse(authRoleService.queryMenuIdList(authRoleId));
    }

    /**
     * 更新信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @param updateReq 更新请求参数
     */
    @PostMapping("/updateItem")
    @ApiLog(value = "修改角色信息")
    public ApiResponse updateAuthRole(@RequestBody @Valid AuthRoleUpdateReq updateReq){
        authRoleService.updateItem(updateReq);
        return apiResponse();
    }

    /**
      * 删除角色
      * @param mainIdList
      * @return
      */
    @DeleteMapping("/batchDeleteItem/{mainIdList}")
    @RequiresPermissions("dict:delete")
    @ApiLog(value = "删除角色")
    public ApiResponse batchDeleteItem(@PathVariable("mainIdList")String mainIdList){
        authRoleService.batchDeleteItem(mainIdList);
        return apiResponse();
    }

    /**
     * 判断角色代码是否存在
     * @param roleCode 角色代码
     * @return Boolean
     */
    @GetMapping("/roleCodeExisted")
    @ApiLog(value = "判断角色代码是否存在")
    public ApiResponse<Boolean> roleCodeExisted(@RequestParam(name = "roleCode") String roleCode){
        return apiResponse(authRoleService.roleCodeExisted(roleCode));
    }

    /**
     * 判断角色名称是否存在
     * @param roleName 角色名称
     * @return Boolean
     */
    @GetMapping("/roleNameExisted")
    @ApiLog(value = "判断角色名称是否存在")
    public ApiResponse<Boolean> roleNameExisted(@RequestParam(name = "roleName") String roleName){
        return apiResponse(authRoleService.roleNameExisted(roleName));
    }

    /**
     * 新增角色
     * @param addReq 新增请求参数
     */
    @PostMapping(value = "/addItem")
    @RequiresPermissions("role:add")
    @ApiLog(value = "新增角色")
    public ApiResponse addMenu(@RequestBody @Valid AuthRoleAddReq addReq){
        authRoleService.addItem(addReq);
        return apiResponse();
    }
}
