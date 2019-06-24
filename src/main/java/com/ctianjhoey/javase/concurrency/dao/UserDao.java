package com.ctianjhoey.javase.concurrency.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ctianjhoey.javase.concurrency.bean.User;

public class UserDao {

	public int saveUser(User user) {
		
		int rows = 0;
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("insert into user(id,name,email) values(?,?,?)");
			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmail());
			rows = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
		
	}
}
