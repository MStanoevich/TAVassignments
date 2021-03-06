package tests;

import static org.junit.Assert.*;
import org.junit.*;
import main.*;

public class leftLaneDetectTests {
	// implementation of car interface
	private Car car;
	// ultrasound sensors
	private UltrasoundSensor r1;
	private UltrasoundSensor r2;
	private UltrasoundSensor r3;
	// lidar sensor
	private Lidar l1;

	@Before
	public void setup() {
		car = new Car();
		r1 = new UltrasoundSensor();
		r2 = new UltrasoundSensor();
		r3 = new UltrasoundSensor();
		l1 = new Lidar();

	}

	// TEST1 3 failed sensors in the first querie should not allow the car to
	// change
	// the lane
	// leftLaneDetect returns true if the lane is empty false if not
	// Values: falied sensor = -1,detected car = 0, lane empty = 1
	@Test
	public void testFailedSensorsFirstQuerie() {
		// first querry values
		r1.setFirstValue(-1);
		r2.setFirstValue(-1);
		r3.setFirstValue(1);
		l1.setFirstLidarValue(-1);
		// second querry values
		r1.setSecondValue(1);
		r2.setSecondValue(1);
		r3.setSecondValue(1);
		l1.setSecLidarValue(-1);
		boolean res = car.leftLaneDetect(r1, r2, r3, l1);

		assertFalse("There are more than 3 failed sensors , value should be false", res);
	}

	// TEST2 3 failed sensors in the second querie should not allow the car to
	// change
	// the lane
	// leftLaneDetect returns true if the lane is empty false if not
	// Values: falied sensor = -1,detected car = 0, lane empty = 1

	@Test
	public void testFailedSensorsSecQuerie() {
		// first querry values
		r1.setFirstValue(1);
		r2.setFirstValue(1);
		r3.setFirstValue(1);
		l1.setFirstLidarValue(1);
		// second querry values
		r1.setSecondValue(-1);
		r2.setSecondValue(1);
		r3.setSecondValue(-1);
		l1.setSecLidarValue(-1);
		boolean res = car.leftLaneDetect(r1, r2, r3, l1);

		assertFalse("There are more than 3 failed sensors , value should be false", res);
	}

	// TEST3 3 failed sensors in the both queries should not allow the car to
	// change
	// the lane
	// leftLaneDetect returns true if the lane is empty false if not
	// Values: falied sensor = -1,detected car = 0, lane empty = 1
	@Test
	public void testFailedSensorsBothQueries() {
		// first querry values
		r1.setFirstValue(-1);
		r2.setFirstValue(-1);
		r3.setFirstValue(-1);
		l1.setFirstLidarValue(1);
		// second querry values
		r1.setSecondValue(-1);
		r2.setSecondValue(1);
		r3.setSecondValue(-1);
		l1.setSecLidarValue(-1);
		boolean res = car.leftLaneDetect(r1, r2, r3, l1);

		assertFalse("There are more than 3 failed sensors , value should be false", res);
	}

	// TEST4 Scenario where one sensor in first querie reads that there is an
	// object present
	// leftLaneDetect returns true if the lane is empty false if not
	// Values: falied sensor = -1,detected car = 0, lane empty = 1
	@Test
	public void testNegativeValueFirstQuerie() {
		// first querry values
		r1.setFirstValue(1);
		r2.setFirstValue(1);
		r3.setFirstValue(0);
		l1.setFirstLidarValue(1);
		// second querry values
		r1.setSecondValue(1);
		r2.setSecondValue(1);
		r3.setSecondValue(1);
		l1.setSecLidarValue(1);
		boolean res = car.leftLaneDetect(r1, r2, r3, l1);

		assertFalse("Sensor r3 reads that a car is present in the left lane", res);
	}

	// TEST5 Scenario where one sensor in second querie reads that there is an
	// object present
	// leftLaneDetect returns true if the lane is empty false if not
	// Values: falied sensor = -1,detected car = 0, lane empty = 1
	@Test
	public void testNegativeValueSecondQuerie() {
		// first querry values
		r1.setFirstValue(1);
		r2.setFirstValue(1);
		r3.setFirstValue(1);
		l1.setFirstLidarValue(1);
		// second querry values
		r1.setSecondValue(1);
		r2.setSecondValue(0);
		r3.setSecondValue(1);
		l1.setSecLidarValue(1);
		boolean res = car.leftLaneDetect(r1, r2, r3, l1);

		assertFalse("Sensor r2 reads that a car is present in the left lane", res);
	}

