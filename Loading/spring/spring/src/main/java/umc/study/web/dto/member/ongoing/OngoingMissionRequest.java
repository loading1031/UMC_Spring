package umc.study.web.dto.member.ongoing;
import lombok.Getter;

import javax.validation.constraints.NotNull;


public class OngoingMissionRequest {
    @Getter
    public static class MissionDTO{
        @NotNull
        Long userId;
    }
}
