package generic.multiBound;

public class Driver {
	public static void main(String[] strs) {
		Glass<OrangeJuice> orangeJuiceGlass = new Glass<OrangeJuice>();
		
		//can't do it, since not implement Fluid
		//Glass<AppleJuice> appleJuiceGlass = new Class<AppleJuice>();
		
		System.out.println(orangeJuiceGlass.getTaste(new OrangeJuice()));
		
	}
}
