package umc.study.web.controller.store;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.annotations.ApiResponses; -> 아래걸로 안하면 에러 발생
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResult;
import umc.study.converter.member.MemberMissionConverter;
import umc.study.converter.store.mission.MissionConverter;
import umc.study.converter.store.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.service.StoreService.StoreQueryService;
import umc.study.service.missionService.MissionCommandService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistStore;
import umc.study.validation.annotation.IsCompleteMission;
import umc.study.web.dto.member.MemberResponseDTO;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    private final MissionCommandService missionCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("")
    public ApiResult<StoreResponseDTO.JoinResultDTO>
    storeJoin(@RequestBody @Valid StoreRequestDTO.JoinDTO request){
        Store store = storeCommandService.joinStore(request);
        return ApiResult.onSuccess(StoreConverter.toJoinResultDTO(store));
    }

    @PostMapping("/review")
    public ApiResult<StoreResponseDTO.CreateReviewResultDTO> write(@RequestBody @Valid StoreRequestDTO.ReveiwDTO request){
        Review review = storeQueryService.toReview(request);
        return ApiResult.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }
    @GetMapping("/{storeId}/mission")
    public ApiResult<StoreResponseDTO.MissionPreViewListDTO>
    show(@ExistStore @PathVariable("storeId")Long storeId, Integer page){
        Page<Mission>missionList = storeQueryService.getMissionList(storeId,page);
        return ApiResult.onSuccess(MissionConverter.toMissionPreViewListDTO(missionList));
    }
    @PostMapping("/mission")
    public ApiResult<StoreResponseDTO.CreateMissionResultDTO> make(@RequestBody @Valid StoreRequestDTO.MissionDTO request){
        Mission mission = missionCommandService.toMission(request);
        return ApiResult.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{storeId}/reviews")
    @ApiResponses({
            @ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResult.class))),
            @ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResult.class))),
            @ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResult.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResult<StoreResponseDTO.ReviewPreViewListDTO> getReviewList
            (@ExistStore @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        return ApiResult.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }

    @PatchMapping("/userMission/{memberMissionId}/complete")
    public ApiResult<MemberResponseDTO.CompleteMissionResultDTO> completeMission
            (@IsCompleteMission @PathVariable (name = "memberMissionId") Long memberMissionId){
        MemberMission memberMission = storeQueryService.patchMissionStatus(memberMissionId);
        return ApiResult.onSuccess(MemberMissionConverter.toCompleteMissionResultDTO(memberMission));
    }
}
