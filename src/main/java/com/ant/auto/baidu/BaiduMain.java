package com.ant.auto.baidu;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.ant.auto.Constants;
import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.core.AssembleProperties;

public class BaiduMain {
	public static void main(String args[]) {
		WebDriver driver = null;
		List<Map<String, String>> list = AssembleProperties.loadProString(
				Constants.BAIDU_STR, Constants.ACCOUNT_STR);
		for (Map<String, String> map : list) {
			driver = AssembleBrowserFactory.getBrower();
			BaiduSignUp.signUpRun(map.get(Constants.USERNAME_STR), map.get(Constants.PASSWORD_STR), driver);
			//BaiduFlower.sendFlower(map.get(Constants.USERNAME_STR), map.get(Constants.PASSWORD_STR), driver);
			
			// 直接关闭
			driver.close();
			driver.quit();
		}
		driver.close();
		driver.quit();
	}
}
