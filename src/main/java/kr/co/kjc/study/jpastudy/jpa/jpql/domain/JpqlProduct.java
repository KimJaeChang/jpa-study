package kr.co.kjc.study.jpastudy.jpa.jpql.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class JpqlProduct {

    @Id
    @GeneratedValue
    @Column(name = "JPQL_PRODUCT_ID")
    private Long id;
    private String name;
    private int price;
    private int stockAmount;

    @OneToMany(mappedBy = "jpqlProduct")
    private List<JpqlOrders> jpqlOrders = new ArrayList<>();

}
