package pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Structure implements Group{
	List <Group> groups = new ArrayList<>(); 
	@Override
	public void assemble() {
		for(Group g: groups) {
			g.assemble();
		}
	}
	public void add(Group g) {
		groups.add(g);
	}
	public void remove(Group g) {
		groups.remove(g);
	}
}
