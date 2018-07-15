package com.ant.auto;

import java.util.Map;

import com.ant.auto.core.AssembleProperties;

public class RunMain {
	public static void main(String args[]) {
		Map<String, Map<String,String>> map = AssembleProperties.loadProMapMap("driver");
		for(String name : map.keySet()){
			Map<String,String> m = map.get(name);
			if(Boolean.valueOf(m.get("use"))){
				System.out.println(name);
				System.out.println(m.get("mobile"));
			}
		}
	}
}
