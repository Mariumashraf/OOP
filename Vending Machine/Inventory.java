package vending;

import java.util.ArrayList;

public class Inventory{
	private ArrayList<Item> itemsList =new ArrayList<>(6);	
	
	public void displayTheInventory() {
		if(itemsList.size() == 0) {
			System.out.println("The inventory is Empty");
		}
		else {
			for(int i =0;i<itemsList.size();i++) {
				System.out.println("ItemName"+itemsList.get(i).getName()+" "+"Count"+itemsList.get(i).getItemCount());
			}			
	}
	}
	
	public void addItem(String itemName,int itemPrice) {
		
			itemsList.add(new Item(itemName, itemPrice));	
	}

	public ArrayList<Item> getItemsList() {
		return itemsList;
	}	
}
