package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.service.missionService.MissionCommandService;
import umc.study.web.dto.store.StoreRequestDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    private final MissionCommandService missionCommandService;
    private final MemberQueryService memberQueryService;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page){
        Store store = storeCommandService.getStore(storeId);
        return reviewCommandService.findAllByStore(
                store, PageRequest.of(page,10)
        );
    }
    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page){
        Store store = storeCommandService.getStore(storeId);
        return missionCommandService.findAllByStore(
                store, PageRequest.of(page,10)
        );
    }
    @Override
    @Transactional
    public Review toReview(StoreRequestDTO.ReveiwDTO request){
        return reviewCommandService.toReview(request);
    }
    @Override
    @Transactional
    public MemberMission patchMissionStatus(Long memberMissionId) {
        return memberQueryService.patchMissionStatus(memberMissionId);
    }
}
