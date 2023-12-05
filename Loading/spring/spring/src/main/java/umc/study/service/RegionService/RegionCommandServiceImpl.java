package umc.study.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.RegionHandler;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionCommandServiceImpl implements RegionCommandService {
    private final RegionRepository regionRepository;
    @Override
    public Region getRegion(Long regionId) {
        Optional<Region> region = regionRepository.findById(regionId);
        return region.orElseThrow(()->new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
    }
    @Override
    @Transactional
    public void addStoreList(Region region, Store store) {
        region.addStore(store);
        regionRepository.save(region);
    }   // 가게 생성후, 지역 엔티티의 지역 가게 리스트 갱신
}
