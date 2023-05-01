package cn.age.repository.repository;
import cn.age.common.config.BaseRepository;
import cn.age.common.config.RedisEntityCacheHandler;
import cn.age.repository.entity.AuthUserSketch;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @packageName cn.singer.repository.entity
 * @Description: 系统用户简略信息->Repository
 * @date 2019-08-12
 */
@Mapper
@CacheNamespace(implementation = RedisEntityCacheHandler.class,flushInterval = 60000)
public interface AuthUserSketchRepository extends BaseRepository<AuthUserSketch> {


    /**
     * 删除系统用户
     * @author: create by Singer email:singer-coder@qq.com
     * @date 2019/9/4
     * @param authUserIdList 用户ID集合
     */
    @Delete("<script>" +
            "  DELETE FROM auth_user_sketch WHERE  1=1 AND auth_user_id IN " +
            "  <foreach item='item' index='index' collection='authUserIdList' open='(' separator=',' close=')'>   " +
            "      #{item}  " +
            "  </foreach> " +
            "</script>")
    void deleteByAuthUserIdList(@Param("authUserIdList") List<String> authUserIdList);




}
