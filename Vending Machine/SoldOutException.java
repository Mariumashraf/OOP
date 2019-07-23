package vending;

public class SoldOutException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SoldOutException () {
		System.out.println("This item is not available, Select another item");

		
	}

	
	

}