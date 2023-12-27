package kr.co.kjc.study.jpastudy.jpql.service;

import kr.co.kjc.study.jpastudy.jpql.repository.JpqlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpalService {

    private final JpqlRepository jpqlRepository;

    public void createMember() {
        jpqlRepository.createMember();
    }

}
