package com.ctianjhoey.javase.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ctianjhoey.javase.concurrency.custom.CustomThreadFactory;
import com.ctianjhoey.javase.concurrency.runnable.LoggingProcessor;

public class TestThreadFactory {
	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(3, new CustomThreadFactory());
		for (int i = 0; i < 6; i++) {
			service.submit(new LoggingProcessor());
		}
		
	}
}
