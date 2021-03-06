package basic.compareTwo;

import java.util.Comparator;

public class EmployeeDOJComparator implements Comparator<EmployeePojo> {

	@Override
	public int compare(EmployeePojo e1, EmployeePojo e2) {
		if (e1 == null || e2 == null) {
			throw new NullPointerException("compareTo: Argument passed is null");
		}
		return new Integer(e1.getDateOfJoining().compareTo(
				e2.getDateOfJoining()));
	}

}
