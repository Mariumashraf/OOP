
public class Candy extends DessertItem  {
	
	//A Candy item has a weight and a price per pound which are used to determine its cost in Cent.
	
	private double WEIGHT;
	private int Priceperpound;
	private int Cost;
	
	
	public Candy(String name ,double weight,int priceperpound) {
		super(name);
		WEIGHT=weight;
		Priceperpound=priceperpound;
		
		}

	@Override
	public int getCost() {
		
		//output: Peanut Butter Fudge 8.98= (2.25*399)cent=answer/100 dollars
		
		Cost = (int)Math.round(WEIGHT * Priceperpound);
		return Cost;
	}
	

	public double getWEIGHT() {
		return WEIGHT;
	}


	public int getPriceperpound() {
		return Priceperpound;
	}


	


}
