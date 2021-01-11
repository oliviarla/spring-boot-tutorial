package oliviarla.spring_intro.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Entity
public class  Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //identity: db가 알아서 생성
    private Long id; //시스템이 저장하는 임의의 값

    @Column
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
