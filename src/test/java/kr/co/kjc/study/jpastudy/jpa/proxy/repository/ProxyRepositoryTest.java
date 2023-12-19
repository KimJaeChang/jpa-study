package kr.co.kjc.study.jpastudy.jpa.proxy.repository;

import kr.co.kjc.study.jpastudy.jpa.proxy.service.ProxyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProxyRepositoryTest {

    @Autowired
    private ProxyService proxyService;

    @Test
    @DisplayName("프록시 엔티티 값 비교")
    void compareEntity() {
        proxyService.compareEntity();
    }

    @Test
    @DisplayName("프록시 참조 값 비교 - 참")
    void compareRefernceTrue() {
        proxyService.compareRefernceTrue();
    }

    @Test
    @DisplayName("프록시 참조 값 비교 - 거짓")
    void compareRefernceFalse() {
        proxyService.compareRefernceFalse();
    }

}