package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.RegionHandler;
import umc.study.converter.store.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.store.StoreRequestDTO;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddDTO request){

        Region foundRegion = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        // 있는 지역인지 검사
        Store newStore = StoreConverter.toStore(request,foundRegion);
        // 있는 지역이면, store 저장
        return storeRepository.save(newStore);
    }
}
