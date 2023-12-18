package kr.co.kjc.study.jpastudy.jpa.mapped_super_class.repository;

import kr.co.kjc.study.jpastudy.jpa.mapped_super_class.service.MappedSuperClassService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MappedSuperClassRepositoryTest {

    @Autowired
    MappedSuperClassService mappedSuperClassService;

    @Test
    @DisplayName("MappedSuperClass 테스트")
    void create() {
        mappedSuperClassService.craate();
    }

}