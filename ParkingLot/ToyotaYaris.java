
public class ToyotaYaris extends  Vehicle {
	public ToyotaYaris(){
		NeededSpots = 1;
		size = VehicleSize.compact;
	} // end of constructor

	public boolean canFitSpt(ParkingSpot spt){
		// return true if it is a large spot
		return spt.getSize() == VehicleSize.regular || spt.getSize() == VehicleSize.compact;
	} // end of canFitSpt method
	 
	

}
