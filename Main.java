package AhmetBuyukyilmaz;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		Parent admin = new Parent("Ahmet","123");
		admin.readParent(admin);
		new GUI(admin);
	}
}
