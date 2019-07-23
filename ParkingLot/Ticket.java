
public class Ticket {
	 private final long startTime = System.currentTimeMillis();
	    private final Vehicle vehicle;

	    public Ticket(Vehicle vehicle) {
	        super();
	        this.vehicle = vehicle;
	    }
	    public long calcualteParkingDuration(){
	        return System.currentTimeMillis() - startTime;
	    }
	    public double calculateCost(CostCalculator calculator){
	        return calculator.getCost(calcualteParkingDuration(), vehicle.getCostFactor());
	    }

	    public Vehicle getVehicle(){
	        return vehicle;
	    }

}
