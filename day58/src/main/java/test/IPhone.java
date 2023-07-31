package test;

public class IPhone implements Phone {

	public IPhone() {
		System.out.println("아이폰 생성자 호출됨");
	}
	
	public void destroyMethod() {
		System.out.println("객체 소멸할때에 호출될 메서드");
		// 보통 .close()와 같은 연결해제 코드가 작성되어있음
	}
	
	@Override
	public void powerOn() {
		System.out.println("아이폰 ON");
	}

	@Override
	public void powerOff() {
		System.out.println("아이폰 OFF");
	}

	@Override
	public void volumeUp() {
		System.out.println("아이폰 + 1");
	}

	@Override
	public void volumeDown() {
		System.out.println("아이폰 - 1");
	}
	
}
