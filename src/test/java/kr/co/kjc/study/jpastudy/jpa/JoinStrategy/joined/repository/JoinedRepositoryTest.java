package kr.co.kjc.study.jpastudy.jpa.JoinStrategy.joined.repository;

import kr.co.kjc.study.jpastudy.jpa.JoinStrategy.joined.service.JoinedService;
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
    void JoinedCreated() {
        joinedService.createJoined();
    }

}