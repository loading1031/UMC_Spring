package umc.study.converter.member.mission;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.member.mission.MemberMissionRequestDTO;
import umc.study.web.dto.member.mission.MemberMissionResponseDTO;

import javax.print.DocFlavor;
import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(MemberMissionRequestDTO.MemberMissionDTO request, Mission mission, Member member){

        return MemberMission.builder()
                .mission(mission)
                .member(member)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionResultDTO toMemberMissionDTO(MemberMission request){

        return MemberMissionResponseDTO.MemberMissionResultDTO.builder()
                .missionId(request.getMission().getId())
                .memberId(request.getMember().getId())
                .createdAt(LocalDateTime.now())
                .status(request.getStatus())
                .build();
    }
}
