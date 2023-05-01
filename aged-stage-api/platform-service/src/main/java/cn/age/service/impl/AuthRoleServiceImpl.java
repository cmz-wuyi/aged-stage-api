package cn.age.service.impl;

import cn.age.common.constants.BaseConstant;
import cn.age.common.enums.ErrorCode;
import cn.age.common.exception.BusinessException;
import cn.age.common.redis.RedisRepository;
import cn.age.common.utils.CriteriaBuilder;
import cn.age.common.utils.collection.CollectionUtils;
import cn.age.common.utils.common.CheckParam;
import cn.age.interaction.helper.PageBuilder;
import cn.age.interaction.req.role.AuthRoleAddReq;
import cn.age.interaction.req.role.AuthRolePageReq;
import cn.age.interaction.req.role.AuthRoleUpdateReq;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.role.AuthRolePageQueryResp;
import cn.age.interaction.resp.role.AuthRoleResp;
import cn.age.repository.entity.AuthRole;
import cn.age.repository.entity.AuthRoleMenu;
import cn.age.repository.repository.AuthMenuRepository;
import cn.age.repository.repository.AuthPermissionRepository;
import cn.age.repository.repository.AuthRoleMenuRepository;
import cn.age.repository.repository.AuthRoleRepository;
import cn.age.repository.repository.AuthUserConfigRepository;
import cn.age.repository.repository.AuthUserRepository;
import cn.age.repository.repository.AuthUserRoleRepository;
import cn.age.repository.repository.SystemLoginLogRepository;
import cn.age.service.AuthCacheService;
import cn.age.service.AuthRoleService;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 系统角色服务方法实现
 * @date 2019-08-23
 */
@Service(value = "authRoleService")
@Slf4j
public class AuthRoleServiceImpl implements AuthRoleService {

    @Resource
    private AuthUserRepository authUserRepository;

    @Resource
    private AuthPermissionRepository authPermissionRepository;

    @Resource
    private AuthRoleRepository authRoleRepository;

    @Resource
    private AuthUserRoleRepository authUserRoleRepository;

    @Resource
    private BaseConstant baseConstant;

    @Resource
    private AuthCacheService authCacheService;

    @Resource
    private SystemLoginLogRepository systemLoginLogRepository;

    @Resource
    private RedisRepository redisRepository;

    @Resource
    private AuthUserConfigRepository authUserConfigRepository;

    @Resource
    private AuthMenuRepository authMenuRepository;

    @Resource
    private AuthRoleMenuRepository authRoleMenuRepository;

    @Resource
    private MapperFacade mapperFacade;


    /**
      * 分页查询用户角色
      * @author: create by singer - Singer email:singer-coder@qq.com
      * @date 2019-08-23
      * @param authRolePageReq 分页查询用户角色参数
      * @return Pagination
      */
    @Override
    public Pagination<AuthRolePageQueryResp> queryAuthRoleByPage(AuthRolePageReq authRolePageReq){

        //构建查询条件
        Example pageExample = new Example(AuthRole.class);
        Example.Criteria authRoleCriteria = pageExample.createCriteria();
        CriteriaBuilder.rigidCriteria(authRoleCriteria);


        if(!CheckParam.isNull(authRolePageReq.getRoleName())){
            authRoleCriteria.andEqualTo("roleName", authRolePageReq.getRoleName());
        }
        if(!CheckParam.isNull((authRolePageReq.getBeginTime()))){
            authRoleCriteria.andGreaterThanOrEqualTo("createTime", authRolePageReq.getBeginTime());
        }
        if(!CheckParam.isNull((authRolePageReq.getEndTime()))){
            authRoleCriteria.andLessThanOrEqualTo("createTime", authRolePageReq.getEndTime());
        }

        pageExample.orderBy("createTime").desc();

        List<AuthRole> authRoleList = new ArrayList<>();
        Page<Object> page = new Page();

        if(authRolePageReq.getNeedAll()){
            authRoleList.addAll(authRoleRepository.selectByExample(pageExample));
            page.setTotal(authRoleList.size());
            page.setPageSize(authRoleList.size());
            page.setPageNum(1);
            page.setPages(1);

        }else{
            //开始分页
            page = PageHelper.startPage(authRolePageReq.getCurrentPage(), authRolePageReq.getItemsPerPage());
            authRoleList.addAll(authRoleRepository.selectByExample(pageExample));
        }

        if(CheckParam.isNull(authRoleList) || authRoleList.isEmpty()) {
            return PageBuilder.buildPageResult(page,new ArrayList<>());
        }

        List<AuthRolePageQueryResp> authRoleRespList = new ArrayList<>();

        authRoleList.stream().forEach(u1 -> {

            AuthRolePageQueryResp resp = new AuthRolePageQueryResp();

            resp.setCreateTime(u1.getCreateTime());
            resp.setUpdateTime(u1.getUpdateTime());
            resp.setRemark(u1.getRemark());
            resp.setAuthRoleId(u1.getAuthRoleId());
            resp.setRoleName(u1.getRoleName());
            resp.setRoleCode(u1.getRoleCode());

            authRoleRespList.add(resp);
        });

        return PageBuilder.buildPageResult(page,authRoleRespList);

    }

