package umc.study.converter.review;

import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.review.ReviewRequestDTO;
import umc.study.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review request){
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .reviewId(request.getId())
                .memberId(request.getMember().getId())
                .storeId(request.getStore().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewDTO request, Member member, Store store){
        return Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }
}
