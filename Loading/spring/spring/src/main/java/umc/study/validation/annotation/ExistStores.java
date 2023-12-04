package umc.study.validation.annotation;

import umc.study.validation.validator.CategoriesExistValidator;
import umc.study.validation.validator.StoresExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StoresExistValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStores {
    String message() default "해당하는 식당이 존재하지 않습니다_커스텀";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
