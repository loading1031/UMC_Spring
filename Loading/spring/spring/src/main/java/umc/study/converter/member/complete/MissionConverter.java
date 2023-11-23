package umc.study.converter.member.complete;
import umc.study.domain.enums.MissionStatus;
import umc.study.web.dto.member.complete.CompleteMissionResponse;

import java.time.LocalDate;

public class MissionConverter {
    public static CompleteMissionResponse.MissionResultDTO toCompleteDTO(){
        return CompleteMissionResponse.MissionResultDTO.builder()
                .missionSpec("완료 미션")
                .reward(1)
                .deadline(LocalDate.now())
                .storeId(1L)
                .status(MissionStatus.COMPLETE)
                .build();
    }
}
