package oliviarla.spring_intro.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Member {

    private Long id; //시스템이 저장하는 임의의 값
    private String name; //이름


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
