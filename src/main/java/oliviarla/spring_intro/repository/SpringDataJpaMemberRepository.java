package oliviarla.spring_intro.repository;

import oliviarla.spring_intro.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}

//인터페이스만 있으므로 구현체를 자동으로 생성 후 스프링 빈에 등록해줌