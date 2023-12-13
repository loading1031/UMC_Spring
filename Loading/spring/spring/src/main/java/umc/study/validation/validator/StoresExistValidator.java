package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.StoreRepository;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.validation.annotation.ExistStore;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StoresExistValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreCommandService storeCommandService;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean valid = storeCommandService.isStore(value);
        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_EXIST.toString()).addConstraintViolation();
        }
        return valid;
    }
}
