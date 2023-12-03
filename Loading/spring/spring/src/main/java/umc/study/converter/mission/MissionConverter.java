package umc.study.converter.mission;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.mission.MissionRequestDTO;
import umc.study.web.dto.mission.MissionResponseDTO;

import java.util.ArrayList;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.MissionDTO request, Store store){
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .store(store)
                .deadline(request.getDeadline())
                .memberMissionList(new ArrayList<>())
                .reward(request.getReward())
                .build();
    }

    public static MissionResponseDTO.MissionResultDTO toMissionResultDTO(Mission mission){
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .memberMissionList(new ArrayList<>())
                .build();
    }
}
