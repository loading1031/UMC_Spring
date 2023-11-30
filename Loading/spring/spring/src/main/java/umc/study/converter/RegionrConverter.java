package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.web.dto.region.RegionResponseDTO;

import java.util.List;

public class RegionrConverter {
    public static RegionResponseDTO.AddResultDTO toStoreRegion(Region region){
        return RegionResponseDTO.AddResultDTO.builder()
                .regionId(region.getId())
                .name(region.getName())
                .build();
    }
}
