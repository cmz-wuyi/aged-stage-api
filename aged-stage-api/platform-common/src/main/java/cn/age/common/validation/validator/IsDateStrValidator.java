package cn.age.common.validation.validator;


import cn.age.common.utils.common.CheckParam;
import cn.age.common.validation.IsDateStr;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**

 * @description
 */
public class IsDateStrValidator implements ConstraintValidator<IsDateStr,String> {


    @Override
    public void initialize(IsDateStr isDateStr) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return CheckParam.isDatetime(value);
    }
}
