package main;

import errorStreetException.StreetLengthException;

public class Car implements CarInterface {

	// pos object holds the information for the carlane and pos(distance)
	Position pos = new Position();

	// ultrasound sensors
	private UltrasoundSensor r1 = new UltrasoundSensor();
	private UltrasoundSensor r2 = new UltrasoundSensor();
	private UltrasoundSensor r3 = new UltrasoundSensor();
	// lidar sensor
	private Lidar l = new Lidar();

	// set the car lane
	public void setCarLane(int carLane) {
		this.pos.setCarLane(carLane);
	}

	// set the position
	public void setPositionX(int positionX) {
		this.pos.setPosX(positionX);
	}

	@Override
	public boolean moveFroward() throws StreetLengthException {
		if (this.pos.getPosX() < 100) {
			//increments the pos of the car by 5 meters
			this.pos.incrementPos();
			return true;
		} else {

			throw new StreetLengthException();
		}
	}

	@Override
	public boolean leftLaneDetect(UltrasoundSensor r1, UltrasoundSensor r2, UltrasoundSensor r3, Lidar l) {
		boolean[] readingsRes = new boolean[2];
		int[] querry = new int[4];
		// counters for sensor values
		int failedSensors = 0, positiveReadings = 0, negativeReadings = 0;
		// setting the names for traceability of their values
		r1.setName("r1");
		r2.setName("r2");
		r3.setName("r3");
		// Checking the sensors twice for new readings
		for (int i = 0; i < 2; i++) {
			// do you wannt to generate random val or

			// querry[0] = r1.generateRandomVal();
			// querry[1] = r2.generateRandomVal();
			// querry[2] = r3.generateRandomVal();
			// querry[3] = l.generateRandomVal();

			// get the fixed values
			querry[0] = r1.getSensorValue();
			querry[1] = r2.getSensorValue();
			querry[2] = r3.getSensorValue();
			querry[3] = l.getLidarValue();

			for (int j = 0; j < 4; j++) {
				if (querry[j] == -1) {
					// increase count of failed sensors
					failedSensors++;
				} else if (querry[j] == 0) {
					// increase count of negative readings meaning sensor
					// detects object closer than 5m
					negativeReadings++;
				} else if (querry[j] == 1) {
					positiveReadings++;
				}

			}
			if (failedSensors > 2) {
				// more than 2 sensors not working properly..cant change lane
				readingsRes[i] = false;
			} else if (negativeReadings >= 1) {
				// 1 or more negative readings left lane occupied
				readingsRes[i] = false;
			} else if (failedSensors <= 2 && negativeReadings == 0) {
				readingsRes[i] = true;
				// less or 2 failed sensors and no negative readings left lane
				// is empty
			} else {
				// do not KNOW
				readingsRes[i] = false;
			}
			System.out.println("Failed sens = " + failedSensors + " Positive = " + positiveReadings + " Negative = "
					+ negativeReadings);
			// initialize all counters to 0 before second querry
			failedSensors = 0;
			positiveReadings = 0;
			negativeReadings = 0;

		}

		// if we have true on both positions than we can say that there is no
		// car on the left
		if (readingsRes[0] && readingsRes[1]) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int changeLane() throws StreetLengthException {
		if (this.pos.getCarLane() < 3) {
			moveFroward();
			this.pos.incrementLane();
			// some success code dont know why??
			return 401;

		} else {
			moveFroward();
			throw new StreetLengthException();
		}
	}

	@Override
	public Position whereIs() throws StreetLengthException {
		if (this.pos.getCarLane() > 3 || this.pos.getCarLane() < 0 || this.pos.getPosX() < 0
				|| this.pos.getPosX() > 100) {
			throw new StreetLengthException();
		}
		return this.pos;
	}
}
