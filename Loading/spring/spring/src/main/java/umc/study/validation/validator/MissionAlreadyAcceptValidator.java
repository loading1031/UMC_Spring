package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.MemberMissionRepository;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.validation.annotation.AcceptMission;
import umc.study.web.dto.member.mission.MemberMissionRequestDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MissionAlreadyAcceptValidator implements ConstraintValidator<AcceptMission, MemberMissionRequestDTO.FkList> {
    private final MemberCommandService memberCommandService;
    @Override
    public boolean isValid(MemberMissionRequestDTO.FkList value, ConstraintValidatorContext context) {
        boolean isValid  = !memberCommandService.isAcceptMission(
                value.getMemberId(), value.getMissionId()
        );
        // 해당 ID가 유저수락테이블에 있는지 확인

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.Mission_Already_Accept.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
