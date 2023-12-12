package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.member.MemberRequestDTO;


public interface MemberQueryService {
    MemberMission acceptMission(MemberRequestDTO.AcceptMissionDTO request);
     boolean isAcceptMssion(MemberRequestDTO.AcceptMissionDTO request);
    Page<Review> getReviewList(Long memberId, Integer page);
    Page<MemberMission> getAcceptMissionList(Long memberId, Integer page);
}
