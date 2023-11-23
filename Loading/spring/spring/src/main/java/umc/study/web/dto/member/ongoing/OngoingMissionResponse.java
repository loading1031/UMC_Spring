package umc.study.web.dto.member.ongoing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDate;

public class OngoingMissionResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionResultDTO{
        String missionSpec;
        Integer reward;
        LocalDate deadline;
        Long storeId;
        MissionStatus status;
    }
}
