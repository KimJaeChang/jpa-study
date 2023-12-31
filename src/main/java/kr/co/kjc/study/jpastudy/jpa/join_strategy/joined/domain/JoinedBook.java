package kr.co.kjc.study.jpastudy.jpa.join_strategy.joined.domain;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("B")
public class JoinedBook extends JoinedItem {
    private String author;
    private String isbn;
}
