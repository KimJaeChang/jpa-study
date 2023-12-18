package kr.co.kjc.study.jpastudy.jpa.ManyToMany.repository;

import kr.co.kjc.study.jpastudy.jpa.ManyToMany.disadvantage.service.ManyToManyBeforeMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManyToManyBeforeMemberRepositoryTest {

    @Autowired
    private ManyToManyBeforeMemberService manyToManyMemberService;


    @Test
    @DisplayName("양방향 연관관계 매핑")
    void createMemberAndTeam() {
        manyToManyMemberService.createMemberAndTeam();
    }
}