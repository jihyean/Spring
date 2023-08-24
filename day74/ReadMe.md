## 오후 1:04 2023-08-24


# [다국어처리]
1) 이전에는 다른언어로 서비스를 해야했을때
	.jsp 파일 자체를 여러개 제작해야 했음

2) Spring 프로젝트에서는 "메세지 파일"만을 제작하여 활용가능!

message 패키지
messageFile_en.properties

바꿔야 되는거

제목 작성
내용 작성
글 작성

한국어로 작성하면 자동으로 유니코드 변환됨
주석은 #
key값과 value값으로 이루어짐
key = value

어떠한 요소에 어떤 값이 들어갈지 정확히 나타내기 위해
. 은 안들어가도 되지만 통상적으로 넣음
~의 ~~라고 하면 가독성이 좋아서

3)메세지 파일 작성하기
	메세지 키 = 메세지 값 형식
	a.b.c.d.e = value
4) 메세지 파일을 읽어들일 수 있는 Resolvr(==MessagSource)를 등록
DS에서

다국어처리 사용하는 xml을 보면 얘를 만날 수 있을텐데
흔하지 않치만 이런거 처음보면 ..어 뭐임? 이럴까봐
구조가 다 이럴거임 아마도

근데 얘는 확장자(en.properties) 없이 씀
en 이거 자동으로 붙여줌
그리고 .properties붙이면 패키지 경로와 헷갈릴까봐

>> 파일명만 넣는건지 확장자까지 넣는건지

컴퓨터 설정에서 확장자를 항상 같이 나오도록 설정하도록
message 파일이 유독 확장자 문제가 많음

5) MessageSource 클래스는 _en _ko를 자동으로 추가해줌

파일을 만들때마다(언어를 추가할때마다) 설정을 추가하지 않아도 됨
대신 자동으로 파악할 수 있게 하는 애를 자동으로 설정

	웹 브라우저 --- 요청 ---> 서버
		HTTP 요청 헤더에
		브라우저의 Locale 정보가 존재
	Locale 정보를 추출할 LocaleResolver가 필요함
		SessionLocaleResolver

6) LocaleChangeInterceptor 클래스 등록
	mvc 네임스페이스를 추가한 후에 등록
인위적으로 다른언어로 서비스할수 있도록 할거임 ---> 언어설정을 변경할 수 있도록

<property name="paramName" value="lang" /> 세터주입
lang이라는 파라미터로 언어설정 변경가능

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
해당 태그라이브러를 작성하면
불러올수있게 됨
<spring:message code='메세지 키'/> 해당 형식으로 사용하면 전체가 메세지 값으로 보여지는 형태


※ redirect를 사용하면 새로운 요청이기 때문에 local 정보가 사라짐



