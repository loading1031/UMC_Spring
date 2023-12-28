package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.store.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository;
import umc.study.service.RegionService.RegionCommandService;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

import java.util.Optional;

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
    @Override
    public Store getStore(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        return store.orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_EXIST));
    }
    @Override
    public boolean isStore(Long id) {
        return storeRepository.existsById(id);
    }

}
