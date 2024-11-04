package kr.co.kjc.study.jpastudy.jpa.one_to_one.repository;

import kr.co.kjc.study.jpastudy.jpa.one_to_one.domain.OneToOneLocker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OneToOneLockerRepository extends JpaRepository<OneToOneLocker, Long> {

}
