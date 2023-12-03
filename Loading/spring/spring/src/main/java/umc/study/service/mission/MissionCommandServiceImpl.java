package umc.study.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.mission.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.web.dto.mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final StoreCommandService storeCommandService;
    @Override
    @Transactional
    public Mission toMission(MissionRequestDTO.MissionDTO request){

        Store store = storeCommandService.getStore(request.getStoreId());
        Mission mission = MissionConverter.toMission(request,store);

        return missionRepository.save(mission);
    }
}
