
package umc.study.web.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.member.MemberConverter;
import umc.study.converter.member.MemberMissionConverter;
import umc.study.domain.Member;
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
    public ApiResponse<MemberResponseDTO.AcceptMissionPreviewListDTO> getAcceptMissionList(@PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = memberQueryService.getAcceptMissionList(memberId,page);
        return ApiResponse.onSuccess(MemberMissionConverter.toAcceptMissionPreviewListDTO(memberMissionList));
    }

    @GetMapping("/challenge")
    public ApiResponse<List<Long>>challengeShow(@PathVariable("memberId")Long memberId){
        Member member = memberCommandService.getMember(memberId);
        return ApiResponse.onSuccess(MemberConverter.toChallengeMissionList(member));
    }
    @GetMapping("/complete")
    public ApiResponse<List<Long>>completeShow(@PathVariable("memberId")Long memberId){
        Member member = memberCommandService.getMember(memberId);
        return ApiResponse.onSuccess(MemberConverter.toCompleteMissionList(member));
    }
    @PostMapping("/accept")
    public ApiResponse<MemberResponseDTO.AcceptMissionResultDTO>acceptMission
            (@PathVariable("memberId")Long memberId,  @RequestBody @Valid @AcceptMission MemberRequestDTO.AcceptMissionDTO request){

        return null;
        /*
        MemberMission memberMission = memberQueryService.acceptMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toAcceptMissionResultDTO(memberMission));
         */
    }
}

