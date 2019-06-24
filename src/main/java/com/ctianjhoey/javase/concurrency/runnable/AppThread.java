package com.ctianjhoey.javase.concurrency.runnable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppThread extends Thread {

	@Override
	public void run() {

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

	}

}
