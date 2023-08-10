## 오전 8:47 2023-08-10

IoC -> new를 대신 해줌
	핵심 : 의존주입

# [ AOP ]
AOP는 응집도를 높일 수 있는 구조
Aspect Oriented Programming
관점 지향 프로그래밍

기존 --> OOP 객체지향 프로그래밍 언어

1) 면접용이라 개념중요
2) 자체 프레임워크에서 AOP 개념이 있는데 그거 파악!!

지금 로그인 로직은 OOP로 되어있음
1) 로그 찍음(객체가 있는지 궁금하니까)
2) 하려고 하는 메서드의 보안은 괜찮은지 인증받았는지 / API이면 허가가 나왔는지
	---> 권한확인 관계(인가 확인)
3) 확인되면 그제서야 "비즈니스 메서드" 실행
4) 관제 로그 찍을 수 있음
	: 관제란???
	디지털 포렌식이 가능한 이유
	컴퓨터가 뭐하면 다 기록에 남기기로 함
	그걸 관제식이라고 하는데
	이걸 관제 로그라고 함

!!!정리!!!
기존의 Controller 메서드를 예시로 설명

Controller 메서드
1) (개발자용) 로그
2) 권한 확인 : 보안, 인증, 허가
3) 비즈니스 메서드(CRUD, 핵심 로직, 핵심 관심)
4) 트랜잭션, 보안 관제 로그, ....

비즈니스 메서드가 달라졌는데(사용자의 요청이 달라졌는데)
결론적으로 "진짜" 변경되는곳은 3번밖에 없음!!! (1,2,4는 계속 사용)

"관심 분리(Separation of Concerns)"
	관심 == 로직
	1,2,4	공통 로직, 횡단 관심(어딜가도 실행 /가로지르는 로직)
	3	핵심 관심, 핵심 로직, 비즈니스 메서드
	
우린 보안 등은 안해서 실습은 로그로 할거임

[ 실습 ]
1) porm.xml 의존성 추가(2개)
aspectjrt
aspectjweaver

2) applicationContext.xml namespace -> AOP 추가
xmlns:aop="http://www.springframework.org/schema/aop"
applicationContext.xml에 추가하는 이유
	Controller의 로직과 소통할 확률이 높기 때문에
	불러내는 시점이 사용자 요청 직후

AOP 설정 완료되는 시점이
사용자 *.do를 하는 시점보다 더 먼저여야 하기때문


# [ AOP 용어 정리 ]
1) Advice 어드바이스
	횡단 관심
	공통 로직
	동작 시점을 설정할 수 있음
		비즈니스 메서드 기준으로 전/후/함께/.....

컨트롤러에서 조합하기 싫어함
조합을 서비스레이어에서 할거임

2) PointCut 포인트컷
	핵심 관심, 핵심 로직, 비즈니스 메서드. CRUD
	공통 로직인 Advice가 결합될 대상
execution(OUTPUT FUNCTION(INPUT))
<aop:pointcut expression="execution(* com.spring.biz..*Impl.*(..))" id=""/>
.. 은 갯수도 무관하다는 뜻

3) Aspect 애스팩트(Advisor 어드바이저)
	포인트컷 + 어드바이스
	포인트컷과 어드바이스의 "결합" 그 자체를 의미
	애스팩트 설정에 따라 위빙이 처리됨

4) Weaving 위빙
	포인트컷으로 작성한 핵심 관심 메서드가 호출될때
	어디바이스에 해당되는 횡단 관심 메서드가 삽입되는 과정 그 자체를 의미
	스프링은 런타임 위빙 방식을 사용함

5) JointPoint 조인 포인트
	포인트컷 후보
	포인트컷이 될 수 있는 대상들
	핵심 관심들.......

   <bean id="logAdvice" class="com.spring.biz.common.LogAdvice" />
 -> new를 컨테이너가 대신 수행
   <aop:config>
 -> 찐 AOP 설정
      <aop:pointcut expression="execution(* com.spring.biz..*Impl.*(..))" id="aPointcut" />
       -> 핵심 로직(CRUD)
      
      <aop:aspect ref="logAdvice">
       -> logAdvice랑 "결합"시켜줘!
         <aop:before method="printLog" pointcut-ref="aPointcut" />
          -> 언제? aPointcut 수행"전에" printLog 메서드 호출해줘!
      </aop:aspect>
   </aop:config>



XML을 안보면 AOP가 있는지도 모름
장점: 정말 해당 핵심 로직만이 보임
단점: 설정 확인하려면 XML을 열어 확인해야 함

서비스를 사용하지 않는 메서드는 로그가 안찍힘
(단순 페이지 이동과 같은 건)
더 가볍게 페이지 이동 가능

AOP 이전에는 단순 페이지 요청조차도 로그 찍혔었음
메서드 호출 == 느림

현재
서비스를 호출하는 건에 대해서만 로그 찍힘
메서드 안 호출 == 빠름



/////
포인트컷을 여러개 등록할 수 있음
여러개 등록하는 경우가 흔함
	CUD는 DB에 변화를 줌
	데이터에 대한 확실한 검증이 필요
	상대적으로 보안, 우효성 검사, 트랜잭션, ... 등이 많이 필요함
	↕
	R은 DB에 변화가 없음
	보려는 데이터에 접근할 수 있는 권한이 있는지만 확인하면 됨
	상대적으로 공통 로직이 적게 필요

일부 포인트컷에만 어드바이스(횡단관심, 공통로직)가 동작할 수 있는 설정 가능

after      비즈니스 메서드 후에 어드바이스가 호출됨
after-returning   비즈니스 메서드 OUTPUT반환후에 어드바이스가 호출됨
after-throwing   비즈니스 메서드 오류발생후에 어드바이스가 호출됨
around      비즈니스 메서드를 수행하기 전,후에 호출됨
      비즈니스 메서드 수행하기 전에 1번
      비즈니스 메서드 수행하기 후에 1번
      총 2번 xxxxxxxxxx
      around가 진행되는 동안에 비즈니스 메서드가 내부에서 호출되는 것임 OOOOO
before      비즈니스 메서드 전에 어드바이스가 호출됨



하나의 트랙잭션으로 처리할때
ex. 재고 / 결제 등등
그런거...
자동화하는 방법 있음 ---> 그때가서 하기

