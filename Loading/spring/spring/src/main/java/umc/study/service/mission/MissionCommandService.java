package umc.study.service.mission;

import umc.study.domain.Mission;
import umc.study.web.dto.mission.MissionRequestDTO;

public interface MissionCommandService {
    public Mission toMission(MissionRequestDTO.MissionDTO request);
}
