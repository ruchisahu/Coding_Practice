import java.util.ArrayList;

public class ParkingLot {
	/*
	Design a parking lot using object-oriented principles.
	*/

	//what type of vehicles it can support
	//whether the parking lot has multiple levels
	//-> make assumptions
	//the parking lot has multiple levels, each level has multiple rows of spots
	//the parking lot can park motorcycles, cars, and buses
	//the parking lot chas motorcycle spots, compact spots, and large spots
	//a motorcycle could park in any spots
	//a car can park in either a single compact spot or a single large spot
	//a bus can park in five large spots that are consecutive and within the same row, it cannot park in small spots

	//abstract class for vehicle, car, bus and motorcycle inherit.
	//parkingspot to handle the different parking spot size
//https://github.com/apriljdai/CC150/tree/master/Object-Oriented%20Design
	

	//a wrapper class for class of Levels
	public class ParkingLot{
		private Level[] levels;
		private final int NUM_LEVELS = 5;

		public ParkingLot(){
			levels = new Level[NUM_LEVELS];
			for (int i = 0; i < NUM_LEVELS; i++){
				levels[i] = new Level(i, 30);
			}
		}

		public boolean parkVehicle(Vehicle vehicle){
			for (int i = 0; i < levels.length; i++){
				if (levels[i].parkVehicle(vehicle))
					return true;
			}
			return false;
		}
	}

	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
