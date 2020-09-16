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
	
	public static void main(String [] args) throws Exception {
		TryCF t = new TryCF();
		
		int ret = 0;
		
		try {
			ret = t.testOne();
		} catch (Exception e) {
			e.printStackTrace();
			t.handleException("more infor", e);
		}
		System.out.println("" + ret);
	}

	private void handleException(String str, Exception e) throws Exception {
		throw new Exception("funny", new Exception(str, e));
	}
}
