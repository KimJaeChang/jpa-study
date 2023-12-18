package kr.co.kjc.study.jpastudy.jpa.join_strategy.joined.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DIS_TYPE")
public class JoinedItem {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

}
