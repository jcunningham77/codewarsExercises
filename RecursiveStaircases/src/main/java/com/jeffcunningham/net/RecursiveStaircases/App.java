package com.jeffcunningham.net.RecursiveStaircases;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	
	//hints
	//1.) Approach this from the top down. what is the very last step the child made?
	//2.) If we knew the number of paths to each of the steps before step 100, could we calculate the #of steps to 100?
	//217,237,262,359
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            int numWaysToClimb = waysToClimb(n);
            System.out.println("There are " + numWaysToClimb + " ways to climb a flight of " + n + " steps.");
        }
        
    }
    
    private static int waysToClimb(int n) {
    		int[] memo = new int[n+1];
    		return waysToClimbMemo(n, memo);
    }
    
    
    
    private static int waysToClimbMemo(int n, int[] memo) {
    	
    	 if (n < 0) { /* base case */
    		   return 0;
    	 }
    	 if (n == 0) {/* base case */
    		   return 1;
    	 }
    	 
    	 if (memo[n] == 0){
    		 memo[n] =  waysToClimbMemo(n-1, memo) + waysToClimbMemo(n-2, memo) + waysToClimbMemo(n-3, memo); 
    	 }

    	return memo[n];	 
    		 
    	
    		
    		
    }
    
    
    
}
