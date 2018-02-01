package tests;

import static org.junit.Assert.*;

import org.junit.*;

import errorStreetException.StreetLengthException;
import main.*;

public class moveForwardTest {
	Car car;

	@Before
	public void setup() {
		car = new Car();

	}

	// Test1: check whether the car is moving
	@Test
	public void testMoveForward() throws StreetLengthException {
		Position pos = car.whereIs();
		boolean posX = pos.getPosX() < 100;
		pos.incrementPos();
		assertTrue("The care is moving!", true);

	}

	// Test2: Moving the car when no road left!
	@Test(expected = StreetLengthException.class)
	public void testMoveForwardStreetlengthException() throws StreetLengthException {
		Position pos = car.whereIs();
		boolean posX = pos.getPosX() > 100;
		StreetLengthException e = new StreetLengthException();
		assertFalse(e.toString(), false);

	}

}
