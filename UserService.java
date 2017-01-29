package com.cts.service;

import java.sql.SQLException;

import com.cts.daoImpl.UserDaoImpl;
import com.cts.model.Users;

public class UserService {

	public boolean getUserDetails(Users users) throws SQLException {

		String userName = users.getUsername();
		String passWord = users.getPassword();
		boolean flag = false;
		System.out.println("In getUserDetails UserName: " + userName
				+ "  Password is : " + passWord);
		UserDaoImpl daoImpl = new UserDaoImpl();

		users = daoImpl.fetchUserDetail(users);
		String pwd = users.getPassword();
		System.out.println("Entered password from UI: " + passWord);
		System.out.println("PWD FROM DAOIMPL: " + pwd);
		UserService service = new UserService();
		flag = service.passwordMatcher(passWord, pwd);
		return flag;

	}

	public boolean insertUserDetail(Users users) throws SQLException {
		boolean flag = false;
		UserDaoImpl daoImpl = new UserDaoImpl();
		flag = daoImpl.insertUserDetail(users);
		return flag;
	}

	public boolean passwordMatcher(String pass, String pwd) {

		boolean flag = false;
		if (pass.equals(pwd)) {

			flag = true;
		}
		System.out.println("In password Matcher Flag is: " + flag);

		return flag;
	}
}