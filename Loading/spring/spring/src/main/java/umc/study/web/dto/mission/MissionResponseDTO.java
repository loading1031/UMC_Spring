package umc.study.web.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.mapping.MemberMission;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MissionResponseDTO {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionResultDTO{
        Long missionId;
        String missionSpec;
        Integer reward;
        LocalDate deadline;
        Long storeId;
        List<MemberMission> memberMissionList;
    }
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionListResultDTO{
        List<Long> missionId;
    }

}
