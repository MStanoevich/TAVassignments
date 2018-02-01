package tests;

import static org.junit.Assert.*;

import org.junit.*;
import main.*;

public class whereIsTests {
	Car car;

	@Before
	public void setup() {
		car = new Car();

	}

	// TEST1 The starting lane should be 1
	@Test
	public void testNewCarLane() {
		int[] pos = car.whereIs();
		int lane = pos[0];
		assertEquals("The initial lane where the car is expected to be is 1", 1, lane);
	}

	// TEST2 The starting pos should be 0
	@Test
	public void testNewCarPosition() {
		int[] pos = car.whereIs();
		int posX = pos[1];
		assertEquals("The initial position where the car is expected to be is 0", 0, posX);
	}

	// TEST3 changing the lane
	@Test
	public void testChangeCarLane() {
		car.setCarLane(2);
		int[] pos = car.whereIs();
		int lane = pos[0];
		assertEquals("The  lane where the car is expected to be is 2", 2, lane);
	}

	// TEST4 changing the position
	@Test
	public void testChangeCarPosition() {
		car.setPositionX(80);
		int[] pos = car.whereIs();
		int posX = pos[1];
		assertEquals("The  position where the car is expected to be is 80", 80, posX);
	}

	// there should be test when we try to put the car on lane -1 and 4 it
	// should generate an exception and also when we try to put the position more than 100 or less than 0 4 TEST MORE

}
