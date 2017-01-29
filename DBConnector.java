package com.cts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	// This method will return connection Object to be used every time.
	public Connection getConnection() throws SQLException {

		Connection conn = null;
		try {
			System.out.println("Inside try of getConnection");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("After loading mySQLdriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inside getConnection():  " + conn);
		return conn;

	}
	/*
	 * public static void main(String[] args) throws SQLException { DBConnector
	 * db = new DBConnector();
	 * 
	 * System.out.println(db.getConnection()); }
	 */
}
