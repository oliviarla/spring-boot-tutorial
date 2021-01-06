package oliviarla.spring_intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //view resolver가 templates의 (return값).html으로 이동
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name") String name, Model model){ //외부에서 param 입력받음
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; //string 반환 -> 데이터를 그대로 내보냄
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 반환 -> 기본적으로 json 반환
    }
    static class Hello{
        private String name;

        //getter and setter -> alt+insert 단축키 사용해서 생성 가능
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }




}