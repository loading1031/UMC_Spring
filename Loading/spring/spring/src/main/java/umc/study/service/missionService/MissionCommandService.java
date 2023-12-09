package umc.study.service.missionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.mission.MissionRequestDTO;

public interface MissionCommandService {
    public Mission toMission(MissionRequestDTO.MissionDTO request);
    public Mission getMission(Long id);

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
