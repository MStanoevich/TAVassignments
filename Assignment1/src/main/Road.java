package main;

import java.security.Principal;
import java.util.Random;

public class Road {
	
	private int lane = 3;
	private int distance = 20;
	private String[][] myStringArray = new String[lane][distance];

	 void fillRoad() {
		for (int i = 0; i < lane; i++) {
			for (int j = 0; j < distance; j++) {
				this.myStringArray[i][j] = ".";
			}
		}
	}
	 void printRoad() {
		for (int i = lane-1; i >= 0; i--) {
			for (int j = 0; j < distance; j++) {
				System.out.print(this.myStringArray[i][j] + " ");
			}
			System.out.println();
		}	
	}
	void markCar(int carLane, int carDistance){
		this.myStringArray[carLane][carDistance] = "x";
	}
	
	void markObject(int posX, int posY){
		this.myStringArray[posX][posY] = "O";
	}
	
	void generateObjects(){
		Random rand = new Random();
		for(int i= 0;i<4;i++){
			int posX = rand.nextInt(2) + 1;
			int posY = rand.nextInt(20);
			
			markObject(posX, posY);	
		}	
	}
	
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
