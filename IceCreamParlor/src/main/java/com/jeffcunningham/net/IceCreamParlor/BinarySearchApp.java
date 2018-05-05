package com.jeffcunningham.net.IceCreamParlor;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class BinarySearchApp {
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

		Hashtable originalOrderHash = new Hashtable<Integer, Integer>(arr.length);
		for (int i = 1; i < arr.length + 1; i++) {
			originalOrderHash.put(i, arr[i - 1]);
		}

		Arrays.sort(arr);

		int cone1Amount = 0;
		int cone2Amount = 0;

		int indexForFirstCone = -1;
		int indexForSecondCone = -1;

		int originalIndexForFirstCone = 0, originalIndexForSecondCone = 0;

		while (indexForFirstCone < 0 || indexForSecondCone < 0) {

			cone1Amount++;
			cone2Amount = money - cone1Amount;

			indexForFirstCone = Arrays.binarySearch(arr, cone1Amount);
			if (indexForFirstCone > 0 && cone1Amount == cone2Amount) {
				// search right around the found index if these values are equal

				if (indexForFirstCone == 0) {// check the case that the found index was the first one in the array
					indexForSecondCone = Arrays.binarySearch(arr, indexForFirstCone + 1, indexForFirstCone + 2,
							cone2Amount);
				} else if (indexForFirstCone == arr.length) {// check the case that the found index was the last one in
																// the array
					indexForSecondCone = Arrays.binarySearch(arr, indexForFirstCone - 1, indexForFirstCone,
							cone2Amount);
				} else {
					indexForSecondCone = Arrays.binarySearch(arr, indexForFirstCone - 1, indexForFirstCone,
							cone2Amount);
					if (indexForSecondCone == -1) {
						indexForSecondCone = Arrays.binarySearch(arr, indexForFirstCone + 1, indexForFirstCone + 2,
								cone2Amount);
					}
				}

			} else {
				indexForSecondCone = Arrays.binarySearch(arr, cone2Amount);
			}

		}

		boolean foundFirst = false;
		boolean foundSecond = false;

		Set<Entry> entries = originalOrderHash.entrySet();
		for (Entry entry : entries) {

			if (!foundFirst && cone1Amount == ((Integer) entry.getValue()).intValue()) {
				originalIndexForFirstCone = (Integer) entry.getKey();
				foundFirst = true;
				if (cone1Amount == cone2Amount) {
					continue;
				}
			}

			if (!foundSecond && cone2Amount == ((Integer) entry.getValue()).intValue()) {
				originalIndexForSecondCone = (Integer) entry.getKey();
				foundSecond = true;
			}

			if (foundFirst && foundSecond) {
				break;
			}
		}

		if (originalIndexForSecondCone < originalIndexForFirstCone) {
			System.out.println(originalIndexForSecondCone + " " + originalIndexForFirstCone);
		} else {
			System.out.println(originalIndexForFirstCone + " " + originalIndexForSecondCone);
		}

	}
}
