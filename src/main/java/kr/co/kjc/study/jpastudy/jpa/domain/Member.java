package kr.co.kjc.study.jpastudy.jpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {

    @Id
    private Long id;
    private String name;

}
