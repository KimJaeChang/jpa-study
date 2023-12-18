package kr.co.kjc.study.jpastudy.jpa.JoinStrategy.single_table.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn    // 생략해도 DTYPE 생성가능
public class SingleTableItem {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

}
