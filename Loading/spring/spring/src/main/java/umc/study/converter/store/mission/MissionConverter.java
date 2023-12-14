package umc.study.converter.store.mission;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {
    public static Mission toMission(StoreRequestDTO.MissionDTO request, Store store){
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .store(store)
                .deadline(request.getDeadline())
                .memberMissionList(new ArrayList<>())
                .reward(request.getReward())
                .build();
    }
    public static StoreResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission){
        return StoreResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static StoreResponseDTO.MissionPreViewDTO toMissionPreViewDTO(Mission mission){
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .missionSpec(mission.getMissionSpec())
                .storeName(mission.getStore().getName())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt())
                .build();
    }
    public static  StoreResponseDTO.MissionPreViewListDTO toMissionPreViewListDTO(Page<Mission>missionList){

        List<StoreResponseDTO.MissionPreViewDTO> missionPreviewList =
                missionList.stream()
                .map(MissionConverter::toMissionPreViewDTO)
                .toList();
        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .missionList(missionPreviewList)
                .listSize(missionList.getSize())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .build();
    }


}
