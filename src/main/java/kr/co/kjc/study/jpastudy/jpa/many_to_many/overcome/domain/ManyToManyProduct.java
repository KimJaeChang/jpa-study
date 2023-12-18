package kr.co.kjc.study.jpastudy.jpa.many_to_many.overcome.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "manyToManyProduct")
    private List<ManyToManyMemberProduct> manyToManyMemberProducts = new ArrayList<>();
}
