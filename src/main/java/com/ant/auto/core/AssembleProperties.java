package com.ant.auto.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.Consts;
import com.ant.auto.util.ConfigUtil;

/**
 * 装配配置
 * 
 * @author sekift
 * 
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class AssembleProperties {
	private static final Logger logger = LoggerFactory
			.getLogger(AssembleProperties.class);
	/**
	 * 多个map类型
	 */
	public static Map<String, String> loadProMap(String configValue){
		return (Map) ConfigUtil.getConfigValue(configValue);
	}
	
	public static Map<String, Map<String, String>> loadProMapMap(String configValue){
		return (Map) ConfigUtil.getConfigValue(configValue);
	}
	
	/**
	 * 账号、账号密码类型
	 * @param configValue
	 * @param value
	 * @return
	 */
	public static List<Map<String, String>> loadProString(String configValue,
			String value) {
		Map map = (Map) ConfigUtil.getConfigValue(configValue);
		List<Map<String, String>> list = new ArrayList<>();
		List<String> accountList = new ArrayList<>();
		// 如果account只有一个，那么
		if (map != null && map.size() > 0) {
			Object obj = map.get(value);
			if (obj instanceof String) {
				accountList.add((String) obj);
			} else if (obj instanceof List) {
				accountList = (List<String>) obj;
			} else {
				logger.error("配置加载失败，请检查类型。");
			}
			logger.info("配置加载成功。");
		} else {
			logger.error("配置加载失败，请检查。");
		}
		try {
			if (accountList.size() > 0) {
				for (String str : accountList) {
					Map<String, String> resultMap = new HashMap<>(8);
					// 判断是否有密码
					if (!str.contains(Consts.ACCOUNT_SEPARATOR)) {
						resultMap.put(Consts.TARGET_STR, str);
					} else {
						String[] mapArray = str
								.split(Consts.ACCOUNT_SEPARATOR);
						resultMap.put(Consts.USERNAME_STR, mapArray[0]);
						resultMap.put(Consts.PASSWORD_STR, mapArray[1]);
					}
					list.add(resultMap);
				}
			}
		} catch (Exception e) {
			logger.error("配置解析错误", e);
		}
		return list;
	}
}
