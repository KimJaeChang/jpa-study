package kr.co.kjc.study.jpastudy.jpa.JoinStrategy.table_per_class.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TablePerClassItem {   // abstract 클래스로 table이 생성되지 않는다.

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

}
