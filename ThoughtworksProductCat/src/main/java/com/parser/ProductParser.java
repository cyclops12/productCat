package com.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.thoughtworks.entity.Product;

public class ProductParser {
	public static Map<Integer, Product> parseProduct(String json){
		Map<Integer, Product> productMap = new HashMap<>();
		JSONParser parser = new JSONParser();
		try {
			JSONArray array = (JSONArray) parser.parse(json);
			
			/*
			 * parse
			 */
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return productMap;
		
	}
}
