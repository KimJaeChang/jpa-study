package kr.co.kjc.study.jpastudy.jpa.cascade.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class CasCadeParent {

    @Id
    @GeneratedValue
    @Column(name = "cas_cade_parent_id")
    private Long id;

    @Column(name = "cas_cade_parent_name")
    private String name;

    @OneToMany(mappedBy = "casCadeParent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CasCadeChild> childs = new ArrayList<>();

    public void addChild(CasCadeChild child) {
        childs.add(child);
        child.setCasCadeParent(this);
    }
}
