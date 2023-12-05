package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.member.mission.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.service.missionService.MissionCommandService;
import umc.study.web.dto.member.mission.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberCommandService memberCommandService;
    private final MissionCommandService missionCommandService;
    @Override
    @Transactional
    public MemberMission acceptMission(MemberMissionRequestDTO.MemberMissionDTO request) {
        Member member = memberCommandService.getMember(request.getMemberId());
        Mission mission = missionCommandService.getMission(request.getMissionId());
        MemberMission memberMission = MemberMissionConverter.toMemberMission(request,mission,member);
        memberMission.setMemberMission(member,mission);
        return memberMissionRepository.save(memberMission);
    }
}
