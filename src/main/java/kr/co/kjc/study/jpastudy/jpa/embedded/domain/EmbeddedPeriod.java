package kr.co.kjc.study.jpastudy.jpa.embedded.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
public class EmbeddedPeriod {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public boolean isWork() {
        return true;
    }
}
