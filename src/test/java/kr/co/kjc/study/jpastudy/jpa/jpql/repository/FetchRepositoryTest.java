package kr.co.kjc.study.jpastudy.jpa.jpql.repository;

import kr.co.kjc.study.jpastudy.jpa.jpql.service.FetchService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FetchRepositoryTest {

  @Autowired
  private FetchService fetchService;

  @Test
  @DisplayName("jpql not-fetch-join 테스트")
  void notFetchJoinTest() {
    fetchService.notFetchJoin();
  }

  @Test
  @DisplayName("jpql fetch-Join 테스트")
  void fetchJoinTest() {
    fetchService.fetchJoin();
  }

}