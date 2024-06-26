package kr.co.kjc.study.jpastudy.jpa.join_strategy.single_table.repository;

import kr.co.kjc.study.jpastudy.jpa.join_strategy.single_table.service.SingleTableService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SingleTableRepositoryTest {

    @Autowired
    SingleTableService singleTableService;

    @Test
    @DisplayName("단일 테이블 전략")
    void create() {
        singleTableService.create();
    }

}