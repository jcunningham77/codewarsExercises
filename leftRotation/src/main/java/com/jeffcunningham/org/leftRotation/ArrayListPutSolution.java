package com.jeffcunningham.org.leftRotation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListPutSolution {

	public static void main(String[] args) throws FileNotFoundException {
  		long startTime = System.currentTimeMillis();
//		System.out.println("Program start, startime = " + startTime);
    	

		FileInputStream fin;
		fin = new FileInputStream("StInForShiftLeftLargeInputSet.txt");

		System.setIn(fin);
    	
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        System.out.println("Program start, our array is length = " + n + " elements.");
        int k = in.nextInt();
//        System.out.println("Program start, we want to shift left  = " + k + " spaces.");
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        List resultingArray = new ArrayList();
        for (int i= k;i!=k-1;i++) {
        		if (i==a.length) {
//        			System.out.println("This loop index > array size, start from the beginning");
        			i=0;
        		}
        		resultingArray.add(a[i]);
        }
        resultingArray.add(a[k-1]);
        
        
        int result[] = new int[n];
        for (int i = 0;i<n;i++) {
        		result[i] = ((Integer)resultingArray.get(i)).intValue();
        }
        
        for (int i=0;i<n;i++) {
        	System.out.print(result[i] + " ");	
        } 

	}

}
