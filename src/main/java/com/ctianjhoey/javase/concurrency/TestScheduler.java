package com.ctianjhoey.javase.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ctianjhoey.javase.concurrency.runnable.CleaningScheduler;

public class TestScheduler {
	public static void main(String[] args) {
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		//where the schedule will run after 5 seconds
//		service.schedule(new CleaningScheduler(), 5, TimeUnit.SECONDS);
		
		//where the schedule will start after 5 seconds
		//where after the first schedule, the task will run every 3 seconds
//		service.scheduleAtFixedRate(new CleaningScheduler(), 5, 3, TimeUnit.SECONDS);
		
		//where the schedule will start after 5 seconds
		//where after the first schedule, the task will run only after the last task is completed
		//this method makes sure and/or waits for the complete execution of the previous task
		//safer than schedule with fixed rate
		service.scheduleWithFixedDelay(new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);
	}
}
