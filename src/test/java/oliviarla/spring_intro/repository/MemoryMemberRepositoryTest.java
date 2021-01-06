package oliviarla.spring_intro.repository;

import oliviarla.spring_intro.domain.Member;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    //파일 한번에 실행할 경우 테스트가 실행되는 순서가 랜덤
    // -> 한 테스트가 끝나면 데이터를 지워줘야 함 ->repository에 clearStore 함수 생성 후 사용

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get(); //optional파일이므로 get으로 데이터 꺼냄
        //System.out.println("result = "+(result==member));
        //Assertions.assertEquals(member, null);
        //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result); //static import해서 바로 assertThat사용 가능

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        //Member result = repository.findByName("spring2").get(); 할 경우 test result에서 에러 발생

        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
