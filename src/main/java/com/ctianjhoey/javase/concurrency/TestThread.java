package com.ctianjhoey.javase.concurrency;

import com.ctianjhoey.javase.concurrency.runnable.AppThread;

public class TestThread {
	public static void main(String[] args) {
		AppThread thread1 = new AppThread();
		AppThread thread2 = new AppThread();
		AppThread thread3 = new AppThread();
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
