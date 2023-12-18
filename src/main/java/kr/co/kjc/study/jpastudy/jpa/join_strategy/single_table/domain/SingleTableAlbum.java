package kr.co.kjc.study.jpastudy.jpa.join_strategy.single_table.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SingleTableAlbum extends SingleTableItem {
    private String artist;

}
