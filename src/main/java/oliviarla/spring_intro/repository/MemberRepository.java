package oliviarla.spring_intro.repository;

import oliviarla.spring_intro.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name); //Optional으로 널값 처리
    List<Member> findAll(); //저장된 모든 회원 리스트 반환
}
