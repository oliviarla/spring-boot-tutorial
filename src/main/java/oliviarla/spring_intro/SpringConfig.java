package oliviarla.spring_intro;

import oliviarla.spring_intro.domain.Member;
import oliviarla.spring_intro.repository.*;
import oliviarla.spring_intro.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


//JPA사용할 때
//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }


//JDBC 사용할 때
//    private DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean //스프링 빈에 등록
    public MemberService memberService(){
        //스프링 데이터 JPA 사용 시
        return new MemberService(memberRepository);

        //그외 사용 시
        //return new MemberService(memberRepository()); //스프링 빈에 등록된 객체를 입력으로 넣어줌
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return new JpaMemberRepository(em);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        //return new MemoryMemberRepository();
//    }


}
