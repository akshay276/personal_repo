package com.cts.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.daoImpl.UserDaoImpl;
import com.cts.model.Users;
import com.cts.service.UserService;

public class NgServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public NgServlet() {
		System.out.println("Inside Servlet Constructor");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/*
		 * System.out.println("Inside GET Servlet");
		 * 
		 * Users u = new Users(); UserDaoImpl udi = new UserDaoImpl(); try { u =
		 * udi.fetchUserDetail(u); System.out.println(u);
		 * System.out.println("Password is :::" + u.getPassword()); } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } response.getWriter().write(u.getPassword());
		 */
		// ---------------//

		boolean flag = false;
		String uname = request.getParameter("userName");
		String pwd = request.getParameter("passWord");
		String email = request.getParameter("emailId");
		int empId = Integer.parseInt(request.getParameter("empId"));

		System.out.println("values in doGet method: " + uname + pwd + email
				+ empId);
		Users users = new Users();
		users.setUsername(uname);
		users.setPassword(pwd);
		users.setEmail(email);
		users.setEmpId(empId);

		System.out.println("set'd all values into Users");
		UserService service = new UserService();
		try {
			flag = service.insertUserDetail(users);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (flag) {
			System.out.println("inside if condition servlet");
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.sendError(402);
		}

		// ---------------//

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Inside POST Servlet");
		Users users = new Users();
		UserService service = new UserService();
		GsonToJson gj = new GsonToJson();
		boolean flag = false;
		String json = "";
		String uname = request.getParameter("userName");
		String pwd = request.getParameter("passWord");

		System.out.println("In Servlet- uname: " + uname + "  " + "pass: "
				+ pwd);

		users.setUsername(uname);
		users.setPassword(pwd);
		System.out
				.println("After setting pwd and Uname in Servlet:   " + users);

		try {
			flag = service.getUserDetails(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (flag == true) {
			System.out.println("Inside If condition of Servlet");
			System.out.println(" Data in Users Now:- " + users.getUsername());
			json = gj.jsonConvertor(users);
			response.setContentType("application/json");
			response.getWriter().write(json);
			response.setStatus(200);
		} else {

			System.out.println("Inside else condition of Servlet");
			response.sendError(400);
		}

	}
}