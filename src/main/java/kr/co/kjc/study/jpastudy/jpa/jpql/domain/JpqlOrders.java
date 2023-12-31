package kr.co.kjc.study.jpastudy.jpa.jpql.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JpqlOrders {

    @Id
    @GeneratedValue
    @Column(name = "JPQL_ORDERS_ID")
    private Long id;
    private int orderAmount;

    @ManyToOne
    @JoinColumn(name = "JPQL_PRODUCT_ID")
    private JpqlProduct jpqlProduct;

    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "JPQL_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "JPQL_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "JPQL_ZIPCODE"))
    })
    @Embedded
    private JpqlAddress jpqlAddress;
}
