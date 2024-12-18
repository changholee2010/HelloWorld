package com.yedam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.jdbc.ReplyDAO;

public class AppTest {
	public static void main(String[] args) {
		ReplyDAO rdao = new ReplyDAO();
		Map<String, String> inputVal = new HashMap<>();
		inputVal.put("title", "입력테스트");
		inputVal.put("start", "2024-12-01");
		inputVal.put("end", "2024-12-03");

		rdao.insertEvent(inputVal);

		List<Map<String, Object>> result = rdao.calendarData();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);

		System.out.println(json);
	}
}
