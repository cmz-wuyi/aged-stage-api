package cn.age.common.validation.validator;

import cn.age.common.validation.IsNumberStr;
import cn.age.common.utils.common.CheckParam;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description
 */
public class IsNumberStrValidator implements ConstraintValidator<IsNumberStr,String> {


    @Override
    public void initialize(IsNumberStr isNumberStr) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return CheckParam.isNum(value);
    }
}
