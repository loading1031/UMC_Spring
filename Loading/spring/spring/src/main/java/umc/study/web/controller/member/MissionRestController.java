
package umc.study.web.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResult;
import umc.study.converter.member.MemberMissionConverter;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.validation.annotation.AcceptMission;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.IsCompleteMission;
import umc.study.web.dto.member.MemberRequestDTO;
import umc.study.web.dto.member.MemberResponseDTO;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("members/{memberId}/missions")
public class MissionRestController {
    private final MemberQueryService memberQueryService;

    @GetMapping("")
    public ApiResult<MemberResponseDTO.AcceptMissionPreviewListDTO> getAcceptMissionList
            (@PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = memberQueryService.getAcceptMissionList(memberId,page-1);
        return ApiResult.onSuccess(MemberMissionConverter.toAcceptMissionPreviewListDTO(memberMissionList,null));
    }
    @GetMapping("/challenge")
    public ApiResult<MemberResponseDTO.AcceptMissionPreviewListDTO> getChallengeMissionList
            (@PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = memberQueryService.getAcceptMissionList(memberId,page-1);
        return ApiResult.onSuccess(MemberMissionConverter.toAcceptMissionPreviewListDTO(memberMissionList, MissionStatus.CHALLENGING));
    }

    @GetMapping("/complete")
    public ApiResult<MemberResponseDTO.AcceptMissionPreviewListDTO> getCompleteMissionList
            (@PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = memberQueryService.getAcceptMissionList(memberId,page-1);
        return ApiResult.onSuccess(MemberMissionConverter.toAcceptMissionPreviewListDTO(memberMissionList, MissionStatus.COMPLETE));
    }
    @PostMapping("/accept")
    public ApiResult<MemberResponseDTO.AcceptMissionResultDTO> acceptMission
            (@PathVariable("memberId")Long memberId,  @RequestBody @Valid @AcceptMission MemberRequestDTO.AcceptMissionDTO request){

        MemberMission memberMission = memberQueryService.acceptMission(request);
        return ApiResult.onSuccess(MemberMissionConverter.toAcceptMissionResultDTO(memberMission));
    }
    @GetMapping("/{memberMissionId}")
    public ApiResult<Long> verificationCode
            (@PathVariable(name = "memberId") Long memberId,
             @IsCompleteMission @PathVariable(name = "memberMissionId") Long memberMissionId){
        return ApiResult.onSuccess(memberMissionId);
    }
}

