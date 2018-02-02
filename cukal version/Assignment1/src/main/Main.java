package main;

import errorStreetException.StreetLengthException;

public class Main {
	
	public static void main(String[] args) throws StreetLengthException {
		Car car = new Car();
		 int lane = car.whereIs().getCarLane();
		
		 System.out.println(lane);
		 
	}

}
