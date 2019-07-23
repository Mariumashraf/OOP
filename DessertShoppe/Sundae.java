
public class Sundae extends IceCream {
	
	private String Toppingname;
	private int Toppingprice;		// in cents
	private int Cost;
	
	//The cost of a Sundae is the cost of the IceCream plus the cost of the topping.
	
	public Sundae(String icecreamname, int icecreamcost, String toppingname, int toppingprice) {
		super(icecreamname, icecreamcost);
		Toppingname=toppingname;
		Toppingprice=toppingprice;
		
		
	}

	@Override
	public int getCost() {
		
		//output:Choc. Chip Ice Cream 1.95=50/100+cost of icecream= 1.95 dollar
		Cost = Toppingprice + super.getCost();
		return Cost;
		
	}

	public String getToppingname() {
		return Toppingname;
	}
	
	public static void main(String[] args) {
		DessertItem d = new Sundae("Vanilla Ice Cream",105, "Caramel", 50);
		
		System.out.println(d.getClass().toString().substring(6));
		
		System.out.println(((Sundae)d).getToppingname());
	}


	

}
