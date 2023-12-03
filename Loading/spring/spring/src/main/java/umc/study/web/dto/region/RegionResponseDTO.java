package umc.study.web.dto.region;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class RegionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegionResultDTO{
        Long regionId;
        String RegionName;
        List<Long> storeList;
    }
}
