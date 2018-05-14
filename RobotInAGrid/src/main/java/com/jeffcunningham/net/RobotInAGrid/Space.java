package com.jeffcunningham.net.RobotInAGrid;

import java.util.Random;

public class Space {
	
	boolean dontStepOnMe;
	
	public Space() {
		if(new Random().nextInt(100)<20) {
			System.out.println("this space cannot be stepped on" );	
			dontStepOnMe=true;
		} else {
			System.out.println("this space can be stepped on" );	
			dontStepOnMe=false;
		}
	}

}
