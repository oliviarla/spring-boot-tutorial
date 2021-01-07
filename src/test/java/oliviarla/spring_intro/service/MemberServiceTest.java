package oliviarla.spring_intro.service;

import oliviarla.spring_intro.domain.Member;
import oliviarla.spring_intro.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    //각 테스트를 실행하기 전 수행되는 함수

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

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

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //람다식을 실행하면 왼쪽 예외가 발생해야 함

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then


    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}