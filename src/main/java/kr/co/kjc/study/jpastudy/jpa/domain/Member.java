package kr.co.kjc.study.jpastudy.jpa.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Member {

    @Id
//    @GeneratedValue
    @Column(name = "USERID")
    private String id;
    @Column(name = "USERNAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
}
