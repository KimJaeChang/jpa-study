package kr.co.kjc.study.jpastudy.jpa.MultiAndOne.repository;

import kr.co.kjc.study.jpastudy.jpa.MultiAndOne.service.MultiAndOneMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MultiAndOneMemberRepositoryTest {

    @Autowired
    private MultiAndOneMemberService multiAndOneMemberService;

    @Test
    @DisplayName("다대일 연관관계 매핑")
    @Rollback(value = false)
    void createMemberAndTeam() {
        multiAndOneMemberService.createMemberAndTeam();
    }

}