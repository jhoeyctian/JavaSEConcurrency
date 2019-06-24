package com.ctianjhoey.javase.concurrency.runnable;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

import com.ctianjhoey.javase.concurrency.bean.User;
import com.ctianjhoey.javase.concurrency.dao.UserDao;

public class UserRunnable implements Callable<Integer> {

	private String userRecord;
	private UserDao dao;
	
	public UserRunnable(String userRecord, UserDao dao) {
		this.userRecord = userRecord;
		this.dao = dao;
	}

	@Override
	public Integer call() throws Exception {
		int row = 0;
		System.out.println(Thread.currentThread().getName()+" processing record for " + userRecord);
		StringTokenizer tokenizer = new StringTokenizer(userRecord, ",");
		User user = null;
		while(tokenizer.hasMoreTokens()) {
			user = new User();
			user.setEmail(tokenizer.nextToken());
			user.setName(tokenizer.nextToken());
			user.setId(Integer.valueOf(tokenizer.nextToken()));
			row = dao.saveUser(user);
		}
		return row;
	}

}
