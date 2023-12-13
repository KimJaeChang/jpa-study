package kr.co.kjc.study.jpastudy.OneToMany.domain;

import jakarta.persistence.*;
import kr.co.kjc.study.jpastudy.jpa.ManyToMany.domain.ManyToManyTeam;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OneToManyMember {

    @Id
    @GeneratedValue
    @Column(name = "ONE_TO_MANY_MEMBER_ID")
    private Long id;

    @Column(name = "ONE_TO_MANY_USERNAME")
    private String username;

}
