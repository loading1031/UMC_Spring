package umc.study.web.controller.member;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.member.MemberConverter;
import umc.study.converter.review.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.web.dto.member.MemberRequestDTO;
import umc.study.web.dto.member.MemberResponseDTO;
import umc.study.web.dto.review.ReviewRequestDTO;
import umc.study.web.dto.review.ReviewResponseDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    @PostMapping("")
    @ApiOperation(value = "Join a new member", notes = "API to join a new member")
    public ApiResponse<MemberResponseDTO.JoinResultDTO>
    memberJoin(@RequestBody @Valid MemberRequestDTO.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

}
