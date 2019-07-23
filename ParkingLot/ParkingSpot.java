public class ParkingSpot {
	// private data field
	private int row;
	private int numOfSp;
	private VehicleSize sizeOfSp;
	private Vehicle veh;

	// default constructor
	public ParkingSpot(){
		
	} // end of default constructor
	
	// overloading constructor
	public ParkingSpot( int ro, int no, VehicleSize vs){
		numOfSp = no;
		row = ro;
		sizeOfSp = vs;
	} // end of overloading constructor

	// getter
	public int getSptNum(){
		// return statement
		return numOfSp;
	} // end of getSpotNumber method
			
	// getter
	public int getRow(){
		// return statement
		return row;
	} // end of getRow method
	
	// getter
	public VehicleSize getSize(){
		// return statement
		return sizeOfSp;
	} // end of getSize method
	
	// check if there is available spot
	public boolean isAvail(){
		// return statement
		return (veh == null);
	} // end of isAvail method

	// check if vehicle fits or not
	public boolean fitVeh(Vehicle veh){
		// return true value if the vehicle fits
		// return statement
		return veh.canFitSpt(this) && isAvail();
	} // end of fitVeh method

	// park the vehicle in the parking lot
	public boolean park(Vehicle ve){
		if (!fitVeh(ve)){
			// return statement
			return false;
		}

		veh = ve;
		veh.parkSpts(this);
		
		// return statement
		return true;
	} // end of park method

	
	public void rvVehicle(){
		veh = null;
	} // end of rvVehicle method
	
	// print out each type of parking spot and vehicle that parks
	public String toString(){
		// creating instance
		StringBuilder sb = new StringBuilder();
		
		if(!isAvail()){
			if(veh.getSize() == VehicleSize.regular){
				sb.append('B');
			} else if (veh.getSize() == VehicleSize.compact){
				sb.append('C');
			} else {
				sb.append('M');
			}
		} else {
			if(sizeOfSp == VehicleSize.regular){
				sb.append('l');
			} else if (sizeOfSp == VehicleSize.compact){
				sb.append('c');
			} else {
				sb.append('m');
			}
		}
		
		// return statement
		return sb.toString();
	} // end of toString method
} // end of ParkingSpot class
