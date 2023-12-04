package umc.study.web.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.member.complete.MissionConverter;
import umc.study.converter.member.mission.MemberMissionConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.web.dto.member.complete.CompleteMissionResponse;
import umc.study.web.dto.member.mission.MemberMissionRequestDTO;
import umc.study.web.dto.member.mission.MemberMissionResponseDTO;
import umc.study.web.dto.member.ongoing.OngoingMissionResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("user/missions")
public class MissionRestController {
    private final MemberQueryService memberQueryService;
    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionResultDTO>acceptMission(@RequestBody@Valid MemberMissionRequestDTO.MemberMissionDTO request){
        MemberMission memberMission = memberQueryService.acceptMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionDTO(memberMission));
    }

    /*
    @GetMapping("/complete")
    public ApiResponse<CompleteMissionResponse.MissionResultDTO>completeMissionAPI(){
            return ApiResponse.onSuccess(MissionConverter.toCompleteDTO());
    }
    @GetMapping("/challenge")
    public ApiResponse<OngoingMissionResponse.MissionResultDTO>ongoingMissionAPI(){
        return ApiResponse.onSuccess(umc.study.converter.member.ongoing.MissionConverter.toOngoingDTO());
    }
     */

}
