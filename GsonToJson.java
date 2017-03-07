package com.cts.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GsonToJson {

	public String getJson() {
		BufferedReader br = null;
		FileReader fr = null;

		String FILENAME = "C:\\Users\\Dell\\workspace\\ExcelReader\\WebContent\\data\\50.json";
		String json = null;
		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				json = sCurrentLine;
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		return json;

	}

	public static void main(String[] args) {
		GsonToJson gj = new GsonToJson();
		String json  = gj.getJson();
		System.out.println(json);
	}
}
