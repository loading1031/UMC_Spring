package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.MemberMissionRepository;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.validation.annotation.AcceptMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MissionAlreadyAcceptValidator implements ConstraintValidator<AcceptMission, Long> {
    private final MemberQueryService memberQueryService;
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid  = !memberQueryService.isAcceptMssion(value);
        // 해당 ID가 유저수락테이블에 있는지 확인

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.Mission_Already_Accept.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
