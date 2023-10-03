# Spring

[KDT]Spring 및 Ai기반 핀테크 프로젝트구축

##
2023.05.02 ~ 2023.11.06
<br>
[: 블로그]( https://dev-9rm.tistory.com/category/Spring )

### 기본 설정
window -> Preferences에 Spring 항목 확인
help -> 이클립스 Marketplace 스프링3 설치 후 addOn 설치

Create project -> spring legacy project
템플릿 설정 spring MVC project


프로젝트 생성 후 파란색 S자(Spring) 표시 확인

Spring 플러그인 설치
프로젝트 생성(MVC 템플릿 사용)
우클릭 ->property> project Facets -> Java 런타임에 / 아파치 톰캣 내 버전에 맞게 넣어야 함
src/main/resources의 log4j.xml, META-INFO 제거
src/main/webapp(기존 사용)/WEB-INF의 spring과 views 제거
web.xml 하단 source 설정 전부 제거(루트 element만 남긴다)
pom.xml 들어가서 버전 맞춤
스프링은 4.2.4RELEASE로 변경 (자바 버전: 11)
