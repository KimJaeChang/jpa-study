package kr.co.kjc.study.jpastudy.jpa.mapped_super_class.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MappedSuperClassMember extends MappedSuperClassBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "mapped_super_class_member_id")
    private Long id;

    @Column(name = "mapped_super_class_member_username")
    private String username;
}
