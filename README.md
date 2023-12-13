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
    + ### 연관관계 매핑
      + 설명 :
        + ### 단방향 연관관계
          + ![img.png](images/ManyToOne.png)
            + 설명 :
              + 방향(Direaction) : 단방향, 양방향
              + 다중성(Multiplicitiy) : 다대일(N:1), 일대다(1:N), 일대일(1:1)
              + 연관관계의 주인(Owner) : 객체 양방향 연관관계는 관리가 필요
              + 애노테이션
                + Multi Entity 매핑 기준 (ManyToOneMember.class)
                  + @ManyToOne : 다대일 매핑 사용
                  + @JoinColumn : 매핑 할 컬럼 정의
        + ### 양방향 연관관계
          + ![img.png](images/ManyToMany.png)
            + 객체 연관관계 = 2개
                + 회원 -> 팀 연관관계 1개(단방향)
                + 팀 -> 회원 연관관계 1개(단방향)
            + 테이블 연관관계 = 1개
                + 회원 <-> 팀 연관관계 1개 (양방향)
            + 양방향 매핑 규칙
              + 객체의 두 관계중 하나를 연관관계의 주인으로 지정
                + <U>**외래키**</U>가 있는 곳이 주인
                + ![img.png](images/ManyToManyOwner.png)
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
          + kr.co.kjc.tudy.jpastudy.ManyToOne 패키지 참조
            + ![img.png](images/ManyToOneV2.png)
        + 일대다 [1:N] : @OneToMany     
          + kr.co.kjc.tudy.jpastudy.OneToMany 패키지 참조
            + ![img.png](OneAndMultiV2/img.png)
        + 일대일 [1:1] : @OneToOne     
        + 다대다 [N:N] : @ManyToMany - <U>**실무에선 쓰면 안된다!**</U>
 
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