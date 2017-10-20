package exception;

public class TryCF {

	private int testOne() throws Exception {
		
		try {
			int e = 5/0;
		}
		finally {
			System.out.println("in finally");
	
			}
		System.out.println("in never");
		try {
			int e = 5/0;
		}
		finally {
			System.out.println("in finally");
		}
		
		return 1;
	}
	
	public static void main(String [] args) {
		TryCF t = new TryCF();
		
		int ret = 0;
		
		try {
			ret = t.testOne();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		System.out.println("" + ret);
	}
}
