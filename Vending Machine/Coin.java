package vending;

public class Coin {
	private String name;
	private int cents;
	private int coinCount;
	
	public Coin(String name,int cents) {
		this.name=name;
		this.cents=cents;
		coinCount=0;
	}

	public String getName() {
		return name;
	}


	public int getCents() {
		return cents;
	}

	public int getCoinCount() {
		return coinCount;
	}

	public void setCoinCount(int coinCount) {
		this.coinCount = coinCount;
	}}