package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.MemberMissionRepository;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.validation.annotation.AcceptMission;
import umc.study.web.dto.member.MemberRequestDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MissionAlreadyAcceptValidator implements ConstraintValidator<AcceptMission, MemberRequestDTO.AcceptMissionDTO> {
    private final MemberQueryService memberQueryService;
    @Override
    public boolean isValid(MemberRequestDTO.AcceptMissionDTO value, ConstraintValidatorContext context) {
        System.out.println("실행됨1");
        boolean isValid  = !memberQueryService.isAcceptMssion(value);
        // 해당 미션 ID가 유저수락테이블에 있는지 확인
        //System.out.println("실행됨2");
        System.out.printf("isValid: ",isValid);
        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.Mission_Already_Accept.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
