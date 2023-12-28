package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Float score;
    // 추가
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    // 추가
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public void setReview(Member member, Store store){
        if(this.member != null)
            member.getReviewList().remove(this);
        if(this.store != null)
            store.getReviewList().remove(this);
        this.member = member;
        this.store = store;

        this.member.getReviewList().add(this);
        this.store.getReviewList().add(this);
    }
}
