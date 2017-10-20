package basic.ArrayCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayCollection {

	private void arraysUtil() {
		List<String> str = Arrays.asList("abc", "def");

		String[] array = { "abc", "def", "xyz" };
		List<String> s = Arrays.asList(array);

		System.out.println(s.get(0));
		int index = Arrays.binarySearch(array, "def",
				(o1, o2) -> o1.compareTo(o2));
		Arrays.sort(array);
	}
	
	private void checkedCollection() {
	      final Integer arbitraryInteger = new Integer(4);
	      final List rawList = new ArrayList();
	      rawList.add(arbitraryInteger);
	      rawList.add(new String("abc"));
	     
	      List<String> stringList = Collections.checkedList(new ArrayList(), String.class);
	      
	      try{
	    	  stringList.addAll(rawList);
	      }catch(ClassCastException e) {
	    	  System.out.println("catch an error " + e.getMessage());
	      }
	}

	private void unmodifiedCollection() {
		List<String> unmodifiedList = Collections.unmodifiableList(new ArrayList());		
		try{
			unmodifiedList.add("abc");
		} catch(UnsupportedOperationException e) {
			System.out.println("get unsupportedOperationException");
		}
	}
	private void collectionsUtil() {
		Collection c = new ArrayList();
		List<String> list = new ArrayList();

		int i = Collections.binarySearch(list, "Abc", (o1, o2) -> {
			return o1.compareTo(o2);
		});
		
		checkedCollection();
		unmodifiedCollection();
		
		Collections.sort(list, (o1, o2) -> {
			return o1.compareTo(o2);
		});
		
		
		
	}
	public static void main(String[] args) {
		
		ArrayCollection arrayCollection = new ArrayCollection();
		arrayCollection.arraysUtil();
		arrayCollection.collectionsUtil();
	}

}
