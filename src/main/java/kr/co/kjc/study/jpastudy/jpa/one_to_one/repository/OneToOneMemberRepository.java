package kr.co.kjc.study.jpastudy.jpa.one_to_one.repository;

import kr.co.kjc.study.jpastudy.jpa.one_to_one.domain.OneToOneMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OneToOneMemberRepository extends JpaRepository<OneToOneMember, Long> {

}
