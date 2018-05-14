package com.jeffcunningham.net.RobotInAGrid;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Scanner in = new Scanner(System.in);
        int height = in.nextInt();
        int width = in.nextInt();
        
        System.out.println("The grid is " + height + " spaces high and " + width + " spaces wide.");
        
        
        
        Space[][] grid = new Space[height][width];
        for (int i=0;i<height;i++) {
        		for (int j=0;j<width;j++) {
        			grid[i][j] = new Space();
        		}
        }
        
        
        for (int j=0;j<width;j++) {
        		if(j<width-1) {
				System.out.print("|"+j);
			}else  {
				System.out.println("|"+j);
			}
        }
        for (int i=0;i<height;i++) {
    			for (int j=0;j<width;j++) {
    				
    				System.out.print("|");
    				if (grid[i][j].dontStepOnMe) {
    					System.out.print("X");
    				} else {
    					System.out.print(" ");
    				}
    				if (j==width-1) {
    					System.out.println("|");
    				}
    			}
        }
        
        System.out.println("This grid is " + grid[0].length + " spaces wide.");
        System.out.println("This grid is " + grid.length + " spaces tall.");
        
        traverseGrid(grid);
    }
    
    private static void traverseGrid(Space[][] grid) {
    		Position currentPosition = new Position();
    		
    		currentPosition.xCoordinate = 0;
    		currentPosition.yCoordinate = 0;
    		int counter=0;
    		try {
        		while (currentPosition.xCoordinate < grid[0].length && currentPosition.yCoordinate < grid.length) {
        			
        			//try to move the position as far right as possible
        			//if we aren't all the way right
        			if (currentPosition.xCoordinate<grid[0].length-1) {
        				//first check if can step right
        				if (!grid[currentPosition.yCoordinate][currentPosition.xCoordinate+1].dontStepOnMe) {
        					System.out.println("I can step right");
        					currentPosition.moveRight();
        				} else if (grid[currentPosition.yCoordinate][currentPosition.xCoordinate+1].dontStepOnMe) {
	    	    				System.out.println("can't step to the right, so I'll check if I can step down");
	    	    			} else if (grid[currentPosition.yCoordinate+1][currentPosition.xCoordinate].dontStepOnMe) {
	    	    				System.out.println("I can't step down, so I will step back left");
	    	    				currentPosition.moveLeft();
	    	    			} else if (!grid[currentPosition.yCoordinate+1][currentPosition.xCoordinate].dontStepOnMe)  {	    	    				
	    	    				System.out.println("I can step down so I will");
	    	    				currentPosition.moveDown();
	    	    			} else {
	    	    				System.out.println("bottom block of horizontal check");
	    	    			}
        			}
        			
        			//if we aren't at the bottom
        			if (currentPosition.yCoordinate<grid.length-1) {
        				//first check if we can step down
	    	    			if (!grid[currentPosition.yCoordinate+1][currentPosition.xCoordinate].dontStepOnMe) {
	    	    				System.out.println("I can step down!");
	    	    				currentPosition.moveDown();
	    	    			} else if (grid[currentPosition.yCoordinate+1][currentPosition.xCoordinate].dontStepOnMe) {
	    	    				System.out.println("I can't step down, so I'll check if I can step right");
	    	    			} else if (grid[currentPosition.yCoordinate][currentPosition.xCoordinate+1].dontStepOnMe) {
	    	    				System.out.println("I can't step right, so I will step back up");
	    	    				currentPosition.moveUp();
	    	    			} else if (!grid[currentPosition.yCoordinate][currentPosition.xCoordinate+1].dontStepOnMe){
	    	    				currentPosition.moveRight();
	    	    			} else {
	    	    				System.out.println("bottom block of vertical check");
	    	    			}
        			}   
        			
        			if (currentPosition.xCoordinate==grid[0].length-1&&currentPosition.yCoordinate== grid.length-1) {
        				System.out.println("we are at the bottom rightmost square in the grid");
        				break;
        			}else {
        				
//        				System.out.println("width = " + grid[0].length);
//        				System.out.println("height = " + grid.length);
        				
        				System.out.println("we are not at the bottom rightmost square in the grid, continue");
        			}
        			if (counter>50) {
        				System.out.println("breaking bc counter >50");
        				break;
        			}
        			counter++;
        		}
    		} catch (ArrayIndexOutOfBoundsException e) {
    			System.out.println("this grid cannot be traversed");
    			System.out.println(e.getStackTrace());
    		}

    }
    
}
