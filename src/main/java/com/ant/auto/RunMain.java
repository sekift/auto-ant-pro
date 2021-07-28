package com.ant.auto;

import java.util.List;
import java.util.Map;

import com.ant.auto.core.AssembleProperties;

/**
 * @author sekift
 */
public class RunMain {
	public static void main(String[] args) {
		Map<String, Map<String, String>> map = AssembleProperties.loadProMapMap("driver");
		for (String name : map.keySet()) {
			Map<String, String> m = map.get(name);
			if (Boolean.valueOf(m.get("use"))) {
				System.out.println(name);
				System.out.println(m.get("mobile"));
			}
		}

		List<Map<String, String>> targetList = AssembleProperties.loadProString(Consts.WEIBO_TARGET_STR,
				Consts.ACCOUNT_STR);
		for (Map<String, String> targetMap : targetList) {
			System.out.println(targetMap);
		}
	}
}
