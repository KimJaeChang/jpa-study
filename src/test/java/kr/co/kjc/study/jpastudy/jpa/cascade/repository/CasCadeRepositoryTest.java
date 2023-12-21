package kr.co.kjc.study.jpastudy.jpa.cascade.repository;

import kr.co.kjc.study.jpastudy.jpa.cascade.service.CasCadeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CasCadeRepositoryTest {

    @Autowired
    CasCadeService casCadeService;

    @Test
    @DisplayName("영속성 전이 테스트")
    void casCadeTest() {

        casCadeService.create();;
    }

}