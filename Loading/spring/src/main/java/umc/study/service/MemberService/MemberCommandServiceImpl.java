package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.exception.handler.MemberMissionHandler;
import umc.study.converter.member.MemberConverter;
import umc.study.converter.member.MemberPreferConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.web.dto.member.MemberRequestDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MemberMissionRepository memberMissionRepository;
    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request){
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category->{
                    return foodCategoryRepository.findById(category).orElseThrow(()->
                            new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    public Member getMember(Long id) {
        Optional<Member> findMember = memberRepository.findById(id);
        return findMember.orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)) ;
    }

    @Override
    public boolean isExistCategorry(Long foodCategory) {
        return foodCategoryRepository.existsById(foodCategory);
    }

    @Override
    public MemberMission getMemberMission(Long memberMissionId) {
        return memberMissionRepository.findById(memberMissionId)
                .orElseThrow(()->new MemberMissionHandler(ErrorStatus.ACCEPT_MISSION_NOT_FOUND));
    }
}
