package kr.co.kjc.study.jpastudy.jpa.JoinStrategy.joined.service;

import kr.co.kjc.study.jpastudy.jpa.JoinStrategy.joined.repository.JoinedRepository;
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
