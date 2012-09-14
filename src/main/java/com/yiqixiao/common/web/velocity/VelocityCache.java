package com.yiqixiao.common.web.velocity;

import java.util.HashMap;
import java.util.Map;

public class VelocityCache {

	private static Map<String, Boolean> velocityCache = new HashMap<String, Boolean>();

	public static Boolean hasLayout(String path) {
		return velocityCache.get(path);
	}

	public static void markLayoutExist(String layoutPath) {
		velocityCache.put(layoutPath, Boolean.TRUE);

	}

	public static void markLayoutNonExist(String layoutPath) {
		velocityCache.put(layoutPath, Boolean.FALSE);

	}

}
