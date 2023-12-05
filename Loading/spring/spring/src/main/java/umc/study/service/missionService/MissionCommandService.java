package umc.study.service.missionService;

import umc.study.domain.Mission;
import umc.study.web.dto.mission.MissionRequestDTO;

public interface MissionCommandService {
    public Mission toMission(MissionRequestDTO.MissionDTO request);
    public Mission getMission(Long id);
}
