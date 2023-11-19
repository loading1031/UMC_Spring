package umc.bob.domain.member;

import lombok.*;
import umc.bob.domain.PostCode;
import umc.bob.domain.member.Point;
import umc.bob.domain.common.BaseEntity;

import umc.bob.domain.enums.Gender;
import umc.bob.domain.enums.MemberStatus;

import umc.bob.domain.mapping.MemberAgree;
import umc.bob.domain.mapping.MemberMission;
import umc.bob.domain.mapping.MemberPrefer;
import umc.bob.domain.mapping.Review;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 40)
    private String address;
    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    @Column(nullable = true, length = 6)
    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;

    // 추가
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostCode postCode;

    @OneToOne(mappedBy = "member",cascade = CascadeType.ALL)
    private Point point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
