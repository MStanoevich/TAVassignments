package main;

import java.util.Random;

public class Lidar {
	private int lidarValue = 0;

	public int getLidarValue() {
		System.out.println("Lidar sensor value = " + this.lidarValue);
		return lidarValue;
	}

	public void setLidarValue(int lidarValue) {
		this.lidarValue = lidarValue;
	}

	public int generateRandomVal() {
		Random rand = new Random();
		this.lidarValue = rand.nextInt(51);
		System.out.println("Lidar sensor value = " + this.lidarValue);
		// if the value of the sensor is smaller than 0 that means it is not
		// working properly
		if (this.lidarValue < 0) {
			return -1;
			// since the wide distance for a lane is 5 meters so if value is
			// less
			// than 5 meters that means that there is a car in the left lane
		} else if (this.lidarValue >= 0 && this.lidarValue < 5) {
			return 0;
			// bigger values than 5 there is no car in the left lane
		} else {
			return 1;
		}
	}

}
