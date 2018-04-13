package com.jeffcunningham.net.Bubble;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int numSwaps = 0;
        boolean isSorted = false;
        while(!isSorted) {
        		isSorted = true;
        		for(int i=0;i<a.length-1;i++) {
        			if(a[i]>a[i+1]) {
        				isSorted = false;
        				swap(a,i,i+1);
        				numSwaps++;
        			}
        		}
        }
        System.out.println("Array is sorted in " + numSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);
    }
    
    private static void swap(int[] array, int indexA, int indexB) {
    		int temp;
    		temp = array[indexA];
    		array[indexA] = array[indexB];
    		array[indexB] = temp;
    }
    
}
