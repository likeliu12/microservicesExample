package pattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees {

	private List<String> empList;

	public Employees() {
		empList = new ArrayList<String>();
	}

	public Employees(List<String> list) {
		this.empList = list;
	}

	public void loadData() {
		// read all employees from database and put into the list
		empList.add("Pankaj");
		empList.add("Raj");
		empList.add("David");
		empList.add("Lisa");
	}

	public List<String> getEmpList() {
		return empList;
	}

	public Employees(Employees employees) {
		List<String> temp = new ArrayList<String>();
		for (String s : employees.getEmpList()) {
			temp.add(s);
		}
		this.empList = employees.empList;
	}
}
