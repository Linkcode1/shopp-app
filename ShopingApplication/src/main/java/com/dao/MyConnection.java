package com.dao;

import java.sql.*;

public class MyConnection {

	public Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/shopping";
			String uname = "root";
			String pass = "12345678";
			
			con = DriverManager.getConnection(url,uname,pass);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
		
		
	}
}
