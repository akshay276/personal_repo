package com.cts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NgJsonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public NgJsonServlet() {
		System.out.println("Inside Servlet Constructor");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Inside Servlet");

		String json = " [{\"name\":\"John\",\"title\":\"Programmer Analyst\",\"Fiends\":[ \"Ford\", \"BMW\", \"Fiat\" ]},{\"name\":\"Akshay\",\"title\":\"Associate\",\"cars\":[ \"Hero\", \"Bajaj\", \"Honda\" ]}] ";
		System.out.println(json);

		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write(json);

	}

}