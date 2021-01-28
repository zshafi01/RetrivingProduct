package com.simplilearn.workshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	// create a reference for a Connection
		private Connection connection;
		
		public Connection getConnection(String url, String username, String password){
			//it takes username and passwoed and db url
			//create a connection
			//1.Register JDBC driver
			 try {
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				connection = DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			//return a connection
			return connection;
		}
		
		
		
		
//		//create a constructor
//		public DatabaseConnection(String url , String user, String password) throws ClassNotFoundException, SQLException{
//			// step #1 . load a JDBC Driver
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			//step #2 : obtain a Connection object to control database
//			this.connection = DriverManager.getConnection(url, user, password);
//		}
//		
//		public Connection getConnection() {
//			return connection;
//		}
//		
//		
//		public void closeConnection() throws SQLException {
//			if (this.connection != null){
//				this.connection.close();
//			}
//		}

}
