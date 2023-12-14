package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.PageCheckHandler;
import umc.study.validation.annotation.CheckPage;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PageCheckValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean valid = (value >= 1);

        if (!valid) {

            context.disableDefaultConstraintViolation();
            //context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_FOUND.toString()).addConstraintViolation();
            throw new ConstraintViolationException("Page should be a positive integer.", Set.of());
        }
        return valid;
    }
}
