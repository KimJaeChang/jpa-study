package kr.co.kjc.study.jpastudy.jpa.join_strategy.single_table.service;

import kr.co.kjc.study.jpastudy.jpa.join_strategy.single_table.repository.SingleTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SingleTableService {

    private final SingleTableRepository singleTableRepository;

    public void create() {
        singleTableRepository.create();
    }

}
