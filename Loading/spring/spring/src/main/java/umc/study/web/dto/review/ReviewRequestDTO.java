package umc.study.web.dto.review;

import lombok.Getter;
import umc.study.domain.Member;
import umc.study.domain.Store;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewDTO{
        @NotNull
        Float score;
        @NotBlank
        String title;
        @NotBlank
        String content;
        @NotNull
        Long memberId;
        @NotNull
        Long storeId;
    }
}
