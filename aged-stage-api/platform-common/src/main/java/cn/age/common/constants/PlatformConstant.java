package cn.age.common.constants;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.common.aspect
 * @Description: 业务配置
 * @date 2021-01-21
 */
@Data
@Component
public class PlatformConstant extends BasePlatformConstant {

    /**
     * 业务数据缓存时间
     */
    public static final Long CACHE_TIME = 10L;

    /**
     * 用户简要信息缓存前缀
     */
    public static final String APP_USER_SKETCH_CACHE_PREFIX = "app_user_sketch_cache_prefix:";

    /**
     * 系统物品查看次数缓存前缀
     */
    public static final String ITEM_VIEW_SUM_PREFIX = "item_view_sum_prefix:";

    /**
     * 所有业务字典缓存
     */
    public static final String ALL_DICT_CACHE_PREFIX = "all_dict_cache_prefix:";

    /**
     * 当前用户权限缓存
     */
    public static final String CURRENT_USER_PERMS_CACHE_PREFIX = "current_user_perms_cache_prefix:";


}



