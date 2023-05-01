package cn.age.common.validation;


import cn.age.common.validation.validator.IsNumberStrValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 数字字符串验证注解
 * @description 数字字符串验证注解
 */
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsNumberStrValidator.class)
public @interface IsNumberStr {



    String message() default "必须为数字";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
