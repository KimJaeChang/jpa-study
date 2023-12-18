package kr.co.kjc.study.jpastudy.jpa.JoinStrategy.table_per_class.service;

import kr.co.kjc.study.jpastudy.jpa.JoinStrategy.table_per_class.repository.TablePerClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TablePerClassService {

    private final TablePerClassRepository tablePerClassRepository;

    public void create() {
        tablePerClassRepository.create();
    }

}
