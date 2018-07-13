package com.ant.auto.core;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.Constants;
import com.ant.auto.util.StringUtil;

public class AssembleBrowserFactory {
	private static final Logger logger = LoggerFactory
			.getLogger(AssembleBrowserFactory.class);

	private static Map<String, Map<String, String>> driverMap = AssembleProperties
			.loadProMapMap(Constants.DRIVER);
	private static Map<String, String> browserDirMap = AssembleProperties
			.loadProMap(Constants.BROWSER_DIR);

	public static WebDriver getBrower() {
		WebDriver driver = null;
		String dir = null;
		String browserDir = null;
		for (String name : driverMap.keySet()) {
			Map<String, String> m = driverMap.get(name);
			if (Boolean.valueOf(m.get(Constants.USE))) {
				if (Constants.CHROME.equals(name)) {
					String mobile = m.get(Constants.MOBILE);
					dir = browserDirMap.get(Constants.CHROME_DIR);
					if(StringUtil.isNullOrBlank(mobile)){
						driver = AssembleBrowser.setChrome(dir);
					}else{
						driver = AssembleBrowser.setChromeAsPhone(dir, mobile);
					}
				} else if (Constants.FIREFOX.equals(name)) {
					dir = browserDirMap.get(Constants.FIREFOX_GECKO_DIR);
					String option = m.get(Constants.OPTION);
					if (Constants.NEW.equals(option)) {
						browserDir = browserDirMap
								.get(Constants.FIREFOX_BROWSER_DIR);
					} else {
						browserDir = browserDirMap
								.get(Constants.FIREFOX_OLD_BROWSER_DIR);
					}
					driver = AssembleBrowser.setFirefox(dir, browserDir, false);
				} else if (Constants.OPERA.equals(name)) {
					dir = browserDirMap.get(Constants.OPERA_DRIVER_DIR);
					browserDir = browserDirMap.get(Constants.OPERA_BROWSER_DIR);
					driver = AssembleBrowser.setOpera(dir, browserDir);
				}
				break;
			}
		}
		if (null == driver) {
			try {
				String message = "浏览器装配出错了，请检查配置！";
				logger.error(message);
				throw new Exception(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}

}
