

//implemented by having just a variable which represents the size of the spot
	public class ParkingSpot{
		

public enum VehicleSize{
		Motorcycle, Compact, Large,
	}
		private Vehicle vehicle;
		private VehicleSize spotSize;
		private int row;
		private int spotNumber;
		private Level level;

		public ParkingSpot(Level lvl, int r, int n, VehicleSize s){
			level = lvl;
			row = r;
			spotNumber = n;
			spotSize = s;
		}

		public boolean isAvailable(){
			return vehicle == null;
		}

		public boolean canFitVehicle(Vehicle vehicle){
			//check if the spot is big enough and is available
			return isAvailable() && vehicle.canFitInSpot(this);
		}

		public boolean park(Vehicle v){
			if (!canFitVehicle(v))
				return false;

			vehicle = v;
			vehicle.parkInSpot(this);
			return true;
		}

		public int getRow(){
			return row;
		}
		public int getSpotNumber(){
			return spotNumber;
		}
		public VehicleSize getSize(){
			return spotSize;
		}

		public void removeVehicle(){
			level.spotFreed();
			vehicle = null;
		}
	}
		public class Bus extends Vehicle{
			public Bus(){
				spotsNeeded = 5;
				size = VehicleSize.Large;
			}

			public boolean canFitInSpot(ParkingSpot spot){
				//checks if the spot is a Large, does NOT check num of spots
				return spot.getSize() == VehicleSize.Large;
			}
		}

		public class Car extends Vehicle{
			public Car(){
				spotsNeeded = 1;
				size = VehicleSize.Compact;
			}

			public boolean canFitInSpot(parkingSpot spot){
				//checks if the spot is a compact or a large
				return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
			}

			@Override
			public boolean canFitInSpot(ParkingSpot spot) {
				// TODO Auto-generated method stub
				return false;
			}
		}

		public class Motorcycle extends Vehicle{
			public Motorcycle(){
				spotsNeeded = 1;
				size = VehicleSize.Motorcycle;
			}

			public boolean canFitInSpot(parkingSpot spot){
				//checks if the spot is a compact, motorcycle or a large
				return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact || spot.getSize() == VehicleSize.Motorcycle;
			}
		}
	}