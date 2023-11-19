package umc.bob.domain.mapping;

import lombok.*;
import umc.bob.domain.Sales;
import umc.bob.domain.common.BaseEntity;
import umc.bob.domain.enums.BuyStatus;
import umc.bob.domain.member.Member;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BuySales extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private BuyStatus status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_id")
    private Sales sales;

    @OneToOne(fetch = FetchType.LAZY)
    //@OneToOne(mappedBy = "BuySales",cascade = CascadeType.ALL)
    @JoinColumn(name = "pHistory_id")
    //@JoinColumn(name = "member_id") 두개 JOIN 하려 했는데, 계속 FK 갯수 에러 떠서 지움
    private PointHistory pointHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
