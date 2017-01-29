package com.cts.controller;

import com.cts.model.Users;
import com.google.gson.Gson;

public class GsonToJson {

	
	public static void main(String[] args) {
		Users users = new Users();
		users.setPassword("ahihai");
		users.setPassword("dadaprjq");
		users.setUsername("fdankfda");
		users.setUsername("sahdka");
		GsonToJson gs = new GsonToJson();
		gs.jsonConvertor(users);
		
	}
	public String jsonConvertor(Users users) {

		Gson gson = new Gson();
		String json = gson.toJson(users);
		System.out.println(json);
		return json;

	}

}
