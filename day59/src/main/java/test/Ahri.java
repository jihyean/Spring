package test;

public class Ahri implements Champion {
	private Item item;
	
	public Ahri() {
		System.out.println("�Ƹ� ��ȯ");
	}
	
	public Ahri(Item item) {
		System.out.println("�Ƹ� ��ȯ");
		this.item = item;
		System.out.println(item + " ���� �Ϸ�");
	}
	
	public void use() {
		item.use();
	}
	
	public void q() {
		System.out.println("��Ȥ�� ���� !");
	}
	public void w() {
		System.out.println("����� !");
	}
	public void e() {
		System.out.println("��Ȥ !");
	}
	public void r() {
		System.out.println("ȥ�� ���� !");
	}
}
