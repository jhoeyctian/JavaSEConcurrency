package com.ctianjhoey.javase.concurrency.custom;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

	private static int counter = 0;
	
	
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName("Custom Name - "+ (++counter));
		return thread;
	}

}
