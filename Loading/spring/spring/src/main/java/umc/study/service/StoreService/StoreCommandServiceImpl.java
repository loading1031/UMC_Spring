package umc.study.service.StoreService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.store.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository;
import umc.study.service.RegionService.RegionCommandService;
import umc.study.service.RegionService.RegionCommandServiceImpl;
import umc.study.web.dto.store.StoreRequestDTO;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final RegionCommandService regionCommandService;
    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinDTO request) {

        Region region = regionCommandService.getRegion(request.getRegionId());
        Store store = StoreConverter.toStore(request,region);
        regionCommandService.addStoreList(region,store);
        // 지역에 가게 추가
        return storeRepository.save(store);
    }

}
