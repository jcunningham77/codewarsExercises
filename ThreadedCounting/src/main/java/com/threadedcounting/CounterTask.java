package com.threadedcounting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CounterTask implements Runnable {
	
	private static final Logger logger = LogManager.getLogger(CounterTask.class);
	
	private Object monitor;
	private int modValue;
	
	public CounterTask(Object monitor, int modValue) {
		this.monitor = monitor;
		this.modValue = modValue;	
		logger.info("Counter Task with modValue " + modValue + " has been created with monitor.hashCode() = " + monitor.hashCode());
	}

	public void run() {
	
		synchronized(monitor) {	
			
			while(true) {
				
				try {
					logger.debug("Counter Task with modValue " + modValue + ",  Counter.currentCount = " + Counter.currentCount);
					logger.debug("Counter Task with modValue " + modValue + " is about to invoke wait.");
					
					monitor.wait();
				} catch (InterruptedException e) {
					 logger.info("Counter Task with modValue " + modValue + " threw a InterruptedException");
					e.printStackTrace();
				}
				
				logger.debug("Counter Task with modValue " + modValue + " is working again after wait");
				
				if(Counter.currentCount<100) {
					logger.info("CounterTask with modValue = " + modValue + " is working, Counter.currentCount  =  " + Counter.currentCount);
					if(Counter.currentCount % 3 ==modValue) {
						logger.info("Calling Counter.count! ");
						Counter.count();
					}	

				} 
				
				logger.debug("Counter Task with modValue " + modValue + " is about to notify");
				
				monitor.notify();
				
				if (Counter.currentCount==100){
					logger.info("Counter Task with modValue " + modValue + " is killing itself");
					return;
					
				}
				
			}	
		}
	}
}
