package vending;

import java.util.Scanner;

public class VendingMachine extends Inventory {
	private CoinCategories usedCoins;
	private CoinCategories enteredCoins;
	private int[] itemsSold;
	public static Scanner input = new Scanner(System.in);
	public VendingMachine() {
		addItem("CANDY",10);
		addItem("COKE",25);
		addItem("PEPSI",35);
		addItem("SODA",45);
		addItem("SNACK",50);
		addItem("NUTS",90);
		
		usedCoins = new CoinCategories();
		for(int i=0; i < usedCoins.getCoinCategory().size();i++)
			usedCoins.getCoinCategory().get(i).setCoinCount(30);

		
		for(int i=0; i < this.getItemsList().size();i++)
			this.getItemsList().get(i).setItemCount(50);
		
		enteredCoins = new CoinCategories();
		itemsSold = new int[this.getItemsList().size()];
	}	
	public void makeOrder() {
		System.out.println("DO YOU WANT TO SEE THE INVENTORY?  "+" "+"if YES select 1"+" "+"if NO select 0");
		int displyNum = input.nextInt();
		if(displyNum == 1)
			displayTheInventory();
		else if(displyNum == 0)
		{
			System.out.println("Order Cancelled");
			return;
		}
		System.out.println("ENTER DESIRED NUMBER OF EACH ITEM");
		for(int i=0;i < this.getItemsList().size();i++)
		{
			System.out.println( this.getItemsList().get(i).getName()+ " : ");
			int countItem = input.nextInt();
			int prevCount = this.getItemsList().get(i).getItemCount();
			if((prevCount - countItem) >= 0)
			{
				itemsSold[i] = countItem;
				this.getItemsList().get(i).setItemCount(prevCount - countItem);;
			}
			else
			{
				System.out.println("ORDER CANCELLED");
				try {
				throw new SoldOutException();
				}
				catch(SoldOutException e)
				{
				returnItems();
				}
				return;
			}
		}
		
		this.enterCoins();
		
	}
	
	private void Refund()
	{
		System.out.println("Here is your money");
		for(int i =0; i< enteredCoins.getCoinCategory().size();i++)
		{
			int num = enteredCoins.getCoinCategory().get(i).getCoinCount();
			int prevCoinCount;
			if(num != 0)
			{
				System.out.println(enteredCoins.getCoinCategory().get(i).getName()+" "+num);
				prevCoinCount = usedCoins.getCoinCategory().get(i).getCoinCount();
				usedCoins.getCoinCategory().get(i).setCoinCount(prevCoinCount - num);
				num = 0;
			}
		}
	}
	private void returnItems()
	{
		if(itemsSold == null)
			return;
		else
		{
			for(int i=0; i< itemsSold.length;i++)
			{
				int prevCount = this.getItemsList().get(i).getItemCount();
				this.getItemsList().get(i).setItemCount(prevCount + itemsSold[i]);
			}
		}
	}
	private void returnremain(int returnedMoney)
	{
		System.out.println(" THE REMAINING ");
		int expectedCount;
		int [] iforderCancelled = new int [usedCoins.getCoinCategory().size()];
		int prevCount;
		
		for(int i= usedCoins.getCoinCategory().size()-1;i>(-1);i--)
		{
			if(returnedMoney == 0)
				return;
			
			expectedCount = returnedMoney / usedCoins.getCoinCategory().get(i).getCents();
			prevCount = usedCoins.getCoinCategory().get(i).getCoinCount();
			if(expectedCount <= prevCount)
				usedCoins.getCoinCategory().get(i).setCoinCount(prevCount - expectedCount);
			else
			{
				usedCoins.getCoinCategory().get(i).setCoinCount(0);
				expectedCount = prevCount;
			}
			
			iforderCancelled[i] = expectedCount;
			returnedMoney -= (expectedCount * usedCoins.getCoinCategory().get(i).getCents());
			System.out.println(usedCoins.getCoinCategory().get(i).getName()+" "+expectedCount);
		}
		
		if(returnedMoney != 0)
		{
			try {
				throw new NoChangeAvailableException();
			}
			catch(NoChangeAvailableException e) {
				int prevCoin;
				for(int i =0;i< usedCoins.getCoinCategory().size();i++)
				{
					prevCoin = usedCoins.getCoinCategory().get(i).getCoinCount();
					usedCoins.getCoinCategory().get(i).setCoinCount(prevCoin + iforderCancelled[i]);
				}
				Refund();
				returnItems();
			}
		}
	}
	private void enterCoins()
	{
		
		Bill bill = new Bill(this.getItemsList(),itemsSold);
		bill.printBill();
		int totalPrice = bill.calculatePrice();
		
		System.out.println();
		System.out.println("Enter amount of money for every coin ");
		int receviedCoins = 0;
		int prevCoinCount;
	
		for(int i =0;i<usedCoins.getCoinCategory().size();i++) {
			System.out.println(usedCoins.getCoinCategory().get(i).getName());
			int num = input.nextInt();
			enteredCoins.getCoinCategory().get(i).setCoinCount(num);
			prevCoinCount=enteredCoins.getCoinCategory().get(i).getCoinCount();
			usedCoins.getCoinCategory().get(i).setCoinCount(prevCoinCount+num);
			receviedCoins+=(num*usedCoins.getCoinCategory().get(i).getCents());	
			
		}
		if(receviedCoins < totalPrice) {
			try {
				throw new NotSufficientPaidException();}
				catch(NotSufficientPaidException e)
				{
					returnItems();
					Refund();
					return;
				}	
		}
		returnremain(receviedCoins - totalPrice);	
	}
	
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.makeOrder();
		System.out.println("DO YOU WANT TO MAKE ANOTHER ORDER?  "+" "+"if YES select 1"+"  "+"if NO select 0");
		int displyNum = input.nextInt();
		if(displyNum == 1)
			vendingMachine.makeOrder();
		else if(displyNum == 0)
		{
			System.out.println("Order Cancelled");
			return;
		}	
	}
}
