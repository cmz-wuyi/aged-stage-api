package cn.age.repository.repository;

import cn.age.common.config.BaseRepository;
import cn.age.common.config.RedisEntityCacheHandler;
import cn.age.repository.entity.AuthPermission;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;


/**
 * 权限Repository
 * @title: AuthPermissionRepository.java
 * @author create by Singer - Singer email:singer-coder@qq.com
 * @date 2019/4/24 11:21
 * @return
 */
@Mapper
@CacheNamespace(implementation = RedisEntityCacheHandler.class,flushInterval = 60000)
public interface AuthPermissionRepository extends BaseRepository<AuthPermission> {



}
