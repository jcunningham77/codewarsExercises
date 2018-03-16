package com.jeffcunningham.org.leftRotation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class O2nSolution {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		FileInputStream fin=new FileInputStream("StInForShiftLeftLargeInputSet.txt");
		System.setIn(fin);
		
		
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        solution(n,k,a);

	}
	
	private static void solution(int size, int shift, int[] arr) {

		int count = 0;

		for (int i = shift; i < size; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
			count++;
		}

		count = 0;

		for (int i = size - shift; i < size; i++) {
			System.out.print(arr[count]);
			if (i != size - 1)
				System.out.print(" ");
			count++;
		}
	}
	
	

}
