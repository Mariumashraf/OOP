package vending;

import java.util.ArrayList;

public class Bill  {
	
	ArrayList <Item> itemsList ;
	int[] itemsSold;
	int totalCost;
	
	public Bill(ArrayList<Item> itemsList,int[] itemsSold) {
		this.itemsList=itemsList;
		this.itemsSold=itemsSold;
	}
	
	
	public int calculatePrice() {
		int totalCost=0;
		if(itemsList==null) {
			return 0;
		}
		else {
			for(int i = 0; i<itemsList.size();i++) {
				totalCost+= itemsList.get(i).getPrice()*itemsSold[i];
				
			}
			return totalCost;
			
		}	
	}
	public void printBill() {
		System.out.println("BILL");

		for(int i = 0; i<itemsList.size();i++) {
			System.out.println("ItemType*Count = "+ " "+itemsList.get(i).getName()+"*"+itemsSold[i]);
			System.out.println("COST="+ itemsList.get(i).getPrice()*itemsSold[i]);
		}
		System.out.println("TOTAL COST = "+ this.calculatePrice());
		
	}
}
