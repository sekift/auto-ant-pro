package com.ant.auto.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.config.XmlProperties;

public class ConfigUtil {

	private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
	
	private static XmlProperties appConfig = null;

	static {

		// Change your xml file here
		appConfig = new XmlProperties();
		appConfig.setSourceURL(ConfigUtil.class
				.getResource("/config/client.xml"));
		appConfig.setTimingReload(true);
		appConfig.initialize();
	}

	public static Object getConfigValue(String key) {
		Object result = null;
		try {
			if (appConfig != null) {
				result = appConfig.getValue(key);
			}
		} catch (Exception e) {
			logger.error("Cause a error from application properties", e);
		}
		return result;
	}

	public static String getConfigValue(String item, String key,
			String defaultValue) {
		String result = null;
		try {
			Map<?, ?> map = (Map<?, ?>) ConfigUtil.getConfigValue(item);
			result = MapUtil.getParameter(map, key, defaultValue);
		} catch (Exception e) {
			logger.error("Cause a error from application properties in second node's value", e);
		}
		return result;
	}

	public static int getIntConfigValue(String item, String key,
			int defaultValue) {
		int result = defaultValue;
		try {
			Map<?, ?> map = (Map<?, ?>) ConfigUtil.getConfigValue(item);
			result = MapUtil.getIntParameter(map, key, defaultValue);
		} catch (Exception e) {
			logger.error("Cause a error from application properties in second node's value", e);
		}
		return result;
	}
}
