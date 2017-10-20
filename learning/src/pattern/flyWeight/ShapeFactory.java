package pattern.flyWeight;

import java.util.HashMap;

public class ShapeFactory {
	private static final HashMap<String, Shape> circleMap = new HashMap<>();

	public static Shape getCircle(String color) {
		Circle circle = (Circle) circleMap.get(color);

		if (circle == null) {
			circle = new Circle(color);
			circleMap.put(color, circle);
			System.out.printf("%s Creating circle of color : %s\n", circleMap.size(), color);
		}
		return circle;
	}
}
