package kr.co.kjc.study.jpastudy.jpa.join_strategy.table_per_class.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TablePerClassAlbum extends TablePerClassItem {
    private String artist;

}
