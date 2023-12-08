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
public class StoresExistValidator implements ConstraintValidator<ExistStore, List<Long>> {
    private final StoreCommandService storeCommandService;

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = !values.stream()
                .allMatch(storeCommandService::isStore);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_EXIST.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
