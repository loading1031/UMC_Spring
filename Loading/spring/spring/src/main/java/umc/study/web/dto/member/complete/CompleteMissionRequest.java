package umc.study.web.dto.member.complete;
import lombok.Getter;

import javax.validation.constraints.NotNull;


public class CompleteMissionRequest {
    @Getter
    public static class MissionDTO{
        @NotNull
        Long userId;
    }
}
