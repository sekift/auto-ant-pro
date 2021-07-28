package com.ant.auto.core;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.Consts;
import com.ant.auto.util.StringUtil;

/**
* 自动装配浏览器工厂
* 
* @author sekift
*/
public class AssembleBrowserFactory {
	private static final Logger logger = LoggerFactory
			.getLogger(AssembleBrowserFactory.class);

	private static Map<String, Map<String, String>> driverMap = AssembleProperties
			.loadProMapMap(Consts.DRIVER);
	private static Map<String, String> browserDirMap = AssembleProperties
			.loadProMap(Consts.BROWSER_DIR);

	public static WebDriver getBrower() {
		WebDriver driver = null;
		String dir = null;
		String browserDir = null;
		for (String name : driverMap.keySet()) {
			Map<String, String> m = driverMap.get(name);
			if (Boolean.valueOf(m.get(Consts.USE))) {
				if (Consts.CHROME.equals(name)) {
					String mobile = m.get(Consts.MOBILE);
					dir = browserDirMap.get(Consts.CHROME_DIR);
					if(StringUtil.isNullOrBlank(mobile)){
						driver = AssembleBrowser.setChrome(dir);
					}else{
						driver = AssembleBrowser.setChromeAsPhone(dir, mobile);
					}
				} else if (Consts.FIREFOX.equals(name)) {
					dir = browserDirMap.get(Consts.FIREFOX_GECKO_DIR);
					String option = m.get(Consts.OPTION);
					if (Consts.NEW.equals(option)) {
						browserDir = browserDirMap
								.get(Consts.FIREFOX_BROWSER_DIR);
					} else {
						browserDir = browserDirMap
								.get(Consts.FIREFOX_OLD_BROWSER_DIR);
					}
					driver = AssembleBrowser.setFirefox(dir, browserDir, false);
				} else if (Consts.OPERA.equals(name)) {
					dir = browserDirMap.get(Consts.OPERA_DRIVER_DIR);
					browserDir = browserDirMap.get(Consts.OPERA_BROWSER_DIR);
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
