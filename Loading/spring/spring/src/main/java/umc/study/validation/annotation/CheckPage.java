package umc.study.validation.annotation;

import umc.study.validation.validator.PageCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageCheckValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "없는 페이지입니다.";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
