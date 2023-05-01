package cn.age.common.validation.validator;

import cn.age.common.utils.common.CheckParam;
import cn.age.common.validation.NotEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description 验证器
 */
public class NotEmptyValidator implements ConstraintValidator<NotEmpty,Object>{


    @Override
    public void initialize(NotEmpty notEmpty) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {


        return !CheckParam.isNull(value);
    }

}
