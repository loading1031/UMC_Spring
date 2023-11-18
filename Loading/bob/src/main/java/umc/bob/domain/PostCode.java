package umc.bob.domain;


import lombok.*;
import umc.bob.domain.common.BaseEntity;
import umc.bob.domain.member.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostCode extends BaseEntity {
    @Id
    private Long id;
    // 우편번호(지역번호) : 자동증가 x
    @OneToMany(mappedBy = "postCode",cascade = CascadeType.ALL)
    private List<Member> memberList = new ArrayList<>();
}
