package umc.study.web.dto.mission;

import lombok.Getter;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MissionRequestDTO {
    @Getter
    public static class MissionDTO{
        @NotBlank
        String missionSpec;
        @NotNull
        Integer reward;
        LocalDate deadline;
        @NotNull
        Long storeId;
    }
    @Getter
    public static class MissionListDTO{
        @NotNull
        Long storeId;
    }
}
