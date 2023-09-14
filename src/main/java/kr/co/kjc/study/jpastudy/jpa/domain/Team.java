package kr.co.kjc.study.jpastudy.jpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Team {

    @Id
//    @GeneratedValue
    @Column(name = "TEAMID")
    private String id;

    @Column(name = "TEAMNAME")
    private String name;
}
