package com.thoughtworks.products;

import java.util.HashMap;
import java.util.Map;

public enum Size {
	M,S,L;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static final Map<String, Size> sizeMap = new HashMap() {{
		put("M", M);
		put("S", S);
		put("L", L);
	}};
	
	public Size getSize(String size) {
		return sizeMap.get(size);
	}
}
