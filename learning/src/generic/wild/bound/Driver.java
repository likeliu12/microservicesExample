package generic.wild.bound;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	public void create() {
		List<? extends A> la = null;
		la = new ArrayList<A>();
		la = new ArrayList<B>();
		la = new ArrayList<C>();

		List<? super B> lb;
		lb = new ArrayList<A>(); 
		lb = new ArrayList<B>(); 
		lb = new ArrayList<Object>();
	}
	
	//list context could B or C
	//get above or itself. can't add any except null
	public void upMethod(List<? extends B> lb) {
		
		//get super
	    B b = lb.get(0); // is fine, if real C
	    A a = lb.get(0);
	    Object o = lb.get(0);
	    
	    //C c = lb.get(0); //if B, could not cast to C
	    lb.size();
	   
	    //lb.add(new B()); //if C
	    //lb.add(new C()); //if B, 
	    lb.add(null);
	}

	//list contains could A or B or Object
	//only get Object, add bellow or itself
	public void lowMethod(List<? super B> lb) {
	    //B b = lb.get(0); // will not compile as we do not know whether the list is of type B, it may be a List<A> and only contain instances of A
		//A a = lb.get(0);
		Object o = lb.get(0);
		
		//add extended
	    lb.add(new B()); // if A,  real B could cast to A
	    lb.add(new C()); // if B, real C could cast to B
	    //lb.add(new A()); 
	    
	    lb.size();
	}
	
	//any object
	public void wildMethod(List<?> lb) {
		lb.size();
		//lb.add(new Object());
		Object o = lb.get(0);
		
		//B b = lb.get(0);
		//lb.addAll(new B());
	}
	
	public static void main(String[] strs) {
		Driver d = new Driver();
		
		List<Object> listObject = new ArrayList<>();
		List<A> listA = new ArrayList<>();
		List<B> listB = new ArrayList<>();
		List<C> listC = new ArrayList<>();
		
		d.upMethod(listB);
		d.upMethod(listC);
		
		d.lowMethod(listB);
		d.lowMethod(listA);
		d.lowMethod(listObject);
		
		d.wildMethod(new ArrayList<Object>());
		
	}
}
