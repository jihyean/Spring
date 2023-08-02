## 오전 11:02 2023-08-02

# [오라클 설치]
http://naver.me/5NAK1TKT
압축해제
.exe
	비밀번호 입력
	1234
	1234
[계정 생성]
cmd에서 sqlplus sys/oracle as sysdba 입장
> CREATE USER 계정명
IDENTIFIED BY 비밀번호(1234)
ACCOUNT UNLOCK;
> GRANT CONNECT, RESOURCE TO 계정명;
[이클립스와 연동]
드라이버가 필요함(ojdbc6.jar)

@Repository
 1) 아! Model 파트구나! -> 스프링 컨테이너가 메모리를 관리하기에 유리 -> 속도향상
 2) XxxDAO라고 DAO라고 이름이 안붙을수도있음
	-> @Repository 덕분에 DAO라고 생각할수있음
	-> 가독성 좋아짐


JDBCUtil

PK는 사용자한테 안 받아옴

(SELECT NVL(MAX(BID),0)+1)

BoardDAO
MemberDAO

둘다 static 아니기 때문에 메모리에 올려야 함
객체화

<bean>
@

DAO는 자주 안바뀌기 때문에 @ 사용

@Repository
@Component를 상속받음
아! 모델꺼구나 메모리 관리를 해주니까
--> 메모리 관리 유리, 속도 향상
추후 DAO에 DAO라고 이름이 안받을 수 도 있음
(기능이나 사람이름으로 명시될수도 있음)
=> 가독성 좋아짐

1) 메모리 관리
2) 가독성 향상

Impl
해당 구문이 이름에 붙어있으면
무언가의 개념을 구현해낸것

Service 레이어가 관념적으로 존재하는데 그것을 구현한 클래스
Service 레이어는 DAO를 사용
== C 파트
: DAO를 사용할 것이기 때문에
: 메서드 시그니처를 통일해야 좋음
메서드 시그니처를 강제하고 싶음
== 인터페이스


DAO 사용시
메서드 시그니처를 통일해야 좋음



//
서블릿에선
서블릿 클래스에 대한 설정
<servlet-name>클래스
<servlet-class>아이디

web.xml
톰캣에게 설정 사항을 보냄
톰캣은 서블릿 컨테이너

★ web.xml -> 톰캣(서블릿 컨테이너)에게 설정을 알려주는 파일
  <servlet>
    <servlet-name>FrontController</servlet-name>
    <servlet-class>com.spring.view.controller.FrontController</servlet-class>
  </servlet>
	=> new <bean> @Component
	== @WebServlet
  <servlet-mapping>
    <servlet-name>FrontController</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
	=> 해당 서블릿 객체가 언제동작할지에대한 설정
	== @WebServlet("*.do")



1) controller.jsp의 코드를 FrontController.java(DispatcherServlet.java)에 옮겨옴
	-> 유지보수 불리
2) 모듈화 XxxAction
	.execute(req,res)
	=> 인터페이스 Action
 ↓
	XxxController
	.handleRequest(req,res)
	반환값이 String == 어디로 갈지, 경로, path
3) 보기 불편함
	1. 싱글톤 패턴 깨짐
	2. new를 코드에 직접 작성 => 결합도 높아짐 => 유지보수 불리
4) 팩토리 패턴을 활용해보자! => HandlerMapping 클래스 등장!
	mappings를 생성자 주입으로 DI하여 사용
	요청이름에 대해, 컨트롤러 객체를 반환함
5) DS에서는 HM을 멤버변수로 활용함
	HM에 대한 DI를 init() 메서드로 처리함
/////

