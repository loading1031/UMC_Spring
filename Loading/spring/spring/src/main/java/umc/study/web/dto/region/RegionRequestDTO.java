package umc.study.web.dto.region;

import lombok.Getter;

import javax.validation.constraints.NotNull;

public class RegionRequestDTO {

    @Getter
    public static class RegionDTO{
        @NotNull
        Long RegionId;
    }
}
