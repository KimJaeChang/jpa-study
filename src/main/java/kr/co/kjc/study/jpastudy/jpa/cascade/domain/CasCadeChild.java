package kr.co.kjc.study.jpastudy.jpa.cascade.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class CasCadeChild {

    @Id
    @GeneratedValue
    @Column(name = "cas_cade_child_id")
    private Long id;

    @Column(name = "cas_cade_child_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "cas_cade_parent_id")
    private CasCadeParent casCadeParent;
}
