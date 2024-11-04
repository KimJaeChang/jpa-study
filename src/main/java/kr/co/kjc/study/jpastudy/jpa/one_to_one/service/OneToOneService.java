package kr.co.kjc.study.jpastudy.jpa.one_to_one.service;

import kr.co.kjc.study.jpastudy.jpa.one_to_one.domain.OneToOneLocker;
import kr.co.kjc.study.jpastudy.jpa.one_to_one.domain.OneToOneMember;
import kr.co.kjc.study.jpastudy.jpa.one_to_one.domain.OneToOneMemberLog;
import kr.co.kjc.study.jpastudy.jpa.one_to_one.repository.OneToOneLockerRepository;
import kr.co.kjc.study.jpastudy.jpa.one_to_one.repository.OneToOneMemberLogRepository;
import kr.co.kjc.study.jpastudy.jpa.one_to_one.repository.OneToOneMemberRepository;
import kr.co.kjc.study.jpastudy.jpa.one_to_one.repository.OneToOneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OneToOneService {

  private final OneToOneRepository oneToOneRepository;
  private final OneToOneMemberRepository oneToOneMemberRepository;
  private final OneToOneMemberLogRepository oneToOneMemberLogRepository;
  private final OneToOneLockerRepository oneToOneLockerRepository;

  public void create() {
    oneToOneRepository.create();
  }

  @Transactional
  public void createV2() {

    OneToOneLocker oneToOneLocker = new OneToOneLocker();
    oneToOneLocker.setName("카드V2");
    OneToOneLocker saveLocker = oneToOneLockerRepository.save(oneToOneLocker);

    OneToOneMember oneToOneMember = new OneToOneMember();
    oneToOneMember.setUsername("회원V2");
    oneToOneMember.setOneToOneLocker(saveLocker);
    OneToOneMember saveMember = oneToOneMemberRepository.save(oneToOneMember);

    OneToOneMemberLog oneToOneMemberLog = new OneToOneMemberLog();
    oneToOneMemberLog.setOneToOneMember(saveMember);
    oneToOneMemberLog.setUsername(oneToOneMember.getUsername());

    OneToOneMemberLog saveMemberLog = oneToOneMemberLogRepository.save(oneToOneMemberLog);

  }
}
