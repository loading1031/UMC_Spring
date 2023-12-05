package umc.study.web.dto.member.mission;

import lombok.Getter;
import umc.study.validation.annotation.AcceptMission;

import javax.validation.constraints.NotNull;

public class MemberMissionRequestDTO {

    @Getter
    public static class MemberMissionDTO{
        @AcceptMission
        FkList memberId_missionId;
    }
    @Getter
    public static class FkList{
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
