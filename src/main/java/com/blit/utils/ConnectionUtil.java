package com.blit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
private static Connection conn;
	
	public static Connection getConnection() throws SQLException {
		if(conn!=null && !conn.isClosed()) {
			return conn;
		}else {
			/*
			 * Various frameworks require registering the driver 
			 * for JDBC to work. This tells the program at runtime where
			 * the appropriate driver is for the connection. 
			 */
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			String url = 
					"jdbc:mysql://javafs240103.cvwwqwgsk9os.us-east-1.rds.amazonaws.com:3306/usermgmt";
			String username = "admin";
			String password = "password"; 
			
			conn = DriverManager.getConnection(url, username, password);
		}
		return conn;
	}
	
	/*
	 * public static void main(String[] args) throws Exception { Connection conn =
	 * ConnectionUtil.getConnection(); }
	 */

}
