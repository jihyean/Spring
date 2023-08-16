# 오전 9:11 2023-08-16

## [ Spring JDBC ]

"코드 복사"했는데 더 줄일 수 없나?
모듈화 캡슐화 고민

1) 기존 JDBC 코드 작업중
	JDBC 로직이 반복되네?(유사하네?)
	더 줄일 수 없을까?
	=> 유사 / 반복되는 알고리즘을 캡슐화하여 재사용하는 패턴
		Template 패턴
		코딩 순서가 정해져 있는 정형화된 기술에서 큭히 유용하게 활용
		JDBC, 트랜잭션, Mybatis. JPA, ...
		DB가 하는일이 주로 정형화된 순서로 진행되기 때문에
		
		※ 패턴
		: MVC, 팩토리(결합도가 낮아짐), 싱글톤(메모리 성능 향상-> 동일한 객체를 하나만 사용) 


2) "JDBC Template"클래스를 적용하여 DAO 구성하기

3) pom.xml에 jar. x2 추가하기
	DBCP
	: DB 커넥션 풀 == 커넥션(connection)들을 대신 관리해주는 주체(객체)
4) DB연결은 
	conn을 DB로부터 확보하는 것에서부터 시작
5) JDBCTemplate 클래스는 ★DataSource 객체★를 통해 conn 확보 및 관리함
6) DataSource 객체를 생성할것
	스프링 컨테이너가 생성할것!!!!
	<bean> 등록 필요
7) DataSource 객체 bean 등록시 setter 주입

8) DAO의 클래스의 멤버변수로 JdbcTemplate를 등록
      -> DI(의존주입)

9) DI할 객체가 없음...
   등록해야함 : applicationContext.xml(루트 컨테이너)
   dataSource 객체를 setter 주입함

10) DAO2를 사용해보자!
   -> Service가 사용함
   Service의 멤버변수 변경
   @Repository로 Service에 의존주입할 객체 생성
