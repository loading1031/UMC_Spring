package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.member.MemberRequestDTO;


public interface MemberQueryService {
    public MemberMission acceptMission(MemberRequestDTO.AcceptMissionDTO request);
    public boolean isAcceptMssion(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);
}
