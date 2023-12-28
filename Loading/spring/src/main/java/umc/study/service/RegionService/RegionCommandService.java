package umc.study.service.RegionService;

import umc.study.domain.Region;
import umc.study.domain.Store;

public interface RegionCommandService {

    public Region getRegion(Long regionId);
    public void addStoreList(Region region, Store store);
    // 가게 생성후, 지역 엔티티의 지역 가게 리스트 갱신
    // 지역은 클라이언트에서 추가하는게 아닌 서버에서 바로 추가한다 가정.
    // 지역내의 상점 리스트만 갱신해주면 됨.
}
