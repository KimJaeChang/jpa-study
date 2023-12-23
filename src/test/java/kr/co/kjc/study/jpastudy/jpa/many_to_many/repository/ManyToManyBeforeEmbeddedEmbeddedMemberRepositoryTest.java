package kr.co.kjc.study.jpastudy.jpa.many_to_many.repository;

import kr.co.kjc.study.jpastudy.jpa.many_to_many.disadvantage.service.ManyToManyBeforeMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManyToManyBeforeEmbeddedEmbeddedMemberRepositoryTest {

    @Autowired
    private ManyToManyBeforeMemberService manyToManyMemberService;


    @Test
    @DisplayName("양방향 연관관계 매핑")
    void createMemberAndTeam() {
        manyToManyMemberService.createMemberAndTeam();
    }
}