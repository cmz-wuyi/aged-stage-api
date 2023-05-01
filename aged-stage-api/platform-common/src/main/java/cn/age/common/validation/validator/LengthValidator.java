package cn.age.common.validation.validator;

import cn.age.common.utils.common.CheckParam;
import cn.age.common.validation.Length;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description: 字段长度验证器
 */
@Slf4j
public class LengthValidator implements ConstraintValidator<Length,Object> {

    private int min;
    private int max;


    /**
     * 初始化验证器的逻辑
     */
    @Override
    public void initialize(Length constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        validateParameters();
    }

    /**
     *
     * 验证的逻辑
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (CheckParam.isNull(value)) {
            return false;
        }
        String param = String.valueOf(value);
        int length = param.length();
        return length >= min && length <= max;
    }

    private void validateParameters() {
        if ( min < 0 ) {
            throw new IllegalArgumentException("最小长度不能小于0");
        }
        if ( max < 0 ) {
            throw new IllegalArgumentException("最大长度不能小于0");
        }
        if ( max < min ) {
            throw new IllegalArgumentException("最大长度不能小于最小长度");
        }
    }
}
