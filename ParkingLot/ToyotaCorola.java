
public class ToyotaCorola extends Vehicle{
	// constructor
	public ToyotaCorola(){
		NeededSpots = 5;
		size = VehicleSize.regular;
	} // end of constructor

	public boolean canFitSpt(ParkingSpot spt){
		// return true if it is a large spot
		return spt.getSize() == VehicleSize.regular;
	} // end of canFitSpt method

}
