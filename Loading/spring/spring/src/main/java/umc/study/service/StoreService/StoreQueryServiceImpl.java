package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;
import umc.study.service.ReviewService.ReviewCommandService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    @Override
    public Page<Review> getReviewList(Long storeId, Integer page){
        Store store = storeCommandService.getStore(storeId);
        return reviewCommandService.findAllByStore(
                store, PageRequest.of(page,10)
        );
    }
}
