package umc.study.web.controller.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.member.complete.MissionConverter;
import umc.study.web.dto.member.complete.CompleteMissionResponse;
import umc.study.web.dto.member.ongoing.OngoingMissionResponse;

@RestController
@RequestMapping("user/missions")
public class MissionRestController {
    @GetMapping("/complete")
    public ApiResponse<CompleteMissionResponse.MissionResultDTO>completeMissionAPI(){
            return ApiResponse.onSuccess(MissionConverter.toCompleteDTO());
    }
    @GetMapping("/challenge")
    public ApiResponse<OngoingMissionResponse.MissionResultDTO>ongoingMissionAPI(){
        return ApiResponse.onSuccess(umc.study.converter.member.ongoing.MissionConverter.toOngoingDTO());
    }

}
