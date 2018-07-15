package com.ant.auto.weibo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.ant.auto.Constants;
import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.core.AssembleProperties;

public class WeiboMain {
	public static void main(String args[]) {
		WebDriver driver = null;
		List<Map<String, String>> list = AssembleProperties.loadProString(
				Constants.WEIBO_STR, Constants.ACCOUNT_STR);
		for (Map<String, String> map : list) {
			driver = AssembleBrowserFactory.getBrower();
			WeiboSend.sendTweet(map.get(Constants.USERNAME_STR),
					map.get(Constants.PASSWORD_STR), driver);
			driver.quit();
		}
		driver.quit();
		driver.close();
	}
}
