package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.store.StoreRequestDTO;

public interface StoreQueryService {
    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Mission> getMissionList(Long storeId, Integer page);

    Review toReview(StoreRequestDTO.ReveiwDTO request);

    MemberMission patchMissionStatus(Long memberMissionId);
}
