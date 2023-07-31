HTML
CSS
JSP

프로젝트
항공권
API 발표
중프 var茶

수업시간 정리
현재 day37까지 작성 완료

day38
day39
day41
day42
day43
day44
day47
day48
day49

1. 기존의 JSP
---> Spring 이관 작업

2. 파트 변경 가능

3. DB 이관 작업

4. 개션사항, 앞으로 추가사항 해야됨

자소서, 입사지원서, 포트폴리오
프로젝트 이해

오전 9:16 2023-07-31
window -> Preferences에 Spring 항목이 있어야 함
help
이클립스 Marketplace
스프링3 설치 후 addOn 설치


Create project
자바만 하면 자바
웹하면 dynamic
우린 spring legacy project
템플릿 설정
spring MVC project

An error has occurred. See error log for more details.
Could not initialize class com.thoughtworks.xstream.converters.collections.PropertiesConverter

다 만들고 파란색 S자 떠야함

1. Spring 플러그인 설치
2. 프로젝트 생성(MVC 템플릿 사용)
3. 우클릭 ->property> project Facets -> Java 런타임에 / 아파치 톰캣 내 버전에 맞게 넣어야 함
4. src/main/resources의 log4j.xml, META-INFO 제거
5. src/main/webapp(우리가 쓰던거)/WEB-INF의 spring과 views 제거
6. web.xml 하단 source 설정 전부 제거(루트 element만 남긴다)
7. pom.xml 들어가서 버전 맞춤 스프링은 4.2.4RELEASE로 변경 (강사님 자바 버전은 11)
8. 







# [Spring 프레임워크 개요]
1. SpringBoot
2. Spring 기반으로한 자체 프레임워크 <<<

프레임워크 == 골격 / 뼈대
-> 예시) 리모콘, 인형
   개발자들끼리 기준
   유지보수 용이
   
장점)
1. 유지보수 용이
2. 개발시간 단축(기준에 대해 얘기할 필요 없음)
3. 개발자의 역량 획일화 & 실력 상향 평준화
4. 재사용 용이

스프링 프레임워크
   : IoC와 AOP를 지원하는 경량의 프레임워크
	경량이 아닌 경우 ==  not POJO(servlet, 리스너, 필터)
	즉, not POJO를 최소화하여 작성

	우린 이미 JSP 팀 프로젝트에서 경량으로 작업함
	Servlet FrontController 한개만 생성하여 사용중
	API, 비동기처리 기능 등을 구현할때 Servlet을 추가로 사용
	위의 것들도 일반 POJO로


IoC
Inversion of Control
제어의 역행
제어권을 개발자가 갖는것이 아닌 프레임워크가 갖음
개발자가 new(객체화, 인스턴스화)를 제어하는 것이 아닌
프레임워크에게 제어권을 넘겨주는 것
★코드에 new가 작성되어 있으면 유지보수가 불리해짐
---> 결합도가 높아져서


★그럼 왜 new가 있으면 결합도가 높아지는가?
	=> 1. 결합도가 높은 코드
	=> 2. 해결01) -다형성 활용(인터페이스 Action)
	=> 3. 해결02) - Factory 패턴 활용
			SW 개발 디자인 패턴(MVC, Factory, singletone, ...)
			Factory 패턴이란?
			: 객체를 생성하는 코드를 캡슐화하여(HIDING, 은닉화)
				사용자로부터 필요한 객체의 이름을 받아
				객체 자체를 반환하는 로직
			==> 코드를 단 한글자도 변경하지 않아도 


Bean 들어감 ---> 로직이 들어감
---> spring 객체가 생성됨
객체 이름을 받아 객체 자체를 반환하기 때문에
인풋: 이름 아웃풋: 객체
최상위 객체 == Object 이다

캐스팅 직접해도 되고
아니면
Run configuration -> Arguments
여기에 갤럭시 써도 됨
arg[0] 이렇게
---> 코드를 안바꿨는데 아웃풋 변경 == 프로그램
팩토리 패턴의 장점









1. 개념 -> 실습 -> 개념정리

test 사용하지 않음

당분간의 main 자바만

src/main/java

main/webapp
레벨 맞춰서 jsp 작성

패키지 열어서 class 하나 만들음
갤럭시폰
아이폰

폰 끄기 켜기
음량 크게
음량 작게



web.xml은 원래 톰캣도 씀
porm.xml은 스프링에 대하여 설정하는 파일임

설정 파일 == .xml
1. web.xml
	톰캣 관련 설정 파일
