package kr.co.kjc.study.jpastudy.jpa.mapped_super_class.service;

import kr.co.kjc.study.jpastudy.jpa.mapped_super_class.repository.MappedSuperClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MappedSuperClassService {
    private final MappedSuperClassRepository mappedSuperClassRepository;

    public void craate() {
        mappedSuperClassRepository.create();
    }

}