    /**
      * 查询角色列表---不分页
      * @author: create by Singer email:singer-coder@qq.com
      * @date 2019/9/2
      * @return List
      */
    @Override
    public List<AuthRoleResp> queryAllRoles() {
        //查询出所有
        Example  roleExample = Example.builder(AuthRole.class).where(Sqls.custom()
                .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus()))
                .build();
        List<AuthRole> authRoleList = authRoleRepository.selectByExample(roleExample);
        List<AuthRoleResp> respList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(authRoleList)){
            return mapperFacade.mapAsList(authRoleList,AuthRoleResp.class);
        }
        return respList;
    }

    /**
      * 询角色对应的权限菜单
      * @author: create by Singer email:singer-coder@qq.com
      * @date 2019/9/4
      * @param authRoleId 角色ID
      * @return List
      */
    @Override
    public List<String> queryMenuIdList(String authRoleId) {
        log.info(">>>>>>>>>>>>>>>>查询对应角色的权限菜单,参数:{}<<<<<<<<<<<<<<<<<",authRoleId);
        //查询
        Example authRoleMenuExample = Example.builder(AuthRoleMenu.class).where(Sqls.custom()
                .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                .andEqualTo("authRoleId", authRoleId))
                .build();

        List<AuthRoleMenu> roleMenuList = authRoleMenuRepository.selectByExample(authRoleMenuExample);

        if(CollectionUtils.isEmpty(roleMenuList)){
            return Collections.EMPTY_LIST;
        }

        List<String> authMenuIdList = roleMenuList.stream().map(item -> item.getMenuId()).collect(Collectors.toList());
        return authMenuIdList;
    }

    /**
     * 更新信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/30
     * @param updateReq 更新请求参数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateItem(AuthRoleUpdateReq updateReq) {
        log.info(">>>>>>>>>>>>>修改角色信息,参数:{}<<<<<<<<<<<<<<<<",updateReq.toString());
        String roleCode = updateReq.getRoleCode();
        //查询
        Example  roleExample = Example.builder(AuthRole.class).where(Sqls.custom()
                .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                .andEqualTo("authRoleId", updateReq.getAuthRoleId()))
                .build();
        AuthRole authRole = authRoleRepository.selectOneByExample(roleExample);
        //判断
        if (!CheckParam.isNull(updateReq.getRemark())&&!authRole.getRemark().equalsIgnoreCase(updateReq.getRemark())){
            authRole.setRemark(updateReq.getRemark());
        }
        if (!CheckParam.isNull(roleCode)){
            //角色代码不相同才执行更新
            if(!StrUtil.equalsAnyIgnoreCase(authRole.getRoleCode(),roleCode)){
                authRole.setRoleCode(roleCode);
            }
        }
        //更新
        authRoleRepository.updateByPrimaryKey(authRole);
        //查询角色已有的权限
        Example  roleMenuExample = Example.builder(AuthRoleMenu.class).where(Sqls.custom()
                .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                .andEqualTo("authRoleId", updateReq.getAuthRoleId()))
                .build();
        List<AuthRoleMenu> menus = authRoleMenuRepository.selectByExample(roleMenuExample);
        //取出所有的menuId
        List<String> oldMenuIds = menus.stream().map(menu -> menu.getMenuId()).collect(Collectors.toList());
        //转换成set
        Set<String> oldSet = new HashSet<>(oldMenuIds);
        //现有的权限
        List<String> newMenuIdList = updateReq.getAuthMenuIdList();
        //转换成set
        Set<String> newSet = new HashSet<>(newMenuIdList);
        //需要删除的权限
        Set<String> flagSet = new HashSet<>();
        flagSet.addAll(oldSet);
        flagSet.removeAll(newSet);
        log.info(">>>>>>>>>>>>>>>更新新角色:{}->需要【删除】的权限:{} <<<<<<<<<",updateReq.getAuthRoleId(),flagSet.toString());
        if (!CheckParam.isNull(flagSet) && flagSet.size() > 0){
            flagSet.stream().forEach(menuId->{
                authRoleMenuRepository.deleteByRoleAndMenuId(updateReq.getAuthRoleId(),menuId);
            });
        }
        //需要新增的权限
        flagSet.clear();
        flagSet.addAll(newSet);
        flagSet.removeAll(oldSet);
        log.info(">>>>>>>>>>>>>>>更新新角色:{}->需要【添加】的权限:{}",updateReq.getAuthRoleId(),flagSet.toString());
        if (!CheckParam.isNull(flagSet) && flagSet.size() > 0){
            flagSet.stream().forEach(menuId->{
                AuthRoleMenu authRoleMenu = new AuthRoleMenu();
                authRoleMenu.setAuthRoleId(updateReq.getAuthRoleId());
                authRoleMenu.setMenuId(menuId);
                authRoleMenuRepository.insert(authRoleMenu);
            });
        }
    }

    /**
      * 删除角色
      * @author: create by Singer email:singer-coder@qq.com
      * @date 2019/9/4
      * @param authRoleIdList
      */
    @Override
    public void batchDeleteItem(String authRoleIdList) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>删除用户角色,参数:{}<<<<<<<<<<<<<<<<<<<<<<<<",authRoleIdList);
        List<String> roleIdList = Arrays.asList(authRoleIdList.split(","));
        if (!CheckParam.isNull(roleIdList)){
            roleIdList.stream().forEach(authRoleId->{
                authRoleRepository.deleteByRoleId(authRoleId);
            });
            authRoleMenuRepository.deleteByAuthRoleIdList(roleIdList);
        }
    }

    /**
     * 判断角色名称是否存在
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/5/21
     * @param roleName 角色名称
     * @return Boolean
     */
    @Override
    public Boolean roleNameExisted(String roleName){
        Example  authRoleExample = Example.builder(AuthRole.class).where(Sqls.custom()
                .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                .andEqualTo("roleName", roleName))
                .build();

        Integer roleCount = authRoleRepository.selectCountByExample(authRoleExample);

        if(roleCount.compareTo(BigInteger.ZERO.intValue()) != 0){
            return true;
        }else{
            return false;
        }
    }

    /**
      * 判断角色代码是否存在
      * @author: create by singer - Singer email:singer-coder@qq.com
      * @date 2021/5/21
      * @param roleCode 角色代码
      * @return Boolean
      */
    @Override
    public Boolean roleCodeExisted(String roleCode){
        Example  authRoleExample = Example.builder(AuthRole.class).where(Sqls.custom()
                .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                .andEqualTo("roleCode", roleCode))
                .build();

        Integer roleCount = authRoleRepository.selectCountByExample(authRoleExample);

        if(roleCount.compareTo(BigInteger.ZERO.intValue()) != 0){
            return true;
        }else{
            return false;
        }
    }

    /**
      * 校验角色代码的唯一性
      * @author: create by singer - Singer email:singer-coder@qq.com
      * @date 2021/4/27
      * @param roleCode 角色代码
      */
    @Override
    public void verifyRoleCode(String roleCode){

        if(CheckParam.isNull(roleCode)){
            return;
        }

        Example  authRoleExample = Example.builder(AuthRole.class).where(Sqls.custom()
                .andEqualTo("deleteStatus", baseConstant.getUnDeleteStatus())
                .andEqualTo("roleCode", roleCode))
                .build();

        Integer roleCount = authRoleRepository.selectCountByExample(authRoleExample);

        if(roleCount.compareTo(BigInteger.ZERO.intValue()) != 0){
            throw new BusinessException(ErrorCode.REPEAT_ROLE_CODE_ERROR.getCode(),
                    ErrorCode.REPEAT_ROLE_CODE_ERROR.getMessage());
        }
    }

    /**
     * 新增角色
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/30
     * @param addReq 新增角色请求参数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void addItem(AuthRoleAddReq addReq) {
        log.info(">>>>>>>>>>>>>>>>>新增角色请求参数: {} <<<<<<<<<<<<<<", JSON.toJSONString(addReq));
        String roleCode = addReq.getRoleCode();
        verifyRoleCode(roleCode);
        //创建角色
        AuthRole authRole = new AuthRole();
        authRole.setRemark(addReq.getRemark());
        authRole.setRoleName(addReq.getRoleName());
        authRole.setRoleCode(roleCode);
        authRoleRepository.insert(authRole);

        List<String> authMenuIdList = addReq.getAuthMenuIdList();
        //添加角色对应的菜单
        if (!CollectionUtils.isEmpty(authMenuIdList)){
            List<AuthRoleMenu> authRoleMenuList = new ArrayList<>();

            authMenuIdList.stream().forEach(authMenuId->{
                AuthRoleMenu authRoleMenu = new AuthRoleMenu();
                authRoleMenu.setMenuId(authMenuId);
                authRoleMenu.setAuthRoleId(authRole.getAuthRoleId());

                authRoleMenuList.add(authRoleMenu);
            });

            if(!authRoleMenuList.isEmpty()){
                authRoleMenuRepository.insertList(authRoleMenuList);
            }
        }
    }


}
