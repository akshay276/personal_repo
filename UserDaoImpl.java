package com.cts.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import com.cts.dao.DBConnector;
import com.cts.dao.UserDao;
import com.cts.model.Users;

public class UserDaoImpl implements UserDao {

	/*
	 * public static void main(String[] args) throws SQLException { UserDaoImpl
	 * u = new UserDaoImpl();
	 * 
	 * Users users = u.fetchUserDetail("akshay"); String pass =
	 * users.getPassword(); String name = users.getUsername();
	 * System.out.println(name + " " + pass); }
	 */
	@Override
	public Users fetchUserDetail(Users users) throws SQLException {

		Connection conn = null;
		String pwd = null;
		Statement stmt = null;
		ResultSet rs = null;

		DBConnector dbConnector = new DBConnector();
		try {
			 String uName = users.getUsername();
			 System.out.println("USERNAME FROM POJO: "+ uName);
			//String uName = "akshay";
			conn = dbConnector.getConnection();
			stmt = conn.createStatement();

			String drlGetUserDetail = "Select PASSWORD from USERS where USERNAME='"
					+ uName + "'";
			System.out.println("SQL IS:: " + drlGetUserDetail);
			rs = stmt.executeQuery(drlGetUserDetail);

			while (rs.next()) {
				pwd = rs.getString(1);
				System.out.println("In FetchUserDetail Password is: " + pwd);
			}

			users.setPassword(pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}

			if (conn != null) {
				conn.close();
			}

		}

		return users;
	}

	@Override
	public boolean insertUserDetail(Users users) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnector dbConnector = new DBConnector();
		try {
			conn = dbConnector.getConnection();

			String dmlInsertUserDetail = "INSERT into USERS () values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(dmlInsertUserDetail);
			pstmt.setString(1, users.getUsername());
			pstmt.setString(2, users.getPassword());
			pstmt.setString(3, users.getEmail());
			pstmt.setInt(4, users.getEmpId());
			pstmt.setTimestamp(5, getCurrentTimeStamp());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

			if (conn != null) {
				conn.close();
			}

		}
		return true;
	}

	private static Timestamp getCurrentTimeStamp() {

		Date today = new java.util.Date();
		System.out.println("today is : " + today);
		return new Timestamp(today.getTime());

	}

}
