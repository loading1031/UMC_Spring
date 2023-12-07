package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;

public interface StoreQueryService {
    Page<Review> getReviewList(Long StoreId, Integer page);
}
