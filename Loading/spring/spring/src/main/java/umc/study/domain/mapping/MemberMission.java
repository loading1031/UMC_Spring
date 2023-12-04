package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MissionStatus;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;
    // 추가
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    // 추가
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void setMemberMission(Member member, Mission mission){
        if(this.member != null){
            this.member.getMemberMissionList().remove(this);
        }
        if(this.mission != null){
            this.mission.getMemberMissionList().remove(this);
        }
        this.member = member;
        this.mission = mission;

        this.member.getMemberMissionList().add(this);
        this.mission.getMemberMissionList().add(this);
    }
}
