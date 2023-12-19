+ ## JPA
    + ### 구동 방식
        1. Build 파일을 통해서 JPA 인터페이스를 구현할 구현체 클래스인 Persistence를 생성
        2. 생성한 Persistence로 META-INF/Persistence.xml라는 설정파일 정보를 읽은 후 EntityManagerFactory를 생성
        3. 생성한 EntityManagerFactory로 EntityManager를 생성해서 DB 접근
    + ### Entity
        + EntityManagerFactory
            + EntityManager를 만들기 위해 필요한 class
            + 만들 때 비용이 많이들어서 미리 Bean으로 등록해 놓은 후 공유
        + EntityManager
            + EntityManagerFactory를 통해서 요청이 올 때마다 생성
            + EntityManager를 통해서 DB에 접근 및 CRUD 실행
    + ### 영속성 컨텍스트
        + 뜻 : "Entity를 영구 저장하는 환경"
        + DB에 바로 저장하는게 아닌 EntityManager를 통해서 영속성 컨텍스트에 저장해놓는다.
        + 이점
            + 1차 캐시
            + 동일성 보장
            + 트랜잭션을 지원하는 쓰기 지연
            + 변경 감지(Dirty Checking)
            + 지연 로딩(Lazy Loading)
        + 생명주기
            + 비영속 (new/transient)
                + 영속성 컨텍스트와 전혀 관계가 없는 새로운 상태
                + 예) 새로운 Entity 기본 생성자 생성
            + 영속 (maaged)
                + 영속성 컨텍스트에 관리되는 상태
                + 예) entityManager.persist(entity)
            + 준영속 (detached)
                + 영속성 컨텍스트에 저장되었다가 분리된 상태
                + 예) entityManager.detach(entity)
            + 삭제 (removed)
                + 삭제된 상태
                + 예) entityManager.remove(entity)
    + ### 필드와 컬럼 매핑
        + @Id : 기본키(PK) 매핑
        + @Column : 컬럼 매핑
            + name : 컬럼명 직접 매핑 가능
        + @Enumerrated : EnumType 매핑
            + EnumType.ORDINAL : enum 순서를 DB에 저장, default
            + EnumType.STRING : enum 이름을 DB에 저장
        + @Temporal : sql의 DateType 매핑
            + LocalDate, LocalDateTime : Java8 부터 매핑 가능

      + ### 값 타입 컬렉션
          + 값 타입을 하나 이상 저장할 때 사용
          + @ElementCollection, @CollectionTable 필수
          + 필드가 1개일 시 @Column을 지정할 수 있다
          + 데이터베이스는 컬렉션을 같은 테이블에 저장할 수 없다.
          + DB는 컬렉션을 저장할 수 없기 때문에 별도의 테이블을 만들어 1:N 관계로 풀어서 컬렉션을 저장해야 한다.
          + 영속성 전이(Cascade) + 고아객체 제거 기능을 필수로 가진다.
          + DB 조회시 지연로딩을 조회된다 (LAZY)
          + set방식으로 수정 불가능 (값 타입은 immutable이다.)
          + ### 값 타입 컬렉션 제약사항
              + 값 타입은 엔티티와 다르게 식별자 개념이 없다.
              + 값은 변경하면 추적이 어렵다.
              + 값 타입 컬렉션에 변경 사항이 발생하면, 주인 엔티티와 연관된 모든 데이터를 삭제하고,
                값 타입 컬렉션에 있는 현재 값을 모두 다시 저장한다.
              + 값 타입 컬렉션을 매핑하는 테이블은 모든 컬럼을 묶어서 기본 키를 구성해야함
                (null 입력 X, 중복 저장 X)
          + ### 값 타입 컬렉션 대안
              + 실무에서는 상황에 따라 값 타입 컬렉션 대신에 1:N 관계를 고려
              + 1:N 관계를 위한 엔티티를 만들고, 여기에서 값 타입을 사용
              + 영속성 전이(Cascade) + 고아 객체 제거를 사용해서 값 타입 컬렉션 처럼 사용
              + 예제) AddressEntity
      + ### 엔티티 타입의 특징
          + 식별자 O
          + 생명 주기 관리
          + 공유
      + ### 값 타입의 특징
          + 식별자 X
          + 생명 주기를 엔티티에 의존
          + 공유하지 않는 것이 안전(복사해서 사용)
          + 불변 객체로 만드는 것이 안전
    
    + ### 연관관계 매핑
      + 설명 :
        + ### 단방향 연관관계
          + ![img.png](images/many_to_one/ManyToOne.png)
            + 설명 :
              + 방향(Direaction) : 단방향, 양방향
              + 다중성(Multiplicitiy) : 다대일(N:1), 일대다(1:N), 일대일(1:1)
              + 연관관계의 주인(Owner) : 객체 양방향 연관관계는 관리가 필요
              + 애노테이션
                + Multi Entity 매핑 기준 (ManyToOneMember.class)
                  + @ManyToOne : 다대일 매핑 사용
                  + @JoinColumn : 매핑 할 컬럼 정의
        + ### 양방향 연관관계
          + ![img.png](images/many_to_many/ManyToMany.png)
            + 객체 연관관계 = 2개
                + 회원 -> 팀 연관관계 1개(단방향)
                + 팀 -> 회원 연관관계 1개(단방향)
            + 테이블 연관관계 = 1개
                + 회원 <-> 팀 연관관계 1개 (양방향)
            + 양방향 매핑 규칙
              + 객체의 두 관계중 하나를 연관관계의 주인으로 지정
                + <U>**외래키**</U>가 있는 곳이 주인
                + ![img.png](images/many_to_many/ManyToManyOwner.png)
              + <U>**연관관계의 주인만이 외래 키를 관리(등록 수정)**</U>
              + <U>**주인이 아닌 쪽은 읽기만 가능**</U>
              + 주인은 mappedBy 속성 사용 X
              + 주인이 안니면 mappedBy 속성으로 주인 지정
              + 양방향 매핑시 연관관계의 주인에 값을 입략헤애 힌다.
                + <U>**mappedBy 속성으로된 필드에 값을 입력시 insert 쿼리 적용X**</U>
              + 무한루프를 조심하자
                + 예) toString(), lombok, JSON 생성 라이브러리, Controller에서 Entity 반환 금지
              + ManyToManyMember.changeManyToManyTeam() 처럼 양방향 연관관계 편의 메소드를 지정하면 편하다.
            + 설명 :
              + 객체 연관관계 : 2개
                + ManyToManyMember -> ManyToManyTeam 연관관계 1개
                + ManyToManyTeam -> ManyToManyMember 연관관계 1개
                + 애노테이션
                  + Many Entity 매핑 기준 (ManyToOneMember.class)
                    + @ManyToOne : 다대일 매핑 사용
                    + @JoinColumn : 매핑 할 컬럼 정의
                  + Many Entity 매핑 받는 기준 (ManyToManyTeam.class)
                    + @OneToMany(mappedBy = "manyToManyTeam") : 
                      + ManyToOneMember에 <U>**changeManyToManyTeam**</U> 변수로 선언된 값 mappedBy 매핑 필요
              + 테이블 연관관계 : 1개
                  + Member <-> Team 연관관계 1개
            + 정리 :
              + <U>**단방향 매핑만으로도 이미 연관관계 매핑은 완료**</U>
              + 양방향 매핑은 반대방향으로 조회(객체 그래프 탐색) 기능이 추가가된 것 뿐
              + JPQL에서 역방향으로 탐색할 일이 많음
              + 단방향 매핑을 잘 하고 양방향은 필요할 떄 추가해도 됨(테이블에 영향을 주지 않음)
      + 종류 :
        + 다대일 [N:1] : @ManyToOne     
          + 외래키가 있는곳에 참조를 걸면된다.
          + kr.co.kjc.study.jpastudy.ManyToOne 패키지 참조
            + ![img.png](images/many_to_one/ManyToOneV2.png)
        + 일대다 [1:N] : @OneToMany     
          + 일대다 단방향은 일대다(1:N)에서 <U>**일(1)이 연관관계의 주인**</U>
          + 테이블 일대다 관계는 항상 <U>**다(N)쪽에 외래 키가 있음**</U>
          + 객체와 테이블의 차이 때문에 반대편 테이블의 외래 키를 관리하는 특이한 구조
          + @JoinColumn을 꼭 사용해야 함. 그렇지 않으면 조인 테이블 방식을 사용함(중간에 테이블을 하나 추가함)
          + 단점 : 
            + 엔티티가 관리하는 외래 키가 다른 테이블에 있음
            + 연관관계 관리를 위해 추가로 UPDATE SQL 실행
            + 일대다 단방향 매핑보다는 <U>**다대일 양방향 매핑**</U>을 사용하자.
          + kr.co.kjc.study.jpastudy.OneToMany 패키지 참조
            + ![img.png](images/one_to_many/OneToMany.png)
        + 일대일 [1:1] : @OneToOne     
          + 일대일 관계는 그 반대도 일대일
          + 주 테이블이나 대상 테이블 중에 외래 키 선택 가능
            + 주 테이블에 외래 키
            + 대상 테이블에 외래 키
          + 외래 키에 데이터베이스 유니크(UNI) 제약조건 추가
          + 정리 : 
            + 주 테이블에 외래 키
              + 주 객체가 대상 객체의 잠조를 가지는 것 처럼 주 테이블에 외래 키를 두고 대상 테이블을 찾음
              + 객체지향 개발자 선호
              + JPA 매핑 편리
              + 장점 : 주 테이블만 조회해도 대상 테이블에 데이터가 있는지 확인 가능
              + 단점 : 값이 없으면 외래키에 null 허용
            + 대상 테이블에 외래 키
              + 대상 테이블에 외래 키가 존재
              + 전통적인 데이터베이스 개발자 선호
              + 장점 : 주 테이블과 대상 테이블을 일대일에서 일대다 관계로 변경할 때 테이블 유지
              + 단점 : 프록시 기능의 한계로 <U>**지연 로딩으로 설정해도 항상 즉시 로딩 됨**</U>
          + kr.co.kjc.study.jpastudy.OneToOne 패키지 참조
            + ![img.png](images/one_to_one/OneToOne.png)
        + 다대다 [N:N] : @ManyToMany - <U>**실무에선 쓰면 안된다!**</U>
          + @JoinTable로 연결 테이블 지정 
          + kr.co.kjc.study.jpastudy.ManyToMany 패키지 참조
            + ![img.png](images/many_to_many/ManyToManyV2.png)
          + 다대다 매핑의 한계
            + ![img.png](images/many_to_many/ManyToManyDisadvantage.png)
          + 다대다 매핑의 한계 극복 (ManyToManyMemberProduct.class)
            + ![img.png](images/many_to_many/ManyToManyOverCome.png)

    + ### 상속관계 매핑
      + 정의 : 
        + 관계형 데이터베이스는 상속 관계X
        + 슈퍼타입 서브타입 관계라는 모델링 기법이 객체 상속과 유사
        + 객체의 상속과 구조와 DB의 슈퍼타입 서브타입 관계를 매핑
      + 애노테이션
        + @Inheritance(strategy=InheritanceType.XXX)
          + JOINED : 조인전략
          + SINGLE_TABLE : 단일 테이블 전략
          + TABLE_PER_CLASS : 구현 클래스마다 테이블 전략
        + @DiscriminatorColumn 
          + 상속받은 엔티티 구분용
          + default : "DTYPE"
        + @DiscriminatorValue
          + 엔티티 구분 명 지정
          + default : 엔티티 명
      + 종류 :
        + 조인전략
          + 정의 : 부모 테이블에 <U>**ID(key)**</U>값을 정해놓고 <U>**DTYPE**</U> 으로 자식 테이블을 구분한다.
          + 장점 : 
            + 테이블 정규화
            + 외래 키 참조 무결성 제약조건 활용가능
            + 저장공간 효율화
          + 단점 : 
            + 조회시 조인을 많이 사용, 성능 저하
            + 조회 쿼리가 복잡함
            + 데이터 저장시 INSERT SQL 2번 호출
          + ![img.png](images/strategy/JoinStrategy.png)
        + 단일 테이블 전략
          + 정의 : 한 테이블에 필드를 선언하고 <U>**DTYPE**</U> 구분한다. (자식 엔티티의 필드를 부모 엔티티에 병합.)
          + 장점 : 
            + 조인이 필요없으므로 일반적으로 조회 성능이 빠름
            + 조회 쿼리가 단순함
          + 단점 : 
            + 자식 엔티티가 매핑한 컬럼은 모두 null 허용 (데이터 무결성 입장에선 애매하다.)
            + 단일 테이블에 모든 것을 저장하므로 테이블이 커질 수 있으므로  
              상황에 따라서 조회 성능이 오히려 느려질 수 있다.
          + ![img.png](images/strategy/SingleStrategy.png)
        + 구현 클래스 마다 테이블 전략
          + 정의 : 이 전략은 데이터베이스 설계자와 ORM 전문가 둘다 추천 X
          + 장점 : 
            + 서브 타입을 명확하게 구분해서 처리할 때 효과적
            + not null 제약조건 사용 가능
          + 단점 :
            + 여러 자식 테이블을 함께 조회할 때 성능이 느림 (UNION SELECT)
            + 자식 테이블을 통합해서 쿼리하기 어려움
          + ![img.png](images/strategy/TablePerClassStrategy.png)
    
    + ### @MappedSuperclass
      + 정의 : 
        + 공통 매핑 정보가 필요할 때 사용[ex) id, name]
        + 상속관계 매핑 X
        + 엔티티 X
        + 테이블과 매핑 X
        + 부모 클래스를 상속 받는 자식 클래스에 매핑 정보만 제공
        + 조회, 검색 불가 [<U>**em.find(MappedSuperClassBaseEntity.class)**</U> 불가]
        + 직접 생성해서 사용할 일이 없으므로 <U>**추상 클래스 권장**</U>
        + 테이블과 관계 없고, 단순히 엔티티가 공통으로 사용하는 매핑 정보를 모으는 역할
        + 주로 등록일, 수정일, 등록자, 수정자 같은 전체 엔티티에서 공통으로 적용하는 정보를 모을 때 사용
        + 참고 : 
          + @Entity 클래스는 엔티티나 @MappedSuperclass로 지정한 클래스만 상속 가능

    + ### 프록시
      + 기초 : 
        + em.find() : 데이터베이스를 통해서 실제 인티티 객체 조회
        + em.getReference() : 데이터베이스 조회를 미루는 가짜(프록시) 엔티티 객체 조회
        ![img.png](images/proxy/proxy_first.png)
      + 특징 : 
        + 실제 클래스를 상속받아서 만들어짐
        + 실제 클래스와 겉 모양이 같아 사용하는 입장에서는 진짜 객체인지 프록시 객체인지 구분하지 않고 사용하면 됨(이론상)
        + 프록시 객체는 실제 객채의 참조(target)를 보관
        + 프록시 객체를 호출하면 프록시 객체는 실제 객체의 메소드 호출
        + 프록시 객체는 처음 사용할 때 한 번만 초기화
        + 프록시 객체를 초기화 할 때, <U>**프록시 객체가 실제 엔티티로 바뀌는 것이 아니라, 초기화되면 프록시 객체를 통해서 실제 엔티티에 접근 가능**</U>
        + 프록시 객체는 원본 엔티티를 상속 받음, 따라서 타입 체크시 주의해야함 (<U>**== 비교대신 instance of 사용**</U>)
        + <U>**영속성 컨텍스트에 찾는 엔티티가 이미 있으면 em.getReference()를 호출해도 실제 엔티티 반환**</U>
        + 영속성 컨텍스트의 도움을 받을 수 없는 준영속 상태일 때, 프록시를 초기화 문제 발생  
          (하이버네이트는 org.hibernate.LazyInitiallizationException 예외를 터트림)
        ![img.png](images/proxy/proxy_info.png)
      + 초기화 : 
        ![img.png](images/proxy/proxy_reset.png)
      + 프록시 확인
        + 프록시 인스턴스의 초기화 여부 확인
          + PersistenceUnitUtil.isLoaded(Object entity);
        + 프록시 클래스 확인 방법
          + entity.getClass().getName() 출력
        + 프록시 강제 초기화 (Hibernate)
          + org.hibernate.Hibernate.initialize(entity);
          + <span style="color:red"><U>**참고 : JPA 강제 초기화 없음**</U></span>
            + 강제 호출 : <U>**entity.getXXX()**</U>