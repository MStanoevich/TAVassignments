package com.tav.TAV;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CarTest {
	
	Car car = new Car();
	
	@Test
	public void testMoveForward() {
		try {
			car.moveFroward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1, car.position[1],0);
	}
	
	
	//TODO do test case when function is written
	@Test
	public void testleftLaneDetect() {
		
	}
	
	@Test
	public void testchangeLane() throws Exception {
		car.changeLane();
		assertEquals(1, car.position[0],0);
		car.changeLane();
		assertEquals(2, car.position[0],0);
	}
	
	@Test
	public void testwhereIs() {
		//Checks whether the position array is null
		//failure here is a success
		assertNull(car.position);
	}
	

}
