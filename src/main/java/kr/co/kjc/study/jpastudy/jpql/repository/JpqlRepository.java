package kr.co.kjc.study.jpastudy.jpql.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import kr.co.kjc.study.jpastudy.jpa.join_strategy.joined.domain.JoinedBook;
import kr.co.kjc.study.jpastudy.jpa.join_strategy.joined.domain.JoinedItem;
import kr.co.kjc.study.jpastudy.jpql.domain.JpqlMember;
import kr.co.kjc.study.jpastudy.jpql.dto.JpqlMemberDto;
import kr.co.kjc.study.jpastudy.jpql.enums.JpqlMemberType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class JpqlRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createMember() {

        JpqlMember member = new JpqlMember();
        member.setUsername("member1");
        member.setAge(10);
        member.setMemberType(JpqlMemberType.ADMIN);

        em.persist(member);
        em.flush();
        em.clear();

        // 조회결과 - 리스트
        TypedQuery<JpqlMember> typedQueryMember = em.createQuery("select m from JpqlMember m where m.username = :username", JpqlMember.class);
        List<JpqlMember> typeQueryMemberResult = typedQueryMember
                .setParameter("username", member.getUsername())
                .getResultList();
        System.out.println("typeQueryMemberResult : " + typeQueryMemberResult);

        // 조회결과 - 단 1건
        Query queryJpqlMember = em.createQuery("select m from JpqlMember m where m.username = :username");
        Object queryJpqlMemberResult = queryJpqlMember
                .setParameter("username", member.getUsername())
                .getSingleResult();
        System.out.println("queryJpqlMemberResult : " + queryJpqlMemberResult);

//        Query objectJpqlMember = em.createQuery("select m from JpqlMember m where m.username = :username");
//        List<Object[]> objectJpqlMemberResult = objectJpqlMember
//                .setParameter("username", member.getUsername())
//                .getResultList();
//
//        System.out.println("\t");
//        System.out.println("objectJpqlMemberResult : " + objectJpqlMemberResult);
//        System.out.println("\t");
//        System.out.println("object username = " + objectJpqlMemberResult.get(0));
//        System.out.println("object age = " + objectJpqlMemberResult.get(1));
//        System.out.println("\t");

        // DTO로 조회결과 매핑
        List<JpqlMemberDto> resultList = em.createQuery("select new kr.co.kjc.study.jpastudy.jpql.dto.JpqlMemberDto(m.username, m.age) from JpqlMember m where m.username = :username", JpqlMemberDto.class)
                .setParameter("username", member.getUsername())
                .getResultList();

        System.out.println("\t");
        System.out.println("resultList : " + resultList);
        System.out.println("\t");

        // 타입 체크
        System.out.println("boolean : " + (typeQueryMemberResult.get(0) instanceof JpqlMember));

        // ENUM 타입 표현
        List<Object[]> memberTypeList = em.createQuery("select m.username, 'HELLO', true from JpqlMember m " +
                        "where m.memberType = :memberType")
                .setParameter("memberType", JpqlMemberType.ADMIN)
                .getResultList();

        for(Object[] objects : memberTypeList) {
            System.out.println("\t");
            System.out.println("memberTypeList[0] : " + objects[0]);
            System.out.println("memberTypeList[1] : " + objects[1]);
            System.out.println("memberTypeList[2] : " + objects[2]);
            System.out.println("\t");
        }

        // DTYPE 표현
        JoinedBook joinedBook = new JoinedBook();
        joinedBook.setName("jpql book");

        em.persist(joinedBook);
        em.flush();
        em.clear();

        // DTYPE 표현
        List<JoinedItem> joinedItems = em.createQuery("select i from JoinedItem i where type(i) = JoinedBook ", JoinedItem.class)
                .getResultList();

        for(JoinedItem item : joinedItems) {
            System.out.println("\t");
            System.out.println("item_id : " + item.getId());
            System.out.println("item_name : " + item.getName());
            System.out.println("\t");
        }

        String caseWhenQuery = "select " +
                        "case when m.age <= 10 then '학생요금' " +
                        "     when m.age <= 60 then '경로요금' " +
                        "     else '일반요금' end as A " +
                        ", case when m.age <= 10 then '학생요금' " +
                        "     when m.age <= 60 then '경로요금' " +
                        "     else '일반요금' end as B " +
                        "from JpqlMember m";
        List<Object[]> caseWhenResultList = em.createQuery(caseWhenQuery)
                .getResultList();

        for(Object[] objects : caseWhenResultList) {
            System.out.println("\t");
            System.out.println("caseWhenResultList[0] : " + objects[0]);
            System.out.println("caseWhenResultList[1] : " + objects[1]);
            System.out.println("\t");
        }


    }
}
