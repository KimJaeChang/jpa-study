package kr.co.kjc.study.jpastudy.jpa.JoinStrategy.table_per_class.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TablePerClassBook extends TablePerClassItem {
    private String author;
    private String isbn;
}
