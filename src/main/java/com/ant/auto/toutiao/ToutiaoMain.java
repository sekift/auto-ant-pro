package com.ant.auto.toutiao;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.Constants;
import com.ant.auto.core.AssembleBrowser;
import com.ant.auto.core.AssembleProperties;
import com.ant.auto.util.SleepUtil;

public class ToutiaoMain {
	private static final Logger logger = LoggerFactory
			.getLogger(ToutiaoMain.class);

	public static void main(String args[]) {
		WebDriver driver = null;
		int type = 2;
		String chargeType = null;
		if ( Constants.SHARE_WEIBO == type) {
			chargeType = Constants.WEIBO_STR;
		} else if ( Constants.SHARE_QQ == type) {
			chargeType = Constants.QQ_STR;
		}
		List<Map<String, String>> list = AssembleProperties.loadProString(chargeType,
				Constants.ACCOUNT_STR);
		List<Map<String, String>> targetList = AssembleProperties.loadProString(
				Constants.TOUTIAO_TARGET_STR, Constants.ACCOUNT_STR);
		for (Map<String, String> map : list) {
			driver = AssembleBrowser.setChrome(Constants.Driver.driverChromeDir);
			//尺寸不能缩小，要不看不见
			driver = ToutiaoLogin.ttLogin(map.get(Constants.USERNAME_STR),
					map.get(Constants.PASSWORD_STR), driver, type);
			for (Map<String, String> targetMap : targetList) {
				driver = ToutiaoViewFollow.viewFollow(driver,
						targetMap.get(Constants.TARGET_STR));
				ToutiaoOperate.operateTarget(driver, type);
			}
			logger.info(map.get(Constants.USERNAME_STR) + " 已经完成任务。");
			SleepUtil.sleepByMinute(3, 5);
			driver.close();
			driver.quit();
		}
	}
}
