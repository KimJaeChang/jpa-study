package kr.co.kjc.study.jpastudy.jpa.join_strategy.joined.repository;

import kr.co.kjc.study.jpastudy.jpa.join_strategy.joined.service.JoinedService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JoinedRepositoryTest {

    @Autowired
    JoinedService joinedService;

    @Test
    @DisplayName("조인전략 샘플")
    void create() {
        joinedService.create();
    }

}