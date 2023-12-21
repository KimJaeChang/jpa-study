package kr.co.kjc.study.jpastudy.jpa.lazy_loding.service;

import kr.co.kjc.study.jpastudy.jpa.lazy_loding.repository.LazyLoadingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LazyLoadingService {

    private final LazyLoadingRepository lazyLoadingRepository;

    public void create() {
        lazyLoadingRepository.create();
    }

}
