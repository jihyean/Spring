package test;

public class Teemo implements Champion{
	private Item item;
	
	public Teemo() {
		System.out.println("Ƽ�� ��ȯ");
	}
	
	public Teemo(Item item) {
		System.out.println("Ƽ�� ��ȯ");
		this.item = item;
		System.out.println(item + " ���� �Ϸ�");
	}
	
	public void use() {
		item.use();
	}
	
	public void q() {
		System.out.println("�Ǹ��Ʈ !");
	}
	public void w() {
		System.out.println("�ż��� �̵� !");
	}
	public void e() {
		System.out.println("�͵� ��Ʈ !");
	}
	public void r() {
		System.out.println("������ ���� !");
	}
}
