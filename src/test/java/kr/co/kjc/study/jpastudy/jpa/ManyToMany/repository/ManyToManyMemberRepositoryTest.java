package kr.co.kjc.study.jpastudy.jpa.ManyToMany.repository;

import kr.co.kjc.study.jpastudy.jpa.ManyToMany.service.ManyToManyMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManyToManyMemberRepositoryTest {

    @Autowired
    private ManyToManyMemberService manyToManyMemberService;


    @Test
    @DisplayName("양방향 연관관계 매핑")
    void createMemberAndTeam() {
        manyToManyMemberService.createMemberAndTeam();
    }
}