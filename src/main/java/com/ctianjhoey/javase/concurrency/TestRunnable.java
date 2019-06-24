package com.ctianjhoey.javase.concurrency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestRunnable {
	public static void main(String[] args) {
		
		
		Runnable runnable = () -> {
			
			try (BufferedReader bufferReader = new BufferedReader(
					new FileReader(new File("C:\\Users\\jhoey\\Desktop\\Ex_Files_Java_EE_Concurrency"
							+ "\\Ex_Files_Java_EE_Concurrency\\Exercise Files\\Chapter2"
							+ "\\02_03\\begin\\sample.txt")))) {

				String line = null;
				while ((line = bufferReader.readLine()) != null) {
					System.out.println(Thread.currentThread().getName() + " is reading line " + line);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		};
		
		//using simple runnable
		/*
		 * Thread thread = new Thread(runnable); thread.start();
		 */
		
		//EXECUTOR FRAMEWORK
		//1. using executor interface
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(runnable);
		
		
		
		
	}
}
