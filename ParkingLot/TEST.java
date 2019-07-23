import java.util.Scanner;

public class TEST {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// creating instance
		ParkingLot pLot = new ParkingLot();
		
		// variable declaration
		String inp = "";
		
		// scanner input
		Scanner input = new Scanner (System.in);
		
		// output
		// print out an empty parking lot
		System.out.println("The empty parking lot\n");
		System.out.println(pLot.toString());
		
		// input
		// ask user to type in the vehicle that he wants to park
		System.out.print("Please enter bus, car, or motorcycle a vehicle (enter 0 to exit): ");
		inp = input.next();
		
		// continue asking user for input until user enters zero
		while(!inp.equals("0")){
			if (inp.equals("Bus") || inp.equals("bus")){
				// creating instance
				ToyotaCorola b = new ToyotaCorola();
				
				if(pLot.parkVeh(b)){
					// vehicle parked
					// success message
					System.out.println("\nThe bus has been parked successfully.");
					// print out parking lot
					System.out.println(pLot.toString());
					
					// ask user to enter other input
					System.out.print("Please enter bus, car, or motorcycle to park a vehicle (enter 0 to exit): ");
					inp = input.next();
				} else {
					// failure message
					System.out.println("\nParking Failed: Bus spots are full");
				
					// ask user to re-enter their inputs
					System.out.print("Please enter car or motorcycle to park a vehicle (enter 0 to exit): ");
					inp = input.next();
				}
			} else if(inp.equals("Car") || inp.equals("car")){
				// creating instance
				ToyotaYaris c = new ToyotaYaris();
				
				if(pLot.parkVeh(c)){
					// vehicle parked
					// success message
					System.out.println("\nThe car has been parked successfully.");
					// print out parking lot
					System.out.println(pLot.toString());
					
					// ask user to enter other input
					System.out.print("Please enter bus, car, or motorcycle to park a vehicle (enter 0 to exit): ");
					inp = input.next();
				} else {
					// failure message
					System.out.println("\nParking Failed: large spots are full");
					
					// ask user to re-enter their inputs
					System.out.print("Please enter bus or motorcycle to park a vehicle (enter 0 to exit): ");
					inp = input.next();
				}
			} else {
				// failure message
				System.out.println("\nInvalid input.");
				
				// ask user to re-enter input
				System.out.print("\nPlease enter bus, car, or motorcycle to park a vehicle (enter 0 to exit): ");
				inp = input.next();
			}
			
			// terminating program
			if(inp.equals("0")){
				System.out.print("\nProgram terminated");
				break;
			}
		} // end of while loop		
	} // end of main method
} // end of Testing2 class
