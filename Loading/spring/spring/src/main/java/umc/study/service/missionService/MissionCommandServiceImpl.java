package umc.study.service.missionService;

//import ch.qos.logback.core.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.converter.store.mission.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.web.dto.mission.MissionRequestDTO;

import java.util.Optional;

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

    @Override
    public Mission getMission(Long id) {
        Optional<Mission> mission = missionRepository.findById(id);
        return mission.orElseThrow(()-> new MissionHandler(ErrorStatus.MISSION_NOT_EXIST));
    }
}
