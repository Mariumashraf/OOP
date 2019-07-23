
public class IceCream extends DessertItem  {
	
	private int Cost;	


	public IceCream(String name, int cost) {
		super(name);
		Cost=cost;
		
	}

	@Override
	public int getCost() {
		//output:Vanilla Ice Cream 1.05 = cost /100 dollars
		
		return Cost;
	}

}
