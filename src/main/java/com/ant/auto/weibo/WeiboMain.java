package com.ant.auto.weibo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.ant.auto.Consts;
import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.core.AssembleProperties;
import com.ant.auto.util.KillProcess;

/**
 * 发微博 关注用户 超话签到等
 * @author Administrator
 *
 */
public class WeiboMain {
	public static void main(String[] args) {
		WebDriver driver = null;
		List<Map<String, String>> list = AssembleProperties.loadProString(Consts.WEIBO_STR, Consts.ACCOUNT_STR);

		List<Map<String, String>> targetList = AssembleProperties.loadProString(Consts.WEIBO_TARGET_STR,
				Consts.ACCOUNT_STR);

		for (Map<String, String> map : list) {
			driver = AssembleBrowserFactory.getBrower();
			//先登录
			WeiboLogin.weiboLogin(map.get(Consts.USERNAME_STR),
					map.get(Consts.PASSWORD_STR), driver);
			//发微博
			//WeiboSend.sendTweet(driver);
			for (Map<String, String> targetMap : targetList) {
				String user = targetMap.get(Consts.USERNAME_STR);
				String superTalk = targetMap.get(Consts.PASSWORD_STR);
				//查找用户
				WeiboSearchAndFollow.searchUser(map.get(Consts.USERNAME_STR), map.get(Consts.PASSWORD_STR), driver, user);
				//关注用户
				WeiboSearchAndFollow.followUser(driver);
				//查找超话
				WeiboSearchAndFollow.searchSuperTalk(driver, superTalk);
				//关注超话
				WeiboSearchAndFollow.followSuperTalk(driver);
				//签到超话
				WeiboSearchAndFollow.signUpSuperTalk(driver);
				KillProcess.quit(driver);
			}
		}
		KillProcess.quit(driver);
	}
}
