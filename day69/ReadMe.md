# 오후 1:01 2023-08-17

## [파일 업로드]
1. jar
2. <form>에 속성 추가하기
3. 커맨드 객체인 보드VO에 멤버변수 추가

☆ insertBoard.do 요청
	-> 커맨드 객체 만들음 new
	-> request 내장객체로부터 값 추출
	   -> new : 객체를 멤버변수로 사용하는 경우
		=> 해당 객체에 맞는 Resolver 객체가 필요함!
	-> setter 호출
	-> C가 맞는 메서드를 수행


bVO.setFileUpload(new MultipartFile(req.getxxx()));
new를 얘는 해야함
객체라서(원시타입이 아니기 떄문)

4. Resolver는 DS의 멤버변수 -> DS.xml
5. Controller에 로직을 추가
	스노우, 인스타
	파일명 중복을 우려하여 어플리케이션 전용 폴더를 별도로 생성
	생성된 별도의 폴더에 파일을 복사하여 저장
