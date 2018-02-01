package main;

public class Position {
	private int carLane = 1;
	private int positionX = 0;

	public int getCarLane() {
		return carLane;
	}

	public void setCarLane(int lane) {
		this.carLane = lane;
	}

	public int getPosX() {
		return positionX;
	}

	public void setPosX(int posX) {
		this.positionX = posX;
	}
	
	public void incrementPos(){
		this.positionX += 5;
	}
	public void incrementLane(){
		this.carLane++;
	}
}
