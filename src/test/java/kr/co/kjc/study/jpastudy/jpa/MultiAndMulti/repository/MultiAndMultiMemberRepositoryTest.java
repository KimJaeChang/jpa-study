package kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.repository;

import kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.service.MultiAndMultiMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MultiAndMultiMemberRepositoryTest {

    @Autowired
    private MultiAndMultiMemberService multiAndMultiMemberService;


    @Test
    @DisplayName("양방향 연관관계 매핑")
    void createMemberAndTeam() {
        multiAndMultiMemberService.createMemberAndTeam();
    }
}