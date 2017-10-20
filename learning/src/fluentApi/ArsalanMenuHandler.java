package fluentApi;

import java.util.ArrayList;
import java.util.List;

public class ArsalanMenuHandler implements IMenu {
	List<IItem> menuList = new ArrayList<IItem>();
	List<IItem> selectedList = new ArrayList<IItem>();

	public ArsalanMenuHandler() {
		IItem biriyani = new IItem() {
			public IItem name() {
				System.out.println("Mutton Biriyani");
				return this;
			}

			public Integer cost() {
				return 180;
			}
		};
		IItem muttonChap = new IItem() {
			public IItem name() {
				System.out.println("Mutton Chap");
				return this;
			}

			public Integer cost() {
				return 160;
			}
		};
		IItem firni = new IItem() {
			public IItem name() {
				System.out.println("Firni");
				return this;
			}

			public Integer cost() {
				return 100;
			}
		};
		menuList.add(biriyani);
		menuList.add(muttonChap);
		menuList.add(firni);
	}

	public IMenu order(int index) {
            IItem item = get(index);
            selectedList.add(item);
            System.out.println("Order given ::" );
            item.name();
            return this;
        }

	public IMenu eat() {
		System.out.println("eating ");
		for (IItem item : selectedList) {
			item.name();
		}
		return this;
	}

	public IMenu pay() {
		int cost = 0;
		for (IItem item : selectedList) {
			cost = cost + item.cost();
		}
		System.out.println("Paying Rupees" + cost);
		return this;
	}

	@Override
	public IItem get(int index) {
		if (index < 3) {
			return menuList.get(index);
		}
		return null;
	}

	public void showMenu() {
		System.out.println("MENU IN ARSALAN");
		for (IItem item : menuList) {
			item.name();
		}
	}
}
