package com.cts.controller;

import com.google.gson.Gson;

public class json {

	public static String gsonToJson() {

		String[] s = { "ACCOUNT DETAILS", "CHANGE PASSWORD","REQUEST ACCESS","HISTORY" };

		Gson gs = new Gson();
		String json = gs.toJson(s);
		System.out.println(json);
		return json;

	}

}
