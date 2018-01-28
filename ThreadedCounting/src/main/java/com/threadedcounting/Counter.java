package com.threadedcounting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
	
	private static final Logger logger = LogManager.getLogger(Counter.class);
	
	public static int currentCount;
	
	synchronized static void count() {
		logger.info("Incrementing the count, " + currentCount);
		currentCount++;
	}

}
