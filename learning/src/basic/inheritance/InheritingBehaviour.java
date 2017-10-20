package basic.inheritance;

interface Engine{
	default String model() {
		return "Default Engine Model";
	}
}
interface Vehicle{
	default String model() {
		return "Default Vehicle Model";
	}
}

class Car implements Engine, Vehicle {
	public String model() {
		return Engine.super.model() + Vehicle.super.model();
	}
}
public class InheritingBehaviour {

}
