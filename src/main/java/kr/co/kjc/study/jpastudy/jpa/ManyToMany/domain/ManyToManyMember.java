package kr.co.kjc.study.jpastudy.jpa.ManyToMany.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ManyToManyMember {

    @Id
    @GeneratedValue
    @Column(name = "MANY_TO_MANY_MEMBER_ID")
    private Long id;

    @Column(name = "MANY_TO_MANY_USERNAME")
    private String username;

}
