package kr.co.kjc.study.jpastudy.jpa.ManyToMany.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ManyToManyProduct {

    @Id
    @GeneratedValue
    @Column(name = "MANY_TO_MANY_PRODUCT_ID")
    private Long id;

    @Column(name = "MANY_TO_MANY_PRODUCT_USERNAME")
    private String username;

}
