package com.thoughtworks.entity;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
	M,F,U;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final Map<String, Size> genderMap = new HashMap() {{
		put("M", M);
		put("F", F);
		put("U", U);
	}};
	
	public Size getGender(String size) {
		return genderMap.get(size);
	}

}
