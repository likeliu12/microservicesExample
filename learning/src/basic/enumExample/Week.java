package basic.enumExample;

public enum Week {
	SUNDAY(10),
	MONDAY(11),
	TUESDAY(12),
	WENDSDAY(13),
	THURDSDAY(14),
	FRIDAY(15),
	SATURDAY(16);
	
	int price;
	
	private Week(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public static void main(String[] strs) {
		Week[] wArray = Week.values();
		
		for(Week week:wArray) {
			System.out.println(week + ": " + week.valueOf(week.toString()));
		}
		
		System.out.println("*********");
		System.out.println(Week.SUNDAY);
		System.out.println(Week.SUNDAY.name());
		System.out.println(Week.SUNDAY.ordinal());

		System.out.println(Week.valueOf("SUNDAY") + "        " + Week.SUNDAY.getPrice());
		
		System.out.println(Week.SUNDAY + " price is " + increasePrice(Week.SUNDAY));
		
		compareEnum(SUNDAY);
	}

	private static void compareEnum(Week week) {
		//all working
		if(MONDAY == week) {}
		if(week.equals(MONDAY)) {}
		if(week.compareTo(MONDAY) == 0) {}
	}

	private static String increasePrice(Week week) {
		String ret;
		switch(week) {
		case SUNDAY:
			SUNDAY.setPrice(SUNDAY.getPrice() * 2);
			ret = "" + SUNDAY.getPrice();
			break;
		case MONDAY:
			ret = "" + (MONDAY.getPrice() + 20);
			break;
		default:
			ret = "" + week.getPrice();
			break;
		}
		
		return ret;
	}
}
