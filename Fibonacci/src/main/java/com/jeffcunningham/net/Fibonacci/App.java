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
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
       
        System.out.println(fibonacci(n));
    }
}
