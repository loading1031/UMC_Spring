package umc.study.converter.store;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store){
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Store toStore(StoreRequestDTO.JoinDTO request, Region region){
        return Store.builder()
                .address(request.getAddress())
                .score(request.getScore())
                .name(request.getName())
                .region(region)
                .missionList(new ArrayList<>())
                .build();
    }
}
