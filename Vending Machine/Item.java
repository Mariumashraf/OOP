package vending;

public class Item {
	private String name ;
	private int price ;
	private int itemCount ;
	public Item(String name,int price) {
		this.name=name;
		this.price=price;
		itemCount = 0;
		
		
	}
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
}