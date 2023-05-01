package cn.age.common.constants;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author create by Singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: redis - key  集合
 * @date 2019-10-11
 */
@Data
@Component
public class RedisConstants {

    /**
     * redis过期时间 -> 3秒
     */
    public static final long EXPIRE_TIME_IN_SECONDS = 10;


    /**
     * Redis查询缓存存储前缀
     */
    public static final String REDIS_QUERY_CACHE_PREFIX = "redis_query_cache_prefix.";

}
