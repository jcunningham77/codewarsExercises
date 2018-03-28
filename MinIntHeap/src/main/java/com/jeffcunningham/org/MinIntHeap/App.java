package com.jeffcunningham.org.MinIntHeap;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
	private static Logger logger;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		logger = LogManager.getLogger();

		MinIntHeap minIntHeap = new MinIntHeap();
		MaxIntHeap maxIntHeap = new MaxIntHeap();

		// for each entered INT
		int middleIndexForOdd;
		int[] middleIndexForEven = new int[2];
		for (int i = 0; i < n; i++) {

			// for odd numbers the middle index is i/2 + i mod 2

			if (i == 0) {
				minIntHeap.add(a[i]);
				middleIndexForOdd = 0;
				logger.info("The middle index of a array of " + (i + 1) + " elements is = " + middleIndexForOdd);
				// logger.info(minIntHeap.items[middleIndexForOdd]);

			} else if (i == 1) {
				if (a[i] > minIntHeap.peek()) {
					minIntHeap.add(a[i]);
				} else {
					maxIntHeap.add(a[i]);
				}

			}

			else if (i % 2 == 0) {

				System.out.println("******start loop = " + i + ", current item is = " + a[i]);

				// insert the current item into the correct heap
				if (a[i] > minIntHeap.peek()) {
					minIntHeap.add(a[i]);
				} else {
					maxIntHeap.add(a[i]);
				}

				System.out.println(
						"minIntHeap.peek() =  " + minIntHeap.peek() + " minIntHeap.items.size = " + minIntHeap.size);
				System.out.println(
						"maxIntHeap.peek() =  " + maxIntHeap.peek() + " maxIntHeap.items.size = " + maxIntHeap.size);

				if (minIntHeap.size - maxIntHeap.size > 1) {
						logger.info("moving " + minIntHeap.peek() + " from minHeap to MaxHeap");
						maxIntHeap.add(minIntHeap.poll());
					
				}

				if (maxIntHeap.size - minIntHeap.size > 1) {
					
					
						logger.info("moving " + maxIntHeap.peek() + " from maxheap to minHeap");
						minIntHeap.add(maxIntHeap.poll());
					
				}

				// this is actually an array of odd elements since i hasn't been incremented yet
				middleIndexForOdd = i / 2;
				// logger.info("The middle index of a array of " + (i + 1) + " elements is = " +
				// middleIndexForOdd);

				System.out.println("minIntHeap.peek() =  " + minIntHeap.peek() + " minIntHeap.items.size = " + minIntHeap.size);
				System.out.println("maxIntHeap.peek() =  " + maxIntHeap.peek() + " maxIntHeap.items.size = " + maxIntHeap.size);

				System.out.println("******end loop = " + i);
			} else if (i % 2 == 1) {

				System.out.println("******start loop = " + i + ", current item is = " + a[i]);

				if (a[i] > minIntHeap.peek()) {
					minIntHeap.add(a[i]);
				} else {
					maxIntHeap.add(a[i]);
				}

				System.out.println("minIntHeap.peek() =  " + minIntHeap.peek() + " minIntHeap.items.size = " + minIntHeap.size);
				System.out.println("maxIntHeap.peek() =  " + maxIntHeap.peek() + " maxIntHeap.items.size = " + maxIntHeap.size);

				middleIndexForEven[0] = i / 2;
				middleIndexForEven[1] = i / 2 + 1;
				if (minIntHeap.size - maxIntHeap.size > 1) {

					logger.info("moving " + minIntHeap.peek() + " from minHeap to MaxHeap");
					maxIntHeap.add(minIntHeap.poll());

				}

				if (maxIntHeap.size - minIntHeap.size > 1) {

					logger.info("moving " + maxIntHeap.peek() + " from maxheap to minHeap");
					minIntHeap.add(maxIntHeap.poll());

				}
				logger.info("The middle indexes of a array of " + (i + 1) + " elements is = " + middleIndexForEven[0]
						+ ", and " + middleIndexForEven[1] + ". ");

				System.out.println(
						"minIntHeap.peek() =  " + minIntHeap.peek() + " minIntHeap.items.size = " + minIntHeap.size);
				System.out.println(
						"maxIntHeap.peek() =  " + maxIntHeap.peek() + " maxIntHeap.items.size = " + maxIntHeap.size);
				// System.out.println(String.format(java.util.Locale.US,"%.2f", result));
				System.out.println("******end loop = " + i);
			}

		}

	}

}
