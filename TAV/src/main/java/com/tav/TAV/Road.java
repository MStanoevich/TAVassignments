package com.tav.TAV;

import java.util.Random;

public class Road {

	private int lane = 3;
	private int distance = 20;
	String[][] road = new String[lane][distance];
	private int[] prevLoc = new int[]{0,0};


	void fillRoad() {
		for (int i = 0; i < lane; i++) {
			for (int j = 0; j < distance; j++) {
				this.road[i][j] = ".";
			}
		}
	}

	void printRoad() {
		for (int i = lane - 1; i >= 0; i--) {
			for (int j = 0; j < distance; j++) {
				System.out.print(this.road[i][j] + " ");
			}
			System.out.println();
		}
	}

	void drawCar(int[] position) {
		this.road[prevLoc[0]][prevLoc[1]] = ".";
		prevLoc[0] = position[0];
		prevLoc[1] = position[1];
		this.road[position[0]][position[1]] = "x";
	}

	void drawObstacle(int posX, int posY) {
		this.road[posX][posY] = "O";
	}

	void generateObjects() {
		Random rand = new Random();
		for (int i = 0; i < 4; i++) {
			int posX = rand.nextInt(2) + 1;
			int posY = rand.nextInt(20);
			drawObstacle(posX, posY);
		}
	}
}