2. pom.xml
	스프링 관현 설정 파일
	.jar 파일들에 대한 관리


applicationContext.xml
처음 민들었을때부터 있는 것 == root 태그
web.xml의 root 태그는 webapp
applicationContext.xml의 root 태그는 beans

객체를 생성해달라고 할 예정
new 대신 개발자 대신 해줘

xml에선 주석ㄴㄴ

<bean class ="test.GalaxyPhone" id="galaxy"/>
GalaxyPhone galaxy = new GalaxyPhone();
둘이 같다

<bean> 태그로 new를 개발자 대신 해줌

스프링이 동작할 수 있도록 해야함


//
Client.java
어떤 파일을 볼지 같이 보내줘야 함
스프링에서 객체를 생성해주는 애 == 컨테이너
얘를 스프링 컨테이너라고 많이 부름

★컨테이너
== 객체 생성하는 주체
== 개발자가 설정(.xml)만 해주면 new는 스스로 관리함
== 객체 생성 및 관리를 스스로 처리함

질문
1. doAction 메서드는 static이 아님
2. 객체가 있다는 소리
3. 그럼 new 어디서 함?
=> @WebServlet()
	유사 new
	web.xml이랑 약속이 되어있음
	톰캣이랑
	즉 , 톰캣 == 서블릿 컨테이너
		== 서블릿을 new 해주는 주체

1. 톰캣은 서버와 동시에 "서블릿 컨테이너"의 역할도 해줌
2. @WebServlet()이 있다면 new 해줌
3. new 뿐만 아니라 생성 시점, 호출 시점 등도 관리 가능

Q. doAction()이 되어있었네?
	객체가 있었다는건데
	누가 객체화를 해줬을까?
	=> 서블릿 컨테이너 톰캣

POJO 만들면 서블릿 컨테이너
스프링을 만들면 스프링 컨테이너

<bean> POJO -> 스프링 컨테이너
@Servlet -> 서블릿 컨테이너(톰캣)

그럼 저 객체가 언제 생성하는지 궁금
--> 기본 생성자 만들고 로그 찍기

xml에 bean 처리하면 S자에 불 들어옴
---> spring

둘다 생성된 후 작업이 진행됨
본인 객체가 생성되지 않더라도 생성됨
왜냐면 만들어달라고 했으니까 하던거 쓰니까

취업갔는데 bean에 뭐를 막 속성을 주렁주렁 다는데 뭐임?
그냥 구글링하셈
원체 처음보는거고 자기네들이 만든거라
구글링 안 나오는 경우가 있어서
알려주겠음
중요하다기보단 쓰는 회사가 있다


<bean class ="test.GalaxyPhone" id="galaxy" init-method="initMethod" destroy-method="destroyMethod" lazy-init="true" />

보통 일반적으로 멤버변수 초기화와 관련된 코드들이 포함되어 있음
칼바람 초기렙 + 돈 이걸로 초기화함

객체 소멸시 사용
보통 일반적으로 close()와 같은 연결해제 코드 작성

지연 로딩 방식(lazy-loading)
빈을 쓰면 디폴트로 pre-loading 방식을 사용함(즉시 로딩 방식)
설정을 하면 lazy-loading 방식을 할 수도 있음
---> 아이폰 안 만들어짐
---> 쓸 때 만드는 방식
세개 만들면 객체 하나만 생성됨
---> 하나만 객체 생성(기존에는 누른만큼 객체 생성)
★디폴트로 객체를 한개만 메모리에 생성하고 해당 객체 재사용
===> 싱글톤(singleton) 패턴

갤럭시의 스코프를 singletone으로 한것이 기본값으로 되어있음
"원래"

이것을 여러개 하고 싶다면 prototype
--> 객체를 여러개 생성

객체를 이름으로 찾는 행위 == LookUp(룩업)

★★★★★★★★★★★★★★★★★★★★★★★★★
1) 의존성(Dependency), 의존관계

갤럭시 폰은 갤럭시워치 객체 없이 메서드 수행 불가능
의존관계에 놓여짐

2) 의존 주입(DI, Dependency Injection), 의존성주입
갤럭시 워치를 갤럭시 폰이 주입받아야 함
	new 해줘야함
	= 초기화, 생성자 호출해줘야 함

1. 생성자(constructor) 주입(java때 사용)
2. setter 주입(jsp 사용)

★★★★★★★★★★★★★★★★★★★★★★★★★

객체가 아닌 것을 모두 value로 작업할 수 있음

