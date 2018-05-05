package com.jeffcunningham.net.IceCreamParlor;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class HashMap1PassSolution {

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

	static void solve(int[] arr, int money) {

		HashMap map = new HashMap<Integer, Integer>(arr.length);
		outerloop:
		for (int i = 1; i < arr.length + 1; i++) {
			map.put(i, arr[i - 1]);
			
			int complement = money - arr[i - 1];
			if (map.containsValue(complement)) {
				if(printUniqueKey(map,i,complement)){
					return;
				}
			}
			
		}

		
		outerloop:
		for (int i = 1; i < arr.length + 1; i++) {
			int complement = money - arr[i - 1];
			if (map.containsValue(complement)) {
				if(printUniqueKey(map,i,complement)){
					return;
				}
			}
		}
	}
	
	private  static boolean printUniqueKey(HashMap<Integer, Integer> map, int index, int complement) {
		boolean solutionFound = false;
		
		Set<Entry<Integer,Integer>> entries = map.entrySet();
		for (Entry entry : entries) {
			if (((Integer) entry.getValue()).intValue() == complement) {
				if (((Integer) entry.getKey()).intValue() != index) {
					
					if (index < ((Integer) entry.getKey()).intValue()) {
						System.out.println(index + " " + (Integer) entry.getKey());
					} else {
						System.out.println((Integer) entry.getKey() + " " + index);
					}
					
					solutionFound = true;
					break;
					
				}
			}
		}
		
		return solutionFound;
		
		
	}

}
