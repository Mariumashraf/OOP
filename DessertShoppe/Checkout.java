public class Checkout {
	private DessertItem[] myDessertItems;
	private int numberOfItems;
	private final int RECEIPT_WIDTH = 30;
	
	public Checkout() {
		myDessertItems = new DessertItem[100];
		numberOfItems = 0;
	}
	
	public int numberOfItems() {
		//return number of DessertItem's in the list.
		return numberOfItems;
	}
	
	public void enterItem(DessertItem item) {
		myDessertItems[numberOfItems] = item;
		numberOfItems++;
	}
	
	public void clear() {
		for(int i = 0; i < numberOfItems; i++)
			myDessertItems[i] = null;
		numberOfItems = 0;
	}
	
	public int totalCost() {
		int sum = 0;
		for(int i = 0; i < numberOfItems; i++) 
			sum += myDessertItems[i].getCost(); 
		return sum;
	}
	
	public int totalTax() {
		return (int)Math.round(this.totalCost() * DessertShoppe.TAX_RATE / 100.00);
	}
	
	public String toString() {
		String s = "";		// receipt
		
		
		s += "    " + DessertShoppe.STORE_NAME + "\n";
		
		for(int j = 0; j < numberOfItems; j++){
		
			String l = myDessertItems[j].getName();		// items of every line
			
			
			String p = DessertShoppe.cents2dollarsAndCents(myDessertItems[j].getCost());	// price of every item
			if (p.length() > DessertShoppe.COST_WIDTH)		// verify the price is within length
				p = p.substring(0, DessertShoppe.COST_WIDTH);
			
			if (myDessertItems[j] instanceof IceCream) {		// print if ice cream
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";
			}
			else if (myDessertItems[j] instanceof Sundae) {		// print if Sundae
				
				s += ((Sundae)myDessertItems[j]).getToppingname() + " Sundae with\n";
				
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";
			}
			else if (myDessertItems[j] instanceof Candy){		// print if Candy
				s += ((Candy) myDessertItems[j]).getWEIGHT() + " lbs @ " + 
						DessertShoppe.cents2dollarsAndCents(((Candy) myDessertItems[j]).getPriceperpound()) + " /lb.\n";
				
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";	
			}
			else {		// print if Cookie
				s += ((Cookie)myDessertItems[j]).getNUMBER() + " @ " + 
						DessertShoppe.cents2dollarsAndCents(((Cookie)myDessertItems[j]).getPriceperdozen()) + " /dz\n";
				
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";			
			}	
		}
		
		String line = "\nTax";		
		String tax = DessertShoppe.cents2dollarsAndCents(this.totalTax());	// print tax
		while(line.length() <= RECEIPT_WIDTH - tax.length())
			line += " ";
		s += line + tax;
		
		String totalCost = DessertShoppe.cents2dollarsAndCents(this.totalCost() + this.totalTax());	// print total cost
		line = "\nTotal Cost";
		while(line.length() <= RECEIPT_WIDTH - totalCost.length())
			line += " ";
		s += line + totalCost;
	
		return s;
	}
}