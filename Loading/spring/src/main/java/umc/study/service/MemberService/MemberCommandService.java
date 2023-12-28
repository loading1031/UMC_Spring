package umc.study.service.MemberService;

import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.member.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
    Member getMember(Long id);
    boolean isExistCategorry(Long foodCategory);
    MemberMission getMemberMission(Long memberMissionId);
}
