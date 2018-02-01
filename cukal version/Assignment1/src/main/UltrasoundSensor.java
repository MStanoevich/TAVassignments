package main;

import java.util.Random;

public class UltrasoundSensor {
	private int sensorValue = 0;
	private String name = null;

	public void setName(String name) {
		this.name = name;
	}

	public int getSensorValue() {
		System.out.println("UltraSound sensor " + this.name + " value = " + this.sensorValue);
		return sensorValue;
	}

	public void setSensorValue(int sensorValue) {
		this.sensorValue = sensorValue;
	}

	public int generateRandomVal() {
		Random rand = new Random();
		//random values generated
		this.sensorValue = rand.nextInt(51) - 10;
		System.out.println("UltraSound sensor " + this.name + " value = " + this.sensorValue);
		// if the value of the sensor is smaller than 0 that means it is not
		// working properly
		if (this.sensorValue < 0) {
			return -1;
			// since the wide distance for a lane is 5 meters so if value is
			// less
			// than 5 meters that means that there is a car in the left lane
		} else if (this.sensorValue >= 0 && this.sensorValue < 5) {
			return 0;
			// bigger values than 5 there is no car in the left lane
		} else {
			return 1;
		}
	}

}
