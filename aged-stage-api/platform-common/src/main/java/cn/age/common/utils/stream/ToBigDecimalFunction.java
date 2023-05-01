package cn.age.common.utils.stream;

import java.math.BigDecimal;

/**
 * 函数式抽象接口
 * @author singer
 * @date 创建时间 2018/6/6
 */
@FunctionalInterface
public interface ToBigDecimalFunction<T> {

    /**
     * applyAsBigDecimal
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/29
     * @param value 值
     * @return BigDecimal
     */
    BigDecimal applyAsBigDecimal(T value);
}
