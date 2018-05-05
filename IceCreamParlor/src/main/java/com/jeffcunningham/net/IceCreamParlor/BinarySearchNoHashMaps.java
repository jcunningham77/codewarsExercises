package com.jeffcunningham.net.IceCreamParlor;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class BinarySearchNoHashMaps {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int money = in.nextInt();
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			solve(arr, money);
		}
		in.close();

	}
	
	static void solve(int[] menuArray, int money) {

		int[] sortedArray = menuArray.clone();

		Arrays.sort(sortedArray);
		
		//1, traverse sorted array, and do binary search for complement of the current menu item
		//then you will have the values of the ice cream prices
		for (int i=0;i<sortedArray.length;i++) {
			int complement = money-sortedArray[i];
			int location = Arrays.binarySearch(sortedArray, i+1, sortedArray.length,complement);
			if(location>=0 && location<sortedArray.length && sortedArray[location]==complement) {
				int[] indices = getIndices(menuArray, sortedArray[i], complement);
				System.out.println(indices[0] + " " + indices[1]);
			}
			
			
		}
		
	}
	
	static int[] getIndices(int[] menuArray, int value1, int value2) {
		int index1 = getIndexForValue(menuArray, value1, -1);
		int index2 = getIndexForValue(menuArray, value2, index1);
		
		
		int[] indices = new int[2];
		
		indices[0] = Math.min(index1, index2) + 1;
		indices[1] = Math.max(index1, index2) + 1;
		
		return indices;
		
	}
	
	static int getIndexForValue(int[] menuArray, int value, int excludedIndex) {
		for(int i=0;i<menuArray.length;i++) {
			if (menuArray[i]==value && i != excludedIndex) {
				return i;
			}
		}
		
		return -1;
		
		
		
	}

}
