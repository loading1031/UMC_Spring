package umc.study.web.dto.member.mission;

import lombok.Getter;
import umc.study.validation.annotation.AcceptMission;

import javax.validation.constraints.NotNull;

public class MemberMissionRequestDTO {

    @Getter
    public static class MemberMissionDTO{
        @NotNull
        Long memberId;

        @AcceptMission
        Long missionId;
    }
}
