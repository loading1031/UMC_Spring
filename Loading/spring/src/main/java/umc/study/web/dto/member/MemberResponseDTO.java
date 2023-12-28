package umc.study.web.dto.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        Long memberId;
        LocalDateTime createdAt;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AcceptMissionResultDTO{
        Long memberMissionId;
        MissionStatus status;
        LocalDateTime createdAt;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AcceptMissionPreviewDTO{
        String missionSpec;
        Integer point;
        MissionStatus status;
        LocalDate deadline;
        LocalDateTime createdAt;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AcceptMissionPreviewListDTO{
        List<AcceptMissionPreviewDTO> memberMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompleteMissionResultDTO {
        String missionSpec;
        Integer point;
        MissionStatus status;
        LocalDate deadline;
        LocalDateTime updatedAt;
    }
}
