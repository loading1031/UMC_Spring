package umc.study.converter.store;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Region;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store){
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .RegionId(store.getRegion().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Store toStore(StoreRequestDTO.JoinDTO request, Region region){
        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .region(region)
                .missionList(new ArrayList<>())
                .build();
    }
    public static Review toReview(StoreRequestDTO.ReveiwDTO request, Member member, Store store){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .content(request.getBody())
                .member(member)
                .store(store)
                .build();
    }
    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreResponseDTO.CreateReviewResultDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                //.createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
