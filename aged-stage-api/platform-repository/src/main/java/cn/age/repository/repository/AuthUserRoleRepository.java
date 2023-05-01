package cn.age.repository.repository;

import cn.age.common.config.BaseRepository;
import cn.age.repository.entity.AuthUserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description:
 * @date 2019-08-13
 */
@Mapper
public interface AuthUserRoleRepository extends BaseRepository<AuthUserRole> {


    /**
     * 删除用户的角色关联信息
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/9/4
     * @param authUserIdList 用户ID集合
     */
    @Delete("<script>" +
            "  DELETE FROM auth_user_role WHERE 1=1 AND auth_user_id IN " +
            "  <foreach item='item' index='index' collection='authUserIdList' open='(' separator=',' close=')'>   " +
            "      #{item}  " +
            "  </foreach> " +
            "</script>")
    void deleteByAuthUserIdList(@Param("authUserIdList") List<String> authUserIdList);

}
