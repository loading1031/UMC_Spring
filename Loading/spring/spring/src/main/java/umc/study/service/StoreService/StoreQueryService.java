package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.review.ReviewRequestDTO;
import umc.study.web.dto.store.StoreRequestDTO;

public interface StoreQueryService {
    Page<Review> getReviewList(Long StoreId, Integer page);
    Review toReview(StoreRequestDTO.ReveiwDTO request);
}
