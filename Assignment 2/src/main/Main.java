package main;

import errorStreetException.StreetLengthException;

public class Main {
	
	public static void main(String[] args) throws StreetLengthException {
		Car car = new Car();
		car.setActuator(true); //turn the car on
		int lane = car.whereIs().getCarLane();
		System.out.println(lane);
		car.setActuator(false);
		car.moveForward();
		lane = car.whereIs().getCarLane();

		System.out.println(lane);
		 
	}

}
