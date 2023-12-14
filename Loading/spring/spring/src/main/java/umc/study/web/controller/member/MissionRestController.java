
package umc.study.web.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.member.MemberConverter;
import umc.study.converter.member.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.validation.annotation.AcceptMission;
import umc.study.web.dto.member.MemberRequestDTO;
import umc.study.web.dto.member.MemberResponseDTO;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("members/{memberId}/missions")
public class MissionRestController {
    private final MemberQueryService memberQueryService;
    private final MemberCommandService memberCommandService;

    @GetMapping("")
    public ApiResponse<MemberResponseDTO.AcceptMissionPreviewListDTO> getAcceptMissionList
            (@PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = memberQueryService.getAcceptMissionList(memberId,page);
        return ApiResponse.onSuccess(MemberMissionConverter.toAcceptMissionPreviewListDTO(memberMissionList,null));
    }
    @GetMapping("/challenge")
    public ApiResponse<MemberResponseDTO.AcceptMissionPreviewListDTO> getChallengeMissionList
            (@PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = memberQueryService.getAcceptMissionList(memberId,page);
        return ApiResponse.onSuccess(MemberMissionConverter.toAcceptMissionPreviewListDTO(memberMissionList, MissionStatus.CHALLENGING));
    }

    @GetMapping("/complete")
    public ApiResponse<MemberResponseDTO.AcceptMissionPreviewListDTO> getCompleteMissionList
            (@PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = memberQueryService.getAcceptMissionList(memberId,page);
        return ApiResponse.onSuccess(MemberMissionConverter.toAcceptMissionPreviewListDTO(memberMissionList, MissionStatus.COMPLETE));
    }
    @PostMapping("/accept")
    public ApiResponse<MemberResponseDTO.AcceptMissionResultDTO>acceptMission
            (@PathVariable("memberId")Long memberId,  @RequestBody @Valid @AcceptMission MemberRequestDTO.AcceptMissionDTO request){

        MemberMission memberMission = memberQueryService.acceptMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toAcceptMissionResultDTO(memberMission));
    }
    @GetMapping("/{memberMissionId}")
    public ApiResponse<Long> verificationCode
            (@PathVariable(name = "memberId") Long memberId, @PathVariable(name = "memberMissionId") Long memberMissionId){
        return ApiResponse.onSuccess(memberMissionId);
    }
}

