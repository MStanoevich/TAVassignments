package main;

public class Car implements CarInterface {

	private int carLane = 1; // car starts in the left most lane 1 the right
								// most lane is 3
	private int positionX = 0; // MAX positionX == 100 this is the streetlength
	// array used to store the carLane and positionX
	private int[] pos = new int[2];
	// ultrasound sensors
	private UltrasoundSensor r1 = new UltrasoundSensor();
	private UltrasoundSensor r2 = new UltrasoundSensor();
	private UltrasoundSensor r3 = new UltrasoundSensor();
	
	
	//set the car lane
	public void setCarLane(int carLane) {
		this.carLane = carLane;
	}
	// set the  position
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	// lidar sensor
	private Lidar l = new Lidar();

	@Override
	public boolean moveFroward() {
		if (this.positionX < 100) {
			this.positionX += 5;
			return true;
		} else {
			System.out.println("Throw exception NO WHERE TO RUN");
			return false;
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
				} else if(querry[j] == 1) {
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
	public int changeLane() {
		if (this.carLane < 3) {
			moveFroward();
			this.carLane++;
			return 401;

		} else {
			moveFroward();
			return 403;
		}
	}

	@Override
	public int[] whereIs() {
		pos[0] = this.carLane;
		pos[1] = this.positionX;
		return pos;
	}
}
