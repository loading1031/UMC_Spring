package umc.study.service.ReviewService;

import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.review.ReviewRequestDTO;

public interface ReviewCommandService {
    Review toReview(ReviewRequestDTO.ReviewDTO request);
}
