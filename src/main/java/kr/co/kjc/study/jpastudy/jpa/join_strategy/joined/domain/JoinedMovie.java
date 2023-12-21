package kr.co.kjc.study.jpastudy.jpa.join_strategy.joined.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JoinedMovie extends JoinedItem {
    private String director;
    private String actor;
}