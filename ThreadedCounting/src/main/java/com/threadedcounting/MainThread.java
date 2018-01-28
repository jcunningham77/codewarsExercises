package com.threadedcounting;

import java.util.ArrayList;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class MainThread extends Thread 
{
	 private static final Logger logger = LogManager.getLogger(MainThread.class);
	 
	public void run()
    {
        
        logger.debug("Hello World! this is the main program. ");
        
        
        Object monitor = new Object();
                
        List<Thread> threadListList = new ArrayList();
        for (int i=0;i<3;i++) {
        		
        		threadListList.add(new Thread(new CounterTask(monitor,i)));
        	
        }
        
        for (int i=0;i<3;i++) {
        		threadListList.get(i).start();    	
        }
        
        long cT = System.currentTimeMillis();
        
        synchronized(monitor){
        		
            	while (Counter.currentCount <= 100) {
              //All threads are currently waiting, so we need to wake one random
              //thread up by calling notify on monitor. Other thread will not run yet,
              //because this thread still holds the monitor.
            	  logger.debug("MainThread  - about to notify.");
              monitor.notify();

              //Make this thread wait, which will temporarily release the monitor
              //and let the notified thread run.
	            try {
	            		logger.debug("MainThread- is about to call wait on the monitor.");
					monitor.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					logger.info("App - main program - threw a Interrupted exception.");
					e.printStackTrace();
				}
	            
	            if(Counter.currentCount ==100) {
	            		logger.info("Main thread killing itself");
	            		monitor.notify();
	            		return;
	            }
            }
         }        
    }
}
