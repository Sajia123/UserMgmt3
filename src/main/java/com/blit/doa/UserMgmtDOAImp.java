package com.blit.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.blit.model.User;
import com.blit.utils.ConnectionUtil;

public class UserMgmtDOAImp implements UserMgmtDOA {

	@Override
	public User getbyUserName(String Username) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM user;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {

				User user = new User();
				user.setId(result.getInt("id"));
				user.setUserName(result.getString("username"));
				user.setPassword(result.getString("password"));
				user.setEmail(result.getString("email"));

				return user;

			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	@Override
	public User registerUser(User user) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO users (id, username, password, email) VALUES (?,?,?,?);";
			
			
			PreparedStatement prepStatement = conn.prepareStatement(sql);
			prepStatement.setInt(1, user.getId());
			prepStatement.setString(2, user.getUserName() );
			prepStatement.setString(3, user.getPassword());
			prepStatement.setString(4,user.getEmail() );
			
			prepStatement.execute();
			
			System.out.println("created user");
		
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

}
