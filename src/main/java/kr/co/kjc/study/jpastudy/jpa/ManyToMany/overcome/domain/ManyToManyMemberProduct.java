package kr.co.kjc.study.jpastudy.jpa.ManyToMany.overcome.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ManyToManyMemberProduct {

    @Id
    @GeneratedValue
    private Long memberProductId;

    @ManyToOne
    @JoinColumn(name = "MANY_TO_MANY_MEMBER_ID")
    private ManyToManyMember manyToManyMember;

    @ManyToOne
    @JoinColumn(name = "MANY_TO_MANY_PRODUCT_ID")
    private ManyToManyProduct manyToManyProduct;

    private int count;
    private int price;
    private LocalDateTime orderDateTime;

}
