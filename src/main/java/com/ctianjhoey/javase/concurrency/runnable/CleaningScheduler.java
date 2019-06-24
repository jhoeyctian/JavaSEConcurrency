package com.ctianjhoey.javase.concurrency.runnable;

import java.io.File;

public class CleaningScheduler implements Runnable {

	@Override
	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		File file = new File("D:\\serverlog");
		File[] files = file.listFiles();
		for (File f : files) {
			if(System.currentTimeMillis() > 5*60*1000) {
				System.out.println("deleting "+ f.getName());
//				f.delete();
			}
		}
	}

}
