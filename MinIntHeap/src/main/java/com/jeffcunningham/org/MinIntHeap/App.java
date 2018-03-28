package com.jeffcunningham.org.MinIntHeap;

import java.util.Scanner;



/**
 * Hello world!
 *
 */
public class App {
	

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		MinIntHeap minIntHeap = new MinIntHeap();
		MaxIntHeap maxIntHeap = new MaxIntHeap();

		// for each entered INT
		int middleIndexForOdd;
		int[] middleIndexForEven = new int[2];
		
		float result;
		for (int i = 0; i < n; i++) {

			// for odd numbers the middle index is i/2 + i mod 2

			if (i == 0) {
//				System.out.println("******start loop = " + (i+1) + ", current item is = " + a[i]);
				minIntHeap.add(a[i]);
				middleIndexForOdd = 0;
//				logger.info("The middle index of a array of " + (i + 1) + " elements is = " + middleIndexForOdd);
				result = a[i];
//				System.out.println("===The current median = " + String.format(java.util.Locale.US,"%.1f", result));
				System.out.println(String.format(java.util.Locale.US,"%.1f", result));
			} else if (i == 1) {
//				System.out.println("******start loop = " + (i+1) + ", current item is = " + a[i]);
				if (a[i] > minIntHeap.peek()) {
					minIntHeap.add(a[i]);
				} else {
					maxIntHeap.add(a[i]);
				}
				result = ((float)a[i]+(float)a[i-1])/2;
//				System.out.println("===The current median = " + String.format(java.util.Locale.US,"%.1f", result));
				System.out.println(String.format(java.util.Locale.US,"%.1f", result));
			}

			else if (i % 2 == 0) {

//				System.out.println("******start loop = " + (i+1) + ", current item is = " + a[i]);

				// insert the current item into the correct heap
				if (a[i] > minIntHeap.peek()) {
					minIntHeap.add(a[i]);
				} else {
					maxIntHeap.add(a[i]);
				}

//				System.out.println(
//						"minIntHeap.peek() =  " + minIntHeap.peek() + " minIntHeap.items.size = " + minIntHeap.size);
//				System.out.println(
//						"maxIntHeap.peek() =  " + maxIntHeap.peek() + " maxIntHeap.items.size = " + maxIntHeap.size);

				if (minIntHeap.size - maxIntHeap.size > 1) {
//						logger.info("moving " + minIntHeap.peek() + " from minHeap to MaxHeap");
						maxIntHeap.add(minIntHeap.poll());
					
				}

				if (maxIntHeap.size - minIntHeap.size > 1) {
					
					
//						logger.info("moving " + maxIntHeap.peek() + " from maxheap to minHeap");
						minIntHeap.add(maxIntHeap.poll());
					
				}
				
//				System.out.println("minIntHeap.peek() =  " + minIntHeap.peek() + " minIntHeap.items.size = " + minIntHeap.size);
//				System.out.println("maxIntHeap.peek() =  " + maxIntHeap.peek() + " maxIntHeap.items.size = " + maxIntHeap.size);

				//since we are at an odd number in this loop, just peek at the bigger heap for the result
				if(maxIntHeap.size>minIntHeap.size) {
					result = (float)maxIntHeap.peek();
					
				}else {
					result = (float)minIntHeap.peek();
				}
				
//				System.out.println("===The current median = " + String.format(java.util.Locale.US,"%.1f", result));
//
//
//
//				System.out.println("******end loop = " + (i+1));
				System.out.println(String.format(java.util.Locale.US,"%.1f", result));
			} else if (i % 2 == 1) {

//				System.out.println("******start loop = " + (i+1) + ", current item is = " + a[i]);

				if (a[i] > minIntHeap.peek()) {
					minIntHeap.add(a[i]);
				} else {
					maxIntHeap.add(a[i]);
				}

//				System.out.println("minIntHeap.peek() =  " + minIntHeap.peek() + " minIntHeap.items.size = " + minIntHeap.size);
//				System.out.println("maxIntHeap.peek() =  " + maxIntHeap.peek() + " maxIntHeap.items.size = " + maxIntHeap.size);


				if (minIntHeap.size - maxIntHeap.size > 1) {

//					logger.info("moving " + minIntHeap.peek() + " from minHeap to MaxHeap");
					maxIntHeap.add(minIntHeap.poll());

				}

				if (maxIntHeap.size - minIntHeap.size > 1) {

//					logger.info("moving " + maxIntHeap.peek() + " from maxheap to minHeap");
					minIntHeap.add(maxIntHeap.poll());

				}
				

//				System.out.println(
//						"minIntHeap.peek() =  " + minIntHeap.peek() + " minIntHeap.items.size = " + minIntHeap.size);
//				System.out.println(
//						"maxIntHeap.peek() =  " + maxIntHeap.peek() + " maxIntHeap.items.size = " + maxIntHeap.size);
//				logger.info("The middle indexes of a array of " + (i + 1) + " elements is = " + middleIndexForEven[0]
//						+ ", and " + middleIndexForEven[1] + ". ");
				
				result = ((float)minIntHeap.peek()+(float)maxIntHeap.peek())/2;
				
//				System.out.println("===The current median = " + String.format(java.util.Locale.US,"%.1f", result));
//				System.out.println("******end loop = " + (i+1));
				
				System.out.println(String.format(java.util.Locale.US,"%.1f", result));
			}

		}

	}

}
