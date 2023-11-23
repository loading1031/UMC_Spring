package umc.study.converter.member.ongoing;
import umc.study.domain.enums.MissionStatus;
import umc.study.web.dto.member.ongoing.OngoingMissionResponse;

import java.time.LocalDate;

public class MissionConverter {
    public static OngoingMissionResponse.MissionResultDTO toOngoingDTO(){
        return OngoingMissionResponse.MissionResultDTO.builder()
                .missionSpec("진행 미션")
                .reward(1)
                .deadline(LocalDate.now())
                .storeId(1L)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
