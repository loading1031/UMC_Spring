package umc.study.converter.member;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.member.MemberResponseDTO;


import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Mission mission, Member member){

        return MemberMission.builder()
                .mission(mission)
                .member(member)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
    public static MemberResponseDTO.AcceptMissionResultDTO toAcceptMissionResultDTO(MemberMission request){

        return MemberResponseDTO.AcceptMissionResultDTO.builder()
                .memberMissionId(request.getId())
                .createdAt(LocalDateTime.now())
                .status(request.getStatus())
                .build();
    }
    public static MemberResponseDTO.AcceptMissionPreviewDTO toAcceptMissionPreviewDTO(MemberMission request){
        return MemberResponseDTO.AcceptMissionPreviewDTO.builder()
                .missionSpec(request.getMission().getMissionSpec())
                .point(request.getMission().getReward())
                .status(request.getStatus())
                .deadline(request.getMission().getDeadline())
                .createdAt(request.getCreatedAt())
                .build();
    }
    public static List<MemberResponseDTO.AcceptMissionPreviewDTO> acceptMissionPreviewList(Page<MemberMission> request, MissionStatus status){
        List<MemberResponseDTO.AcceptMissionPreviewDTO> acceptMissionPreviewList = request.stream()
                .map(MemberMissionConverter::toAcceptMissionPreviewDTO)
                .toList();
        if (status==null) return acceptMissionPreviewList;
        else return acceptMissionPreviewList.stream()
                .filter(memberMission->memberMission.getStatus().equals(status))
                .toList();
    }
    public static MemberResponseDTO.AcceptMissionPreviewListDTO toAcceptMissionPreviewListDTO(Page<MemberMission> request, MissionStatus status){
        List<MemberResponseDTO.AcceptMissionPreviewDTO> acceptMissionPreviewList = acceptMissionPreviewList(request,status);

        return MemberResponseDTO.AcceptMissionPreviewListDTO.builder()
                .memberMissionList(acceptMissionPreviewList)
                .listSize(acceptMissionPreviewList.size())
                .isFirst(request.isFirst())
                .totalElements(request.getTotalElements())
                .totalPage(request.getTotalPages())
                .build();
    }
}
