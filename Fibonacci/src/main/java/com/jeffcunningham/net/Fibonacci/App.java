package com.jeffcunningham.net.Fibonacci;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int fibonacci(int n) {
    	
        // Complete the function.
    		int count = 0;
    		if (n==0) {
    			
    		} else if (n==1) {
    			count ++;
    			
    		} else if (n>1) {
    			count = fibonacci(n-1) + fibonacci(n-2);
    		}
      
    		return count;
      
    }
    
    public static int fibonacciMemoization(int n) {
    		return fibonacci(n, new int[n+1]);
    }
    
    public static int bottomUpFibonacci(int n) {
	    	if (n==0||n==1) {
	    		return n;
	    }
	    	
	    	int[]memo = new int[n];
	    	memo[0] = 0;
	    	memo[1] = 1;
	    	for (int i = 2;i<n;i++) {
	    		memo[i] = memo[i-1]+ memo[i-2];
	    		System.out.println("just stored the value of " + memo[i]);
	    		
	    	}
	    	
	    	return memo[n-1]+memo[n-2];
    }
    
    public static int fibonacci(int n, int[]memo) {
    	
        if (n==0||n==1) {
        		return n;
        }
        
        if (memo[n]==0) {
        		memo[n] = fibonacci(n-1,memo) + fibonacci(n-2,memo);
        		
        		System.out.println("just stored the value of " + memo[n]);
        }
        
        return memo[n];
      
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
		long startTime = System.currentTimeMillis();
		System.out.println("Program start, startime = " + startTime);
        System.out.println(bottomUpFibonacci(n));
        
		long endTime   = System.currentTimeMillis();
		System.out.println("Program start, endtime = " + endTime);
		long totalTime = endTime - startTime;
		System.out.println("Program start, elapsed time = " + totalTime);
    }
}
