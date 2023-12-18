package kr.co.kjc.study.jpastudy.jpa.join_strategy.table_per_class.repository;

import kr.co.kjc.study.jpastudy.jpa.join_strategy.table_per_class.service.TablePerClassService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TablePerClassRepositoryTest {

    @Autowired
    TablePerClassService tablePerClassService;

    @Test
    @DisplayName("구현 클래스 마다 테이블 전략")
    void create() {
        tablePerClassService.create();
    }

}