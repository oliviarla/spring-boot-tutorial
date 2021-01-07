package oliviarla.spring_intro;

import oliviarla.spring_intro.domain.Member;
import oliviarla.spring_intro.repository.MemberRepository;
import oliviarla.spring_intro.repository.MemoryMemberRepository;
import oliviarla.spring_intro.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class SpringConfig {

    @Bean //스프링 빈에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository()); //스프링 빈에 등록된 객체를 입력으로 넣어줌
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }


}
