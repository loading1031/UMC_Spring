package umc.study.web.controller.store;

import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.store.mission.MissionConverter;
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

    @PostMapping("")
    public ApiResponse<StoreResponseDTO.JoinResultDTO>
    storeJoin(@RequestBody @Valid StoreRequestDTO.JoinDTO request){
        Store store = storeCommandService.joinStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }

    @PostMapping("/Review/create")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> write(@RequestBody @Valid ReviewRequestDTO.ReviewDTO request){
        Review review = reviewCommandService.toReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }

    @GetMapping("/Mission")
    public ApiResponse<MissionResponseDTO.MissionListResultDTO> show(@RequestParam("storeId") @Valid Long storeId){
        Store store = storeCommandService.getStore(storeId);
        return ApiResponse.onSuccess(MissionConverter.toMissionListResultDTO(store));
    }
    @PostMapping("/Mission/create")
    public ApiResponse<MissionResponseDTO.MissionResultDTO> make(@RequestBody @Valid MissionRequestDTO.MissionDTO request){
        Mission mission = missionCommandService.toMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));
    }
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{storeId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){
        storeQueryService.getReviewList(storeId,page);
        return null;
    }
}
