package com.tav.TAV;

public class Main {
	
	public static void main(String[] args) {
		Road rd = new Road();
		Car car = new Car();

		rd.fillRoad();
		rd.generateObjects();
		rd.drawCar(car.whereIs());
		rd.printRoad();
		System.out.println();

		//move and print
		try {
			car.moveFroward();
			rd.drawCar(car.whereIs());
			rd.printRoad();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			//1_ shift lane and print
			car.changeLane();
			rd.drawCar(car.whereIs());
			rd.printRoad();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			//2: shift lane and print
			car.changeLane();
			rd.drawCar(car.whereIs());
			rd.printRoad();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for( int i = 0; i < 17; i++){
			try {
				//2: shift lane and print
				car.changeLane();
				rd.drawCar(car.whereIs());
				rd.printRoad();
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
