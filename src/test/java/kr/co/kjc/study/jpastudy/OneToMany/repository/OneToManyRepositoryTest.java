package kr.co.kjc.study.jpastudy.OneToMany.repository;

import kr.co.kjc.study.jpastudy.jpa.OneToMany.service.OneToManyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneToManyRepositoryTest {

    @Autowired
    private OneToManyService oneToManyService;

    @Test
    @DisplayName("일대다 연관관계 매핑")
    void createMemberAndTeam() {
        oneToManyService.createMemberAndTeam();
    }

}