package com.tav.TAV;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoadTest {
	
	Road rd = new Road();
	
	//TODO think of appropriate test
	@Test
	public void testfillRoad() {
		rd.fillRoad();
	}
	
	@Test
	public void testprintRoad() {
		
	}
	
	//NOT SURE IF CORRECT
	@Test
	public void testdrawCar() {
		int[] position = {0,0};
		rd.drawCar(position);
		assertEquals("x",rd.road[position[0]][position[1]]);
	}
	
	@Test
	public void testDrawObstacle() {
		
	}
	
	@Test
	public void testgenerateObjects() {
		
	}
}
