package oliviarla.spring_intro.controller;

import oliviarla.spring_intro.domain.Member;
import oliviarla.spring_intro.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        System.out.println("memberService = "+memberService.getClass()); //AOP사용 시 프록시 memberService가 생성됨을 확인
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; //홈 화면으로 이동
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
