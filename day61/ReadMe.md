## 오전 8:54 2023-08-03

서버가 동작한다
== 톰캣이 동작
== 서브릿 컨테이너 동작(web.xml 로딩)
== ~~ 컨테이너가 동작한다
== xxx.xml 을 읽는다
	: 설정 파일이 있어야 컨테이너가 구동됨

<servlet> == <bean> == new
@WebServlet	@Component

ViewResolver
String을 보고 어디로 어떻게 가야되는지 구분하는 역할
	: Controller류의 객체가 .handleRequest()의 수행결과로 String을 반환했을때
	'어떻게 갈지'와 '어디로 갈지'를 판단해서 처리해주는 주체

Resolver
=> 특정 역할 을 자동으로 처리해주는 애

ViewResolver
View 가는거 자동으로 하는 애

자신의 멤버변수를 setter로 받는다
경로를 받으면 어디로/어떻게 갈지 엎뒤에 붙여서 반환

멤버변수 초기화 == 의존관계에 DI

[흐름]
사용자가 ~~.do의 형태로 요청
mapping 된거보고 dispatcher 서블릿 도착
doAction에서 무슨 요청헀는지 추출
거기에 맞게 컨트롤러 추출 -> 팩토리 패턴의 핸들러 사용
컨트롤러(이전의 액션) String만 반환
String으로 하는 이유는 path만 있으면 되서
.do면 보내고 아니면 .jsp 붙여서 보냄

이렇게 굳이 작성하는 이유?
지금 제일 무거운애 == dispatcher
상대적으로 무거운 파일인 애의 코드가 변할일이 없음
	== 재컴파일 할 일 없음!

유지보수 좋아짐
기능 추가시 컨트롤러만 구현해서 넣으면 된다

이러한 부분을 잘 써야함
단순 구현만 하면 안됨
이런 걸 활용한 경험이 중요함
막 복붙하면 뒤짐
구조를 이해하고 잘 "생각"하고 코딩
유지보수를 잘 생각하여야 함

web.xml
기존에는 우리가 만든 'DS'를 넣었지만
우리는 스프링에서 제공하는 DS를 넣을것이다

# [ Spring MVC로 변경하기 ]
1. web.xml에서 내가 만든 클래스 -> spring에서 제공하는 클래스
	webApplicationContext (추상 클래스인 applicationContext 하위에 대표적 2개 중 하나)
		--> ~~context인 이유는 컨테이너를 구동할 것이기 때문
		---> 따라서 .xml 필요
	이름으로된 resource가 필요하다고 오류 ---> .xml(설정 파일)이 없다
	해당 리소스의 경로는
	해당 리소스가 없기 때문에 DS를 초기화하는데에 필요한 init()이 호출되지 않음
	---> ERROR!
	DispatcherServlet-servlet.xml
	해당 이름은 우리가 web.xml에 지정한것에 -servlet으로 이름 규칙이 지정되어 있기 때문이다
++ web.xml에 스프링이 제공하는 필터 클래스 추가
	인코딩

2. 스프링이 제공하는 클래스로 Controller 변경
	반환이 String -> ModelAndView로 변경

3. 사용자의 xxx.do 요청에 대해 수행할 Controller 클래스까지 구현이 완료된 상태
	HM이 요청에 대한 Controller 객체 반환을 수행하므로,
	HM 생성할 차례
	HM은 DS에서 DI 되는 클래스(객체)
	---> DS는 init()에서 초기화
	즉, DispatcherServlet-servlet.xml에서 초기화!!!!!!!!!!!!
		(그리고 HM은 POJO니까 web.xml은 안됨^^)
	HM은 생성자 주입이 아니라 setter 주입임^^ㅋㅋ;;ㅎㅎ..ㅈㅅ!!

※※※※※※※※※※※※※※※※※※※
web.xml은 서블릿 컨테이너를 등록하는 곳이기 때문에 필터 등록도 가능
web.xml은 톰캣 서버가 구동하면서 자동으로 읽기로 되어있고
DS.xml은 web.xml에 서블릿 생성될때야 읽기 시작함
web.xml가 먼저 시작


이건 뭐냐면
중요한건 아니고 실무에서 가끔함
bean을 어노테이션으로 바꾸기

Resolver로 끝나는애들은 반드시 id를 명시해줘야 함

viewResolver는 setter 주입

가끔 jsp인데도 WEB-INF 하위에 폴더 하나를 파서 넣는 경우가 있음
해당페이지를 열때 다녀와야 하는 페이지가 있음
---> 밖으로 뺌 (에러가 날 이유가 없음)

그러나 
결제/마이페이지/상세 등등은 자리를 안채워주면 에러남
이런 데이터가 오지 않았을때 에러가 발생할 수 있는 애들은
WEB-INF 하위에 두는 경우가 있음

※결론
DB 방문 해야하는 페이지
	: WEB-INF 하위에 둔다(하이딩/은닉)
		★에러방지(사용자의 직접 접근을 차단: URL 조작 차단)

※※※이렇게 은닉된 페이지는 오직 VR 통해서만 갈 수 있음!!!!※※※

@
1. @Repository	M, DAO
2. @Service	C, Service
3. C Controller	C, implement Controller를 대신함

1. 현재 @Controller를 쓰고 있어서
	메서드 강제성이 없음
	== 메서드 시그니처가 고정되어 있지 않음
2. 특정 요청에 대해 Controller 객체를 찾아가는 것
	메서드를 찾아가는 것
3. 1개의 클래스 파일에 딱 1개의 기능
	==응집도가 낮은 상황
=> 하나의 Controller 클래스에
	2개 이상의 메서드가 있어도 되나요?

★★★★★★★★★★★★★★★★★★★★★★★★★★★★
Command 객체
 :컨테이너는 객체를 생성 및 관리
	해당 객체가 언제, 어떤 메서드를 호출해야하는지
	ex) DS가 초기화될때, init()
	ex) DS가 .do 요청을 받았을때, doGET(), doPost()
 : 요청을 받았을때, new VO()는 당연히 하는거고(객체 생성)
	setter()를 부를 수는 없을까?
== new는 당연히 수행하고,
	request로부터 값을 추출해서 setter 처리까디 전부 완료해주는 객체
★★★★★★★★★★★★★★★★★★★★★★★★★★★★

객체를 내가 new 하는게 아니라 컨테이너가 new
	IoC(제어의 역행)


사용자가 직접할 수 있는 요청은 모두 GET이기 때문에
POST로만 받을  수 있도록 하면
악의적 요청을 막을 수 있다


