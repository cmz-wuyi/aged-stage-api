package cn.age.common.function;


/**
 * 缓存数据查询函数式接口
 * @author created by Singer email:singer-coder@qq.com
 * @time 2017/11/22
 */
@FunctionalInterface
public interface CacheSelector<T> {

    /**
     * 缓存查询方法
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/29
     * @return T
     * @throws Exception e 需要抛出异常
     */
    T query() throws Exception;
}