	// TEST6 Scenario where one sensor in both querie reads that there is an
	// object present
	// leftLaneDetect returns true if the lane is empty false if not
	// Values: falied sensor = -1,detected car = 0, lane empty = 1
	@Test
	public void testNegativeReadingsTwiceInQuerie() {
		// first querry values
		r1.setFirstValue(1);
		r2.setFirstValue(1);
		r3.setFirstValue(0);
		l1.setFirstLidarValue(1);
		// second querry values
		r1.setSecondValue(1);
		r2.setSecondValue(0);
		r3.setSecondValue(1);
		l1.setSecLidarValue(1);
		boolean res = car.leftLaneDetect(r1, r2, r3, l1);

		assertFalse("Sensor r3 and r2 read that a car is present in the left lane", res);
	}

	// TEST7 Scenario where two sensors in first querie that failed but other
	// dont
	// read that there is an
	// object present
	// leftLaneDetect returns true if the lane is empty false if not
	// Values: falied sensor = -1,detected car = 0, lane empty = 1
	@Test
	public void test2Failed2PositiveReadingsFirst() {
		// first querry values
		r1.setFirstValue(-1);
		r2.setFirstValue(-1);
		r3.setFirstValue(1);
		l1.setFirstLidarValue(1);
		// second querry values
		r1.setSecondValue(1);
		r2.setSecondValue(1);
		r3.setSecondValue(1);
		l1.setSecLidarValue(1);
		boolean res = car.leftLaneDetect(r1, r2, r3, l1);

		assertTrue("No object on the left side value should be true", res);
	}

	// TEST8 Scenario where two sensors in second querie that failed but other
	// dont
	// read that there is an
	// object present
	// leftLaneDetect returns true if the lane is empty false if not
	// Values: falied sensor = -1,detected car = 0, lane empty = 1
	@Test
	public void test2Failed2PositiveReadingsSecond() {
		// first querry values
		r1.setFirstValue(1);
		r2.setFirstValue(1);
		r3.setFirstValue(1);
		l1.setFirstLidarValue(1);
		// second querry values
		r1.setSecondValue(-1);
		r2.setSecondValue(-1);
		r3.setSecondValue(1);
		l1.setSecLidarValue(1);
		boolean res = car.leftLaneDetect(r1, r2, r3, l1);

		assertTrue("No object on the left side value should be true", res);
	}

	// TEST9 Scenario where two sensors in both querie that failed but other
	// dont
	// read that there is an
	// object present
	// leftLaneDetect returns true if the lane is empty false if not
	// Values: falied sensor = -1,detected car = 0, lane empty = 1
	@Test
	public void test2Failed2PositiveReadingsBoth() {
		// first querry values
		r1.setFirstValue(-1);
		r2.setFirstValue(-1);
		r3.setFirstValue(1);
		l1.setFirstLidarValue(1);
		// second querry values
		r1.setSecondValue(-1);
		r2.setSecondValue(-1);
		r3.setSecondValue(1);
		l1.setSecLidarValue(1);
		boolean res = car.leftLaneDetect(r1, r2, r3, l1);

		assertTrue("No object on the left side value should be true", res);
	}

	// TEST10 Scenario where all sensors read that there is no object present in
	// the left lane
	// leftLaneDetect returns true if the lane is empty false if not
	// Values: falied sensor = -1,detected car = 0, lane empty = 1
	@Test
	public void testAllPositiveReadings() {
		// first querry values
		r1.setFirstValue(1);
		r2.setFirstValue(1);
		r3.setFirstValue(1);
		l1.setFirstLidarValue(1);
		// second querry values
		r1.setSecondValue(1);
		r2.setSecondValue(1);
		r3.setSecondValue(1);
		l1.setSecLidarValue(1);
		boolean res = car.leftLaneDetect(r1, r2, r3, l1);

		assertTrue("No object on the left side value should be true", res);
	}

}
