package umc.study.web.controller.store;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.mission.MissionConverter;
import umc.study.converter.review.ReviewConverter;
import umc.study.converter.store.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.service.missionService.MissionCommandService;
import umc.study.web.dto.mission.MissionRequestDTO;
import umc.study.web.dto.mission.MissionResponseDTO;
import umc.study.web.dto.review.ReviewRequestDTO;
import umc.study.web.dto.review.ReviewResponseDTO;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    private final MissionCommandService missionCommandService;
    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> join(@RequestBody @Valid StoreRequestDTO.JoinDTO request){
        Store store = storeCommandService.joinStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }
    @PostMapping("/writeReview")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> write(@RequestBody @Valid ReviewRequestDTO.ReviewDTO request){
        Review review = reviewCommandService.toReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }

    @PostMapping("/makeMission")
    public ApiResponse<MissionResponseDTO.MissionResultDTO> make(@RequestBody @Valid MissionRequestDTO.MissionDTO request){
        Mission mission = missionCommandService.toMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));
    }

    @GetMapping("/showMission")
    public ApiResponse<MissionResponseDTO.MissionListResultDTO> show(@RequestParam("storeId") @Valid Long storeId){
        Store store = storeCommandService.getStore(storeId);
        return ApiResponse.onSuccess(MissionConverter.toMissionListResultDTO(store));
    }
}
