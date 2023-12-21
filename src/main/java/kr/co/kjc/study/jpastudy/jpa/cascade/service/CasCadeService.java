package kr.co.kjc.study.jpastudy.jpa.cascade.service;

import kr.co.kjc.study.jpastudy.jpa.cascade.repository.CasCadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CasCadeService {

    private final CasCadeRepository casCadeRepository;

    public void create() {
        casCadeRepository.create();
    }

}
