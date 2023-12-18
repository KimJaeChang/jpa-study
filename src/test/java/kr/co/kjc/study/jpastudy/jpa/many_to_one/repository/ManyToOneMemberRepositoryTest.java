package kr.co.kjc.study.jpastudy.jpa.many_to_one.repository;

import kr.co.kjc.study.jpastudy.jpa.many_to_one.service.ManyToOneMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class ManyToOneMemberRepositoryTest {

    @Autowired
    private ManyToOneMemberService manyToOneMemberService;

    @Test
    @DisplayName("다대일 연관관계 매핑")
    @Rollback(value = false)
    void createMemberAndTeam() {
        manyToOneMemberService.createMemberAndTeam();
    }

}