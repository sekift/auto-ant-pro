package com.ant.auto.taobao;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.ant.auto.Constants;
import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.core.AssembleProperties;
import com.ant.auto.util.KillProcess;

public class TaobaoMain {
	public static void main(String args[]) {
		WebDriver driver = null;
		List<Map<String, String>> list = AssembleProperties.loadProString(
				Constants.TAOBAO_STR, Constants.ACCOUNT_STR);
		for (Map<String, String> map : list) {
			driver = AssembleBrowserFactory.getBrower();
			TaobaoLogin.taobaoLogin(map.get(Constants.USERNAME_STR), map.get(Constants.PASSWORD_STR), driver);
			KillProcess.quit(driver);
		}
		KillProcess.quit(driver);
	}
}
