package kr.co.kjc.study.jpastudy.jpql.service;

import kr.co.kjc.study.jpastudy.jpql.repository.FetchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FetchService {

  private final FetchRepository fetchRepository;

  public void notFetchJoin() {
    fetchRepository.notFetchJoin();
  }

  public void fetchJoin() {
    fetchRepository.fetchJoin();
  }

}
