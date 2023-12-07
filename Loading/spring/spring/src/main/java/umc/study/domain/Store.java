package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Float score;
    // 추가
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    public void setScore(Review review){
        boolean isReview =
                this.reviewList.stream().anyMatch(review1 -> Objects.equals(review1.getId(), review.getId()));
        if(!isReview) this.reviewList.add(review);

        float sum = (float) reviewList.stream()
                    .mapToDouble(Review::getScore)
                    .sum();
        this.score = sum/this.reviewList.size();
    }
}
