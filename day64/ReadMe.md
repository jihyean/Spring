오전 9:12 2023-08-08

풀스택 하려면
모든 레이어 이해가 있어야함
설마 OSI 7계층?

아닐수도

AOP
헐 뒤졌다 ㅋㅋ

[ 2-Layerd 아키텍처 스타일 ]
[표현 계층과 비즈니스(핵심) 계층의 통합]
[프레젠테이션 레이어와 비즈니스 레이어의 통합]
			비즈니스
			==핵심 로직(관심, concern)
			== CRUD

1) 브라우저(Client, 사용자)에서 서버로 요청
	== request
	(JSP 내장 객체말고 그냥 단어)

2) DispatcherServlet 서블릿을 생성
	의존 주입(DI) 필요
	> 스프링에서 기본 제공중인 DS 사용중이라서
	DispatcherServlet-servlet.xml을 참고하여 DI 해줌
	스프링 컨테이너 구동
	표현 계층(프레젠테이션 레이어)

3) 요청에 맞는 Controller 객체를 호출하여 사용
		C, DAO, VO, Model, ...
		Command 객체

왜 끼움?

※ 현재 유지보수 불리한 상태
※ 1) 서버에서는 DBMS 변경이 잦다
	즉, DAO 변경 또한 잦다
	"DAO"를 직접 이용하고 있기 때문에 결합도가 높아서 유지보수 불리
	(객체를 직접 사용하면 결합도 증가)
	다른 DAO로의 변경이 매우 불리한 상태

※ 2) AOP 적용이 불가한 상태
	xxxService 류에만 호출 가능함
	( AOP를 사용하면 로그, 보안, 권한 확인, ...등을 자동호출할 수 있음)
	( 위의 코드를 별도로 분리해서 관리할 수 있음 -> 응집도 ↑)
	( 유지보수가 유리 )
	매번 로그, 보안, 권한 확인 등을 직접 처리해야 하므로 응집도 낮음
	유지보수 불리



//*
의외로 DBMS를 많이 바꿈(비용절감)
근데 그럼 DAO의 SQL 바뀜
그럼 다 선언했던거
컨트롤러에 인자로 커맨드 박혀있는 거 다 바꿔야 함
=> 유지보수 불리
*//



※ 유지보수를 유리한 상태로 바꿔보자
※ 비즈니스 레이어르 추가해보자
※ DAO를 직접 이용하지 않고, Service
1) C의 메서드 인자로 존재하던 DAO 제거
2) DAO를 대신 사용해줄 Service를 멤버변수로 추가
	DAO의 메서드와 Service의 메서드는 동일
	( Service가 DAO를 대신 사용하는 것임 )
	( DAO를 안쓰는 것이 아님!!! ) 
	( "대신" 쓰는 것 )

3) 이젠 DAO가 자주 변경되더라도 Service 내부의 멤버변수만 변경하면 됨
	결합도가 낮아지므로 유지보수 유리

4) 멤버변수로 추가한 Service가 메서드 수행 주체로써 사용됨
	의존관계 발생
	DI 해야함
	@Autowired

5) BCE 발생
	BoardController를 못 만들음
	boardService 의존 주입 실패
	-> 메모리에서 찾을 수 없음
	-> 서순! 의존성 주입을 객체 생성보다 먼저 함

6) boardService 메모리에서 없다
	@Service가 동작 안됨
	scan이 안됨 ㅎㅎ
	DispatcherServlet-servlet.xml에서 component-scan을 하지 않았다

7) applicationContext.xml에서 미리 DAO, Service 류의 객체들을 생성하고
	web.xml로 DS 생성하고
	DS-servlet.xml로 C를 호출할 수 있게 할 예정!!!!!

8) .xml을 추가
	== 스프링(루트) 컨테이너 추가 -> web.xml보다 먼저 만들어지니까
	== 비즈니스(서비스) 레이어를 추가

9) 루트 컨테이너로써 "서버가 시작될때" applicationContext.xml을 구동시켰으면 좋겠다
	서버 시작을 감지(모니터링)
	서블릿을 상속받은 리스너 ---> new IoC => web.xml

10) 결론: 루트 컨테이너 (, 스프링 컨테이너, 비즈니스 레이어)가 객체들을 메모리에 new
	서블릿 컨테이너(web.xml)가 DS을 메모리에 new
	스프링 컨테이너(DS-servlet.xml, 프레젠테이션 레이어)가 C를 호출하여 요청처리함
	===>> 2-Layerd 아키텍처 스타일



이제 BoardDAO 바꿀려면!!!!

DAO의
@Reposity랑

BoardServiceImpl의
@Autowired만 변경하면 됨(의존주입)

//
C야 main.do 실행해줘

@Autowired
private BoardService boardService;
보드서비스 있어? 응 있어

객체 있어?
의존 관계 있네 
보드 DAO 있어? 응 있어
ㄱㄱ






























