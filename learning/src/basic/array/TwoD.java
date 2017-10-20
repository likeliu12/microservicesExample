package basic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;

public class TwoD {

	void test() {
		int[][] array = new int[2][];
		int[][][]array3 = new int[2][][];
		
		array[0] = new int[5];
		array[1] = new int [6];
		
		array[0][0] = 0;
		array[0][1] = 10;
		
		array3[0] = array;
		array3[1] = array;
		
		long l = 5;
		testLong(l);
		System.out.println(l);
	}
	
	void testLong(double l) {
		l += 5;
	}
	void test2() {
		List<Integer>[] array = new List[10];
		array[0] = new ArrayList<Integer>();		
	}
	
	void test3() {
		List<Integer> l =Arrays.asList(new Integer[10]);
		List<Integer> l2 = Arrays.asList(new Integer(0), new Integer(1), new Integer(2));
		
		Integer[] array = l.toArray(new Integer[0]);
		int[] vals = new int[10];
		Arrays.setAll(vals, i -> i);
	}
	
	public static void main(String[] args) {
		TwoD d = new TwoD();
		d.test();
	}
}