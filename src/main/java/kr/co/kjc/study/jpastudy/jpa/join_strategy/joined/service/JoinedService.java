package kr.co.kjc.study.jpastudy.jpa.join_strategy.joined.service;

import kr.co.kjc.study.jpastudy.jpa.join_strategy.joined.repository.JoinedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinedService {

    private final JoinedRepository joinedRepository;

    public void create() {
        joinedRepository.create();
    }

}
