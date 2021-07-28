package com.ant.auto.tianya;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.ant.auto.Consts;
import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.core.AssembleProperties;
import com.ant.auto.util.KillProcess;

/**
 * @author sekift
 */
public class TianyaMain {
	public static void main(String[] args) {
		WebDriver driver = null;
		List<Map<String, String>> list = AssembleProperties.loadProString(
				Consts.TIANYA_STR, Consts.ACCOUNT_STR);
		for (Map<String, String> map : list) {
			driver = AssembleBrowserFactory.getBrower();
			TianyaZan.dianZan(map.get(Consts.USERNAME_STR), map.get(Consts.PASSWORD_STR), driver);
			KillProcess.quit(driver);
		}
		KillProcess.quit(driver);
	}
}
