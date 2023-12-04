package umc.study.web.dto.member.mission;

import lombok.Getter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class MemberMissionRequestDTO {

    @Getter
    public static class MemberMissionDTO{
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
