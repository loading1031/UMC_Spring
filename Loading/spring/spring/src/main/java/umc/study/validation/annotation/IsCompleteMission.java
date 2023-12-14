package umc.study.validation.annotation;

import umc.study.validation.validator.MissionCompleteValidator;
import umc.study.validation.validator.StoresExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionCompleteValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsCompleteMission {
    String message() default "이미 완료한 미션입니다.";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
