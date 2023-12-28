package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.MemberMission;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String missionSpec;
    @Column(nullable = false)
    private Integer reward;
    @Column(nullable = false, length = 6)
    private LocalDate deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    public void setMission(Store store){
        if(this.store != null){
            this.store.getMissionList().remove(this);
        } // 미션 정보를 만들었는데, 상점 정보가 있어.
        // 그러면, 해당 상점 미션리스트에서 이 미션을 일단 빼(초기화)
        this.store=store;
        // 상점 정보를 다시 세팅해주고
        this.store.getMissionList().add(this);
        // 해당 상점에 다시 미션 추가해줌.
    }
}
