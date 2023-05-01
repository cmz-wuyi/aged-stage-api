package cn.age.common.validation;



import cn.age.common.validation.validator.LengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Description: 长度注解
 */
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LengthValidator.class)
public @interface Length {

    int max() default 1;

    int min() default 1;

    String message() default "not_null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
