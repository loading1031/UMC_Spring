package umc.study.repository;

import umc.study.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.web.dto.member.MemberRequestDTO;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
