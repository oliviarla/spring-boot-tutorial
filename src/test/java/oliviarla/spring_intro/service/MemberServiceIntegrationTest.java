package oliviarla.spring_intro.service;

import oliviarla.spring_intro.domain.Member;
import oliviarla.spring_intro.repository.MemberRepository;
import oliviarla.spring_intro.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional //test시작 전 트랜잭션 시작, 테스트 완료 후 롤백 -> DB에 데이터 남지 않음
public class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void join() {
        //given, when, then 세 부분으로 나누어 검증
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();

        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //람다식을 실행하면 왼쪽 예외가 발생해야 함

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then


    }

}
