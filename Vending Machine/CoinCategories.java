package vending;

import java.util.ArrayList;

public class CoinCategories {
	private ArrayList<Coin> coinCategory = new ArrayList<>(7);
	
	public CoinCategories() {
		coinCategory.add(new Coin("Penny", 1));
		coinCategory.add(new Coin("Nickel", 5));
		coinCategory.add(new Coin("Dime", 10));
		coinCategory.add(new Coin("Quarter", 25));
		coinCategory.add(new Coin("Halfdollar", 50));
		coinCategory.add(new Coin("Dollar", 100));
		coinCategory.add(new Coin("Twodollar", 200));
	}

	public ArrayList<Coin> getCoinCategory() {
		return coinCategory;
	}


	
	
	

}
