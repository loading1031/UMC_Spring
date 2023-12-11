package umc.study.converter.member.mission;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.member.MemberResponseDTO;


import javax.print.DocFlavor;
import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Mission mission, Member member){

        return MemberMission.builder()
                .mission(mission)
                .member(member)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MemberResponseDTO.AcceptMissionResultDTO toMemberMissionDTO(MemberMission request){

        return MemberResponseDTO.AcceptMissionResultDTO.builder()
                .memberMissionId(request.getId())
                .createdAt(LocalDateTime.now())
                .status(request.getStatus())
                .build();
    }
}
