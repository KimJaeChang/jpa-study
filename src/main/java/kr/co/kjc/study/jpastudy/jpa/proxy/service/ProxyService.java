package kr.co.kjc.study.jpastudy.jpa.proxy.service;

import kr.co.kjc.study.jpastudy.jpa.proxy.repository.ProxyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProxyService {

    private final ProxyRepository proxyRepository;

    public void compareEntity() {
        proxyRepository.compareEntity();
    }

    public void compareRefernceTrue() {
        proxyRepository.compareRefernceTrue();
    }

    public void compareRefernceFalse() {
        proxyRepository.compareRefernceFalse();
    }

}
