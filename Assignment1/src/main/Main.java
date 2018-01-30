package main;

public class Main {
	
	public static void main(String[] args) {
		Road rd = new Road();
		rd.fillRoad();
		rd.markCar(0,0);
		rd.generateObjects();
		rd.printRoad();
		System.out.println();
		rd.markCar(0,1);
		rd.printRoad();
	}

}
