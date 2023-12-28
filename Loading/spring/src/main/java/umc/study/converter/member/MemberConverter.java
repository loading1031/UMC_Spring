package umc.study.converter.member;

import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.member.MemberRequestDTO;
import umc.study.web.dto.member.MemberResponseDTO;
import umc.study.domain.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberConverter {
    public  static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Member toMember(MemberRequestDTO.JoinDTO request) {
        Gender gender = switch (request.getGender()) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.NONE;
            default -> null;
        };

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .name(request.getName())
                .gender(gender)
                .memberPreferList(new ArrayList<>())
                .build();
    }

}
