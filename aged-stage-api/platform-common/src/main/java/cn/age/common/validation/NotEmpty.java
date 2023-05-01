package cn.age.common.validation;


import cn.age.common.validation.validator.NotEmptyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 为空验证注解
 */
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptyValidator.class)
public @interface NotEmpty {



    String message() default "not_null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
