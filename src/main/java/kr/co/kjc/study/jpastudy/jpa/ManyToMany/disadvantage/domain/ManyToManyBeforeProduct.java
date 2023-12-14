package kr.co.kjc.study.jpastudy.jpa.ManyToMany.disadvantage.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ManyToManyBeforeProduct {

    @Id
    @GeneratedValue
    @Column(name = "MANY_TO_MANY_PRODUCT_ID")
    private Long id;

    @Column(name = "MANY_TO_MANY_PRODUCT_USERNAME")
    private String username;

    @ManyToMany(mappedBy = "manyToManyBeforeProducts")
    private List<ManyToManyBeforeMember> manyToManyBeforeMembers = new ArrayList<>();
}
