package umc.study.web.dto.store;

import lombok.Getter;
import umc.study.domain.Mission;
import umc.study.domain.Region;
import umc.study.validation.annotation.ExistCategories;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class StoreRequestDTO {
    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;
        @NotBlank
        String address;
        @NotNull
        Long regionId;
    }
    @Getter
    public static class ReveiwDTO {
        @NotBlank
        String title;
        @NotNull
        Float score;
        @NotBlank
        String body;
        @NotNull
        Long memberId;
        @NotNull
        Long storeId;
    }
    @Getter
    public static class MissionDTO{
        @NotBlank
        String missionSpec;
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotNull
        Long storeId;
    }
}
