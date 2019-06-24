package com.ctianjhoey.javase.concurrency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.ctianjhoey.javase.concurrency.dao.UserDao;
import com.ctianjhoey.javase.concurrency.runnable.UserRunnable;

public class TestExecutors {
	public static void main(String[] args) {
		
		//if you want to use only one thread
//		ExecutorService service = Executors.newSingleThreadExecutor();
		//if you want to use more threads depending on the no. of tasks
//		ExecutorService service = Executors.newCachedThreadPool();
		//if you want fixed no. of threads
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		List<String> users = getUsersFromFile("C:\\Users\\jhoey\\Desktop\\"
				+ "Ex_Files_Java_EE_Concurrency\\Ex_Files_Java_EE_Concurrency"
				+ "\\Exercise Files\\Chapter3\\03_07\\begin\\javaseconcurrency"
				+ "\\new_users.txt");
		
		UserDao dao = new UserDao();
		
		for(String user:users) {
			try {
				//all future objects must be completed before reaching the SYSO line below
				Future<Integer> future = service.submit(new UserRunnable(user, dao));
				System.out.println("result of the operation is "+ future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			
			//this code can reach/call the SYSO line below even if the other threads are not yet terminated
//			service.submit(new UserRunnable(user, dao));

		}
		
		service.shutdown();
		
		//this line will not be called until all future objects are complete
		System.out.println("Main execution over!");
		System.out.println();
	}
	
	public static List<String> getUsersFromFile(String fileName) {
		List<String> userList = new ArrayList<>();
		
		try (BufferedReader bufferReader = new BufferedReader(
				new FileReader(new File(fileName)))) {

			String line = null;
			while ((line = bufferReader.readLine()) != null) {
				userList.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return userList;
	}
}
