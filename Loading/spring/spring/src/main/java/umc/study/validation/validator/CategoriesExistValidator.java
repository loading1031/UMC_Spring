package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.FoodCategoryRepository;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.validation.annotation.ExistCategories;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {
    private final MemberCommandService memberCommandService;

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean valid = values.stream()
                .allMatch(value -> memberCommandService.isExistCategorry(value));

        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }
        return valid;
    }
}
