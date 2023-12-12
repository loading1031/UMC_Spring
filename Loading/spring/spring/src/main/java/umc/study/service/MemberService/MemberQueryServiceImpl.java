package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.member.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.service.missionService.MissionCommandService;
import umc.study.web.dto.member.MemberRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberCommandService memberCommandService;
    private final MissionCommandService missionCommandService;
    private final ReviewCommandService reviewCommandService;
    @Override
    @Transactional
    public MemberMission acceptMission(MemberRequestDTO.AcceptMissionDTO request) {
        Member member = memberCommandService.getMember(request.getMemberId());
        Mission mission = missionCommandService.getMission(request.getMissionId());
        MemberMission memberMission = MemberMissionConverter.toMemberMission(mission,member);
        memberMission.setMemberMission(member,mission);
        return memberMissionRepository.save(memberMission);
    }
    @Override
    public boolean isAcceptMssion(MemberRequestDTO.AcceptMissionDTO request) {
        System.out.println("실행됨2");
        Member member = memberCommandService.getMember(request.getMemberId());

        return member.getMemberMissionList().stream()
                .anyMatch(memberMission -> memberMission.getMission()
                        .getId().equals(request.getMissionId()));
    }
    @Override
    public Page<Review> getReviewList(Long memberId, Integer page){
        Member member = memberCommandService.getMember(memberId);
        return reviewCommandService.findAllByMember(
                member, PageRequest.of(page,10)
        );
    }
    @Override
    public Page<MemberMission> getAcceptMissionList(Long memberId, Integer page){
        Member member = memberCommandService.getMember(memberId);
        return memberMissionRepository.findAllByMember(
                member, PageRequest.of(page,10)
        );
    }

}
