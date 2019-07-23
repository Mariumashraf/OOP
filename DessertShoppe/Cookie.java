
public class Cookie extends DessertItem  {
	//A Cookie item has a number and a price per dozen which are used to determine its cost in cent
	
	private int NUMBER;
	private int Priceperdozen;		// in cents
	private int Cost;
	
	public Cookie (String name,int number,int priceperdozen) {
		super(name);
		NUMBER=number;
		Priceperdozen=priceperdozen;
		
		
	}

	
	@Override
	public int getCost() {
		//output:Oatmeal Raisin Cookies 1.33=4/12*399 cent=answer/100 dollars
		
		Cost = (int)Math.round(NUMBER / 12.0 * Priceperdozen);
		return Cost;
		
	}

	public int getNUMBER() {
		return NUMBER;
	}


	public int getPriceperdozen() {
		return Priceperdozen;
	}

	
	
	

}
