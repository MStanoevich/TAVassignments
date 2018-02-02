package main;

import java.util.Random;

public class UltrasoundSensor {
	private int[] sensorValue = new int[2];
	private String name = null;

	public void setName(String name) {
		this.name = name;
	}
	

	public int getSensorValue(int index) {
		System.out.println("UltraSound sensor " + this.name + " value = " + this.sensorValue[index]);
		return this.sensorValue[index];
	}

	public void setFirstValue(int sensorValue) {
		this.sensorValue[0] = sensorValue;
	}

	public void setSecondValue(int sensorValue) {
		this.sensorValue[1] = sensorValue;
	}
	
	public void setBothValues(int sensorValOne,int sensorValTwo) {
		this.sensorValue[0] = sensorValOne;
		this.sensorValue[1] = sensorValTwo;
	}

	public int generateRandomVal() {
		Random rand = new Random();
		// random values generated
		int randVal = rand.nextInt(51) - 10;
		System.out.println("UltraSound sensor " + this.name + " value = " + this.sensorValue);
		// if the value of the sensor is smaller than 0 that means it is not
		// working properly
		if (randVal < 0) {
			return -1;
			// since the wide distance for a lane is 5 meters so if value is
			// less
			// than 5 meters that means that there is a car in the left lane
		} else if (randVal >= 0 && randVal < 5) {
			return 0;
			// bigger values than 5 there is no car in the left lane
		} else {
			return 1;
		}
	}

}
