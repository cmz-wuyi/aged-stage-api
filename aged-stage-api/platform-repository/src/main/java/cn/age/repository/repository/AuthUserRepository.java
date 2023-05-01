package cn.age.repository.repository;

import cn.age.common.config.BaseRepository;
import cn.age.common.config.RedisEntityCacheHandler;
import cn.age.repository.entity.AuthUser;
import cn.age.repository.result.AuthPermissionQueryResult;
import cn.age.repository.result.AuthUserResult;
import cn.age.repository.result.UserSketchResult;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 用户Repository
 * @title: AuthPermissionRepository.java
 * @author create by Singer - Singer email:singer-coder@qq.com
 * @date 2019/4/24 11:21
 * @return
 */
@Mapper
@CacheNamespace(implementation = RedisEntityCacheHandler.class,flushInterval = 60000)
public interface AuthUserRepository extends BaseRepository<AuthUser> {


    /**
     * 根据角色代码查询用户信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-13
     * @param deleteStatus 删除状态
     * @param roleCode 角色代码
     * @return List
     */
    @Select( "<script>"
            + " SELECT " +
            " authUser.real_name AS realName, " +
            " authUser.user_name AS userName, " +
            " authUser.auth_user_id AS authUserId, " +
            " authRole.role_code AS roleCode  " +
            "FROM " +
            " auth_user authUser " +
            " LEFT JOIN auth_user_role userRole ON userRole.auth_user_id = authUser.auth_user_id " +
            " LEFT JOIN auth_role authRole ON authRole.auth_role_id = userRole.auth_role_id  " +
            "WHERE " +
            " authRole.role_code = #{roleCode} " +
            " AND authUser.delete_status = #{deleteStatus}  " +
            " AND userRole.delete_status = #{deleteStatus}  " +
            " AND authRole.delete_status = #{deleteStatus}  " +
            "</script>"
    )
    @Results(
            {
                    @Result(column = "realName", property = "realName", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "userName", property = "userName", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "authUserId", property = "authUserId", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "roleCode", property = "roleCode", jdbcType = JdbcType.VARCHAR),
            }
    )
    @Options(useCache = true)
    List<UserSketchResult> querySketchByRoleCode(@Param("deleteStatus") Integer deleteStatus,
                                                 @Param("roleCode") String roleCode);



    /**
     * 根据用户名更新系统用户账户名称
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-21
     * @param authUserId 用户ID
     * @param userName 用户名
     */
    @Update({
            "<script>"
                    + "UPDATE auth_user SET user_name = #{userName} "
                    + " WHERE auth_user_id = #{authUserId} "
                    +"</script>"
    })
    @Options(useCache = false)
    void updateAuthUserName(@Param("authUserId") String authUserId,
                                     @Param("userName") String userName);

    /**
      * 更新用户最后登陆时间
      * @author: create by singer - Singer email:singer-coder@qq.com
      * @date 2019-08-21
      * @param authUserId 用户ID
      * @param lastLoginTime 最后登陆时间
      */
    @Update({
            "<script>"
                    + "UPDATE auth_user SET last_login_time = #{lastLoginTime} "
                    + " WHERE auth_user_id = #{authUserId} "
                    +"</script>"
    })
    @Options(useCache = false)
    void updateAuthUserLastLoginTime(@Param("authUserId") String authUserId,
                                     @Param("lastLoginTime") LocalDateTime lastLoginTime);


