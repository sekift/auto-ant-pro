package com.ant.auto.toutiao;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.Consts;
import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.core.AssembleProperties;
import com.ant.auto.util.KillProcess;
import com.ant.auto.util.SleepUtil;
/**
 *
 * @author sekift
 */
public class ToutiaoMain {
	private static final Logger logger = LoggerFactory
			.getLogger(ToutiaoMain.class);

	public static void main(String[] args) {
		WebDriver driver = null;
		int type = 2;
		String chargeType = null;
		if ( Consts.SHARE_WEIBO == type) {
			chargeType = Consts.WEIBO_STR;
		} else if ( Consts.SHARE_QQ == type) {
			chargeType = Consts.QQ_STR;
		}
		List<Map<String, String>> list = AssembleProperties.loadProString(chargeType,
				Consts.ACCOUNT_STR);
		List<Map<String, String>> targetList = AssembleProperties.loadProString(
				Consts.TOUTIAO_TARGET_STR, Consts.ACCOUNT_STR);
		for (Map<String, String> map : list) {
			driver = AssembleBrowserFactory.getBrower();
			//尺寸不能缩小，要不看不见
			driver = ToutiaoLogin.ttLogin(map.get(Consts.USERNAME_STR),
					map.get(Consts.PASSWORD_STR), driver, type);
			for (Map<String, String> targetMap : targetList) {
				ToutiaoViewFollow.viewFollow(driver,
						targetMap.get(Consts.TARGET_STR));
				ToutiaoOperate.operateTarget(driver, type);
			}
			logger.info(map.get(Consts.USERNAME_STR) + " 已经完成任务。");
			SleepUtil.sleepByMinute(3, 5);
			KillProcess.quit(driver);
		}
		KillProcess.quit(driver);
	}
}
