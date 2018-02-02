package main;

import errorStreetException.StreetLengthException;

public class Main {
	
	public static void main(String[] args) throws StreetLengthException {
		Car car = new Car();
		 int lane = car.whereIs().getCarLane();
		
<<<<<<< Updated upstream
		
		 UltrasoundSensor r1 = new UltrasoundSensor();
		 UltrasoundSensor r2 = new UltrasoundSensor();
		 UltrasoundSensor r3 = new UltrasoundSensor();
		 Lidar l = new Lidar();
		 //testing purposes
		 r1.setSensorValue(-1);
		 r2.setSensorValue(-1);
		 r3.setSensorValue(-1);
		 l.setLidarValue(1);
		 
		 
		 boolean res = car.leftLaneDetect(r1, r2, r3, l);
		 System.out.println(res);
=======
		 System.out.println(lane);
>>>>>>> Stashed changes
		 
		 
	}

}
