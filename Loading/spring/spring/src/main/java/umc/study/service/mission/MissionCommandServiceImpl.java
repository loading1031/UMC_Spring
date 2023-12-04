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
        // 가게 추출
        Store store = storeCommandService.getStore(request.getStoreId());
        // 미션 추출
        Mission mission = MissionConverter.toMission(request,store);
        // store에 미션 리스트 저장
        mission.setMission(store);
        // DB에 미션 저장
        return missionRepository.save(mission);
    }
}
