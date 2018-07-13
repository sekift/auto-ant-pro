package com.ant.auto.util;
import java.util.Map;

/**
 * Map Util
 * 
 * @author:sekift
 * @time:2016-5-13 下午04:20:45
 * @version:
 */
public class MapUtil {

	public static boolean getBooleanParameter(Map<?,?> params, String name, boolean defaultVal) {
		boolean value = defaultVal;
		try {
			String temp = params.get(name).toString();
			if ("true".equals(temp) || "on".equals(temp)) {
				return true;
			} else if ("false".equals(temp) || "off".equals(temp)) {
				return false;
			}
		} catch (Exception e) {
		}
		return value;
	}

	public static double getDoubleParameter(Map<?,?> params, String name, double defaultNum) {
		double num = defaultNum;
		try {
			Object temp = params.get(name);
			if (temp != null && !temp.equals("")) {
				num = Double.parseDouble(temp.toString());
			}
		} catch (Exception e) {
		}
		return num;
	}

	public static int getIntParameter(Map<?,?> params, String name, int defaultNum) {
		int num = defaultNum;
		try {
			Object temp = params.get(name);
			if (temp != null) {
				num = Integer.parseInt(temp.toString());
			}
		} catch (Exception ignored) {
		}
		return num;
	}

	public static long getLongParameter(Map<?,?> params, String name, long defaultNum) {
		long num = defaultNum;
		try {
			Object temp = params.get(name);
			if (temp != null) {
				num = Long.parseLong(temp.toString());
			}
		} catch (Exception ignored) {
		}
		return num;
	}

	public static String getParameter(Map<?,?> params, String name, String defaultValue) {
		String value = defaultValue;
		try {
			Object temp = params.get(name);
			if (temp != null) {
				value = temp.toString();
			}
		} catch (Exception e) {
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getTParameter(Map<?,?> params, String name, T defaultValue) {
		T value = defaultValue;
		try {
			Object temp = params.get(name);
			if (temp != null) {
				value = (T) temp;
			}
		} catch (Exception e) {
		}
		return value;
	}
}
