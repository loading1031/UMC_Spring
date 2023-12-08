package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.store.StoreConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.web.dto.review.ReviewRequestDTO;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final MemberCommandService memberService;
    private final StoreCommandService storeService;
    @Override
    @Transactional
    public Review toReview(StoreRequestDTO.ReveiwDTO request){
        Member findMember = memberService.getMember(request.getMemberId());
        Store findStore = storeService.getStore(request.getStoreId());
        Review review = StoreConverter.toReview(request, findMember, findStore);

        review.setReview(findMember,findStore);
        findStore.setScore(review);

        return reviewRepository.save(review);
    }
    @Override
    public Page<Review> findAllByStore(Store store, PageRequest pageRequest) {
        return reviewRepository.findAllByStore(store, pageRequest);
    }
}
