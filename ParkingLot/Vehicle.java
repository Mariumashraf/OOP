import java.util.ArrayList;

public abstract class Vehicle {

		// private data field
		protected static int NeededSpots;
		protected VehicleSize size;
		protected String licenNum;
	    private final float costFactor;

		// creating ArrayList
		protected static ArrayList<ParkingSpot> spotForParking = new ArrayList<ParkingSpot>();

		// getter
		public VehicleSize getSize(){
			// return statement
			return size;
		} // end of getSize method
		
		// getter
		public int getSptsNeeded(){
			// return statement
			return NeededSpots;
		} // end of getSptsNeeded method
	    public double getCostFactor() {
	        return costFactor;
	    }

		public void parkSpts(ParkingSpot s){
			spotForParking.add(s);
		} // end of parkSpot method

		public void clearSpots() { 
			
		}
		public abstract boolean canFitSpt(ParkingSpot spt);

	} // end of Vehicle class



