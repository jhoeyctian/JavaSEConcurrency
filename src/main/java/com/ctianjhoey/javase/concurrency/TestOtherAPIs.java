package com.ctianjhoey.javase.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.ctianjhoey.javase.concurrency.runnable.LoggingProcessor;

public class TestOtherAPIs {
	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(2);
		List<Callable<Boolean>> callables = new ArrayList<>();
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		callables.add(new LoggingProcessor());
		
		try {
			//invoke all in the collection
			List<Future<Boolean>> futures = service.invokeAll(callables);
			for (Future<Boolean> future : futures) {
				try {
					System.out.println("result "+ future.get());
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		//invoke any & not all could be only 1 or 4 or any no. of task
		try {
			System.out.println(service.invokeAny(callables));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		//will not accept additional task but will continue with already started tasks
		service.shutdown();
		try {
			//makes sure all tasks that has already started will be completed
			System.out.println("service shutdown? : "+service.awaitTermination(10, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			//rude way of shutting down
			//will terminate all tasks regardless if it is terminated or still running
			service.shutdownNow();
		}
	}
}
