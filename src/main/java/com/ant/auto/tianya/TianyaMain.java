package com.ant.auto.tianya;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.ant.auto.Constants;
import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.core.AssembleProperties;

public class TianyaMain {
	public static void main(String args[]) {
		WebDriver driver = null;
		List<Map<String, String>> list = AssembleProperties.loadProString(
				Constants.TIANYA_STR, Constants.ACCOUNT_STR);
		for (Map<String, String> map : list) {
			driver = AssembleBrowserFactory.getBrower();
			TianyaZan.dianZan(map.get(Constants.USERNAME_STR), map.get(Constants.PASSWORD_STR), driver);
			driver.close();
		}
		driver.close();
		driver.quit();
	}
}
