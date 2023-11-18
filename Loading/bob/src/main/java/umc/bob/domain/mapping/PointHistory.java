package umc.bob.domain.mapping;

import lombok.*;

import umc.bob.domain.common.BaseEntity;
import umc.bob.domain.member.Point;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PointHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer change;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "point_id")
    //@JoinColumn(name = "member_id")
    private Point point;

    @OneToOne(mappedBy = "pointHistory",cascade = CascadeType.ALL)
    private MemberMission memberMissionList;

    //@OneToOne(fetch = FetchType.LAZY)
    //@OneToOne(mappedBy = "pointHistory",cascade = CascadeType.ALL)
    //private BuySales buySales;
}


