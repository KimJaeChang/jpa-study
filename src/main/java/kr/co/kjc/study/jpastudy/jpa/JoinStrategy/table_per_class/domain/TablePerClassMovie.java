package kr.co.kjc.study.jpastudy.jpa.JoinStrategy.table_per_class.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TablePerClassMovie extends TablePerClassItem {
    private String director;
    private String actor;
}
