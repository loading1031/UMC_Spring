package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.enums.MissionStatus;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.validation.annotation.ExistStore;
import umc.study.validation.annotation.IsCompleteMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MissionCompleteValidator implements ConstraintValidator<IsCompleteMission, Long> {
    private final MemberCommandService memberCommandService;
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean valid = memberCommandService.getMemberMission(value).
                getStatus().equals(MissionStatus.CHALLENGING);
        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_COMPLETE.toString()).addConstraintViolation();
        }
        return valid;
    }
}
