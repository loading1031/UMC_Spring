package umc.study.web.dto.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.Review;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponseDTO {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewResultDTO{
        Long reviewId;
        String title;
        String content;
        Long memberId;
        Long storeId;
        LocalDateTime createdAt;
    }
}