    /**
     * 根据用户ID查询用户详情信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-13
     * @param deleteStatus 删除状态
     * @param userName 用户名
     * @return List
     */
    @Select( "<script>"
            + "SELECT " +
            " m.auth_menu_id AS authMenuId , " +
            " m.menu_name AS menuName , " +
            " m.parent_id AS parentId , " +
            " m.path AS path , " +
            " m.component AS component , " +
            " m.perms AS perms , " +
            " m.menu_icon AS menuIcon , " +
            " m.menu_type AS menuType , " +
            " m.order_num AS orderNum  " +
            "  FROM " +
            " auth_role r " +
            " LEFT JOIN auth_user_role ur ON ( r.auth_role_id = ur.auth_role_id ) " +
            " LEFT JOIN auth_user u ON ( u.auth_user_id = ur.auth_user_id ) " +
            " LEFT JOIN auth_role_menu rm ON ( rm.auth_role_id = r.auth_role_id ) " +
            " LEFT JOIN auth_menu m ON ( m.auth_menu_id = rm.menu_id )  " +
            "  WHERE 1=1 AND " +
            " u.auth_user_id = #{authUserId} " +
            " AND r.delete_status = #{deleteStatus}  " +
            " AND ur.delete_status = #{deleteStatus}  " +
            " AND rm.delete_status = #{deleteStatus}  " +
            " AND m.delete_status = #{deleteStatus}  " +
            " AND u.delete_status = #{deleteStatus} "
            +"</script>"
    )
    @Results(
            {
                    @Result(column = "authMenuId", property = "authMenuId", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "menuName", property = "menuName", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "parentId", property = "parentId", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "component", property = "component", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "perms", property = "perms", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "menuIcon", property = "menuIcon", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "menuType", property = "menuType", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "orderNum", property = "orderNum", jdbcType = JdbcType.VARCHAR)
            }
    )
    @Options(useCache = true)
    List<AuthPermissionQueryResult> queryAuthUserPermByUserId(@Param("deleteStatus") Integer deleteStatus,
                                                                      @Param("authUserId") String authUserId);

    /**
     * 根据用户名称查询用户详情信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-13
     * @param deleteStatus 删除状态
     * @param userName 用户名
     * @return List
     */
    @Select( "<script>"
            + "SELECT " +
            " m.auth_menu_id AS authMenuId , " +
            " m.menu_name AS menuName , " +
            " m.parent_id AS parentId , " +
            " m.path AS path , " +
            " m.component AS component , " +
            " m.perms AS perms , " +
            " m.menu_icon AS menuIcon , " +
            " m.menu_type AS menuType , " +
            " m.order_num AS orderNum  " +
            "  FROM " +
            " auth_role r " +
            " LEFT JOIN auth_user_role ur ON ( r.auth_role_id = ur.auth_role_id ) " +
            " LEFT JOIN auth_user u ON ( u.auth_user_id = ur.auth_user_id ) " +
            " LEFT JOIN auth_role_menu rm ON ( rm.auth_role_id = r.auth_role_id ) " +
            " LEFT JOIN auth_menu m ON ( m.auth_menu_id = rm.menu_id )  " +
            "  WHERE 1=1 AND " +
            " u.user_name = #{userName} " +
            " AND r.delete_status = #{deleteStatus}  " +
            " AND ur.delete_status = #{deleteStatus}  " +
            " AND rm.delete_status = #{deleteStatus}  " +
            " AND m.delete_status = #{deleteStatus}  " +
            " AND u.delete_status = #{deleteStatus} "
            +"</script>"
    )
    @Results(
            {
                    @Result(column = "authMenuId", property = "authMenuId", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "menuName", property = "menuName", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "parentId", property = "parentId", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "component", property = "component", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "perms", property = "perms", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "menuIcon", property = "menuIcon", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "menuType", property = "menuType", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "orderNum", property = "orderNum", jdbcType = JdbcType.VARCHAR)
            }
    )
    @Options(useCache = true)
    List<AuthPermissionQueryResult> queryAuthUserPermissionByUserName(@Param("deleteStatus") Integer deleteStatus,
                                                                      @Param("userName") String userName);


