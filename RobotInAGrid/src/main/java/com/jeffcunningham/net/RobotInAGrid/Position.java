package com.jeffcunningham.net.RobotInAGrid;

public class Position {
	int xCoordinate;
	int yCoordinate;
	
	public void moveDown(){
		yCoordinate++;
		System.out.println("Just moved down. Current position: x =  " + xCoordinate + ", y = " + yCoordinate);		
	}
	
	public void moveUp() {
		yCoordinate--;
		System.out.println("Just moved up. Current position: x =  " + xCoordinate + ", y = " + yCoordinate);		
	}		
	
	public void moveRight() {
		xCoordinate++;
		System.out.println("Just moved right. Current position: x =  " + xCoordinate + ", y = " + yCoordinate);	
	}
	
	public void moveLeft() {
		xCoordinate--;
		System.out.println("Just moved left. Current position: x =  " + xCoordinate + ", y = " + yCoordinate);		
	}

}
