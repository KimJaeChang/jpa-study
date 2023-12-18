package kr.co.kjc.study.jpastudy.jpa.JoinStrategy.single_table.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SingleTableBook extends SingleTableItem {
    private String author;
    private String isbn;
}
