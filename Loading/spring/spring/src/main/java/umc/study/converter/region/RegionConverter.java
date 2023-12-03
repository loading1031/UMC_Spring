package umc.study.converter.region;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.region.RegionResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class RegionConverter {
    public static RegionResponseDTO.RegionResultDTO toRegionResultDTO(Region request) {
        /*
        List<Long> storeIds = request.getStoreList().stream()
                .map(Store::getId) // Store 객체에서 id 추출
                .collect(Collectors.toList());
*/
        return RegionResponseDTO.RegionResultDTO.builder()
                .regionId(request.getId())
                .RegionName(request.getName())
                //.storeList(storeIds)
                .updatedAt(request.getUpdatedAt())
                .build();
    }
}
