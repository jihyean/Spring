## 오전 9:13 2023-08-07

DS/ ..
@으로 변경하는 작업
인터페이스에 의한 메서드 강제 사라짐
메서드 시그니처/ 메서드명/컨트롤러 통합 가능(응집도/결합도 증가)

핸들러 맵핑역할
@RequestMapping
Method 형식을 사용하여 GET/POST 에 따른 작동 여부 결정 가능
(에러처리 / 보안 / 등을 이유로)

Command 객체
new+자동 맵핑(Setter)

메서드 인자를 학술적으로 말하지만
실무에서는 주로 VO

============복습======
+++++++++++++++++++++++++++++++++++++++++++++++++

main()가 수행되려면
주체(객체)인 MainController 객체가 new 되어야 함!
↓
new를 해주려면,
POJO니까 스프링 컨테이너가 필요함
↓
컨테이너가 동작하려면
설정파일(xml)이 필요

@방식을 사용할때
내장된 VR는 디폴트로 포워딩방식을 사용함!
↓
리다이렉트 방식을 사용하고 싶다면
"redirect:"을 추가해야 함

+++++++++++++++++++++++++++++++++++++++++++++++++

# [테스트 계정으로 로그인]
  => Command 객체를 별도의 설정없이 바로 VIEW에서 사용해보기
 Command 객체는 별도의 설정없이 바로 VIEW에서 EL식으로 사용가능함!
 단, 클래스타입을 소문자로 시작해야함!


현재 VIEW가 VO를 알고있는 상황
보통은 VIEW가 VO를 모르기 때문에 @ModelAttribute("이름")으로 객체를 VIEW에 넘겨줌

일반적으로는 값을 VIEW에 넘겨야 한다면, MAV를 사용함!!!!!!


[MAV ---> Model]
보편적으로는!!

객체는 Model을 통해
return 경로는 String
결론적으로 ModelAndVIEW 사용 안함

C 객체 메서드 output이 Stirng이거나 MAV였음
C 객체 메서드 output을 가볍기 때문에 String으로 권장
MAV -> Model
 
가독성 문제로


# [검색 실습]
 VO에 tmp 멤버변수가 없을때,
멤버변수에 없는 애들도 받을 수 있는 @있음

String searchCondition=request.getParameter("searchConditon"); 하려면 request가 필요함
  ↓
request라는 NOT POJO라는 무거운 객체가 필요하니까
대신에 @ 사용
@RequestParam(value="searchCondition")String searchCondition
  ↓

디폴트 값 사용 가능 여부
@RequestParam(value="searchCondition",defaultValue="TITLE",required=false)String searchCondition,  @RequestParam(value="searchContent",defaultValue="",required=false)String searchContent


VO에 tmp 멤버변수를 생성하는것이 보편적임!


[@ModelAttribute("이름")]
VIEW에서 사용할 데이터를 세팅하려는 목적으로 활용하는 @

@Controller 파트에서 해당 @을 사용하면
	@RequestMapping보다 먼저 수행됨
---> 가장 먼저 실행된다는 특징

무슨 검색이 되어야하는지 VIEW가 몰라도 괜찮음
그냥 DB를 몰라도 됨
