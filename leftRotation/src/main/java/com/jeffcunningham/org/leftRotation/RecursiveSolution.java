package com.jeffcunningham.org.leftRotation;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * This solution will time out for input sets of a large amount,
 * because it will iterate over each array element 1 time for every shift we need to do
 * 
 */

public class RecursiveSolution {

    public static void main(String[] args) throws FileNotFoundException {
    	
    		long startTime = System.currentTimeMillis();
		System.out.println("Program start, startime = " + startTime);
    	

		FileInputStream fin;
		fin = new FileInputStream("StInForShiftLeftLargeInputSet.txt");

		System.setIn(fin);
    	
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Program start, our array is length = " + n + " elements.");
        int k = in.nextInt();
        System.out.println("Program start, we want to shift left  = " + k + " spaces.");
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int resultingArray[] = shiftArrayLeft(a,n,k);
        
        
        
//        System.out.println("number of items in array = n = " + n);
//        System.out.println("number of shifts to the left k = " + k);
//        System.out.println("Original Array = " + Arrays.toString(a));
//        System.out.println(Arrays.toString(resultingArray));
        for (int i=0;i<n;i++) {
        	System.out.print(resultingArray[i] + " ");	
        }
        
		long endTime   = System.currentTimeMillis();
		System.out.println("Program start, endtime = " + endTime);
		long totalTime = endTime - startTime;
		System.out.println("Program start, elapsed time = " + totalTime);        
    }
    
    private static int[] shiftArrayLeft(int a[],int arraySize, int numberOfShifts) {

    		if (numberOfShifts==0) {
    			return a;
    		}else {
    			int resultingArray[] = new int[arraySize];
        		for(int i=0;i<arraySize;i++) {	
                	
            		if(i==0) {
            			resultingArray[arraySize-1] = a[i];
            		} else {
            			resultingArray[i-1] = a[i];
            		}           		
            }
    			return shiftArrayLeft(resultingArray,arraySize,numberOfShifts-1);
    		}

    }
}
