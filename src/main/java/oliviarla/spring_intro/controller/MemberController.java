package oliviarla.spring_intro.controller;

import oliviarla.spring_intro.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //스프링 컨테이너에서 스프링 빈으로 controller를 관리하도록 함
public class MemberController {
    //private final MemberService memberService = new MemberService();
    //다른 여러 controller들이 가져다 쓸 수 있으므로 이런 방식은 지양할 것
    private final MemberService memberService;


    //의존하고 있는 MemberService를 스프링 컨테이너에서 가져옴
    //컨테이너가 뜰 때 생성자를 호출
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
