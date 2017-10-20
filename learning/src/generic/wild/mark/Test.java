package generic.wild.mark;

public class Test {
	public static void main(String[] strs) {
		Tray t = new Tray();
		t.add(new Glass<Juice>());
		t.add(new Glass<Water>());
	}
}
