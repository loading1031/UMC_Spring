package umc.study.service.MemberService;

import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.member.mission.MemberMissionRequestDTO;

public interface MemberQueryService {
    public MemberMission acceptMission(MemberMissionRequestDTO.MemberMissionDTO request);
    public boolean isAcceptMssion(Long id);
}