    /**
     * 根据用户名称查询用户详情信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-13
     * @param userName 用户名
     * @param deleteStatus 删除状态
     * @return AuthUserResult
     */
    @Select(" SELECT " +
            " u.id AS id, " +
            " u.create_time AS createTime, " +
            " u.update_time AS updateTime, " +
            " u.auth_user_id AS authUserId, " +
            " u.user_name AS user_name, " +
            " u.real_name AS realName, " +
            " u.auth_password AS authPassword, " +
            " u.auth_salt AS authSalt, " +
            " u.phone_number AS phoneNumber, " +
            " u.create_time AS createTime, " +
            " u.avatar AS avatar, " +
            " u.description AS description, " +
            " u.last_login_time AS lastLoginTime, " +
            " ur.auth_role_id AS authRoleId, " +
            " r.role_name AS roleName, " +
            " r.role_code AS roleCode " +
            "FROM " +
            " auth_user u " +
            " LEFT JOIN auth_user_role ur ON ( u.auth_user_id = ur.auth_user_id ) " +
            " LEFT JOIN auth_role r ON r.auth_role_id = ur.auth_role_id  " +
            "WHERE " +
            " u.user_name = #{userName}  " +
            " AND r.delete_status = #{deleteStatus}  " +
            " AND ur.delete_status = #{deleteStatus}  " +
            " AND u.delete_status = #{deleteStatus}  "
    )
    @Options(useCache = true)
    AuthUserResult queryAuthUserSketchByUserName(@Param("deleteStatus") Integer deleteStatus,
                                                 @Param("userName") String userName);

    /**
      * 删除用户
      * @author: create by Singer email:singer-coder@qq.com
      * @date 2019/9/2
      * @param authUserId 用户ID
      */
    @Update({
            "<script>"
                    + "UPDATE auth_user SET delete_status = 1 "
                    + " WHERE auth_user_id = #{authUserId} "
                    +"</script>"
    })
    @Options(useCache = false)
    void deleteByUserId(@Param("authUserId") String authUserId);


    /**
     * 删除系统用户
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/9/4
     * @param authUserIdList 用户ID集合
     */
    @Delete("<script>" +
            "  DELETE FROM auth_user WHERE  1=1 AND auth_user_id IN " +
            "  <foreach item='item' index='index' collection='authUserIdList' open='(' separator=',' close=')'>   " +
            "      #{item}  " +
            "  </foreach> " +
            "</script>")
    void deleteByAuthUserIdList(@Param("authUserIdList") List<String> authUserIdList);

    /**
      * 重置用户密码
      * @author: create by Singer email:singer-coder@qq.com
      * @date 2019/9/2
      * @param userName 用户名
      * @param authPassword 密码
      * @param authSalt 密码盐
      */
    @Update({
            "<script>"
                    + "UPDATE auth_user auth SET auth.auth_password = #{authPassword} ,auth.auth_salt = #{authSalt} "
                    + " WHERE auth.user_name = #{userName} "
                    +"</script>"
    })
    @Options(useCache = false)
    void resetPassword(@Param("userName") String userName,
                       @Param("authPassword") String authPassword,
                       @Param("authSalt") String authSalt);


    /**
     * 根据用户ID查询用户密码
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-13
     * @param deleteStatus 是否删除状态
     * @param mainId 用户ID
     * @return java.lang.String
     */
    @Select(" SELECT item.auth_password AS authPassword FROM auth_user item " +
            " WHERE 1=1 AND item.auth_user_id = #{mainId} AND item.delete_status = #{deleteStatus} "
    )
    @Options(useCache = true)
    String queryPasswordByUserId( @Param("mainId") String mainId,
                                        @Param("deleteStatus") Integer deleteStatus);


    /**
     * 根据用户ID查询用户密码
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-13
     * @param deleteStatus 是否删除状态
     * @param mainId 业务主键ID
     * @return java.util.List
     */
    @Select(" SELECT item.user_name AS userName FROM auth_user item " +
            " WHERE 1=1 AND item.auth_user_id = #{mainId} AND item.delete_status = #{deleteStatus} "
    )
    @Options(useCache = true)
    String queryUserNameByMainId( @Param("mainId") String mainId,
                                  @Param("deleteStatus") Integer deleteStatus);
}
