package kr.co.kjc.study.jpastudy.jpa.jpql.repository;

import kr.co.kjc.study.jpastudy.jpa.jpql.service.JpalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpqlRepositoryTest {

    @Autowired
    JpalService jpalService;

    @Test
    @DisplayName("jpql 테스트")
    void jpqlTest() {
        jpalService.createMember();
    }

}