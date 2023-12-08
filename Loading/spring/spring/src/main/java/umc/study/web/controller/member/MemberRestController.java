package umc.study.web.controller.member;


import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Join a new member API",description = "API to join a new member")
    @Parameters({
            @Parameter(name = "name", description = "유저명"),
            @Parameter(name = "gender", description = "성별"),
            @Parameter(name = "birthYear", description = "생년"),
            @Parameter(name = "birthMonth", description = "생월"),
            @Parameter(name = "birthDay", description = "생일"),
            @Parameter(name = "address", description = "주소"),
            @Parameter(name = "specAddress", description = "상세주소"),
            @Parameter(name = "preferCategory", description = "음식 선호 카테고리"),
    })
    @PostMapping("")
    public ApiResponse<MemberResponseDTO.JoinResultDTO>
    memberJoin(@RequestBody @Valid MemberRequestDTO.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

}
