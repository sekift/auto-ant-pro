package com.ant.auto.weibo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.ant.auto.Constants;
import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.core.AssembleProperties;

/**
 * 发微博 关注用户 超话签到等
 * @author Administrator
 *
 */
public class WeiboMain {
	public static void main(String args[]) {
		WebDriver driver = null;
		List<Map<String, String>> list = AssembleProperties.loadProString(Constants.WEIBO_STR, Constants.ACCOUNT_STR);

		List<Map<String, String>> targetList = AssembleProperties.loadProString(Constants.WEIBO_TARGET_STR,
				Constants.ACCOUNT_STR);

		for (Map<String, String> map : list) {
			driver = AssembleBrowserFactory.getBrower();
			//先登录
			driver = WeiboLogin.weiboLogin(map.get(Constants.USERNAME_STR),
					 map.get(Constants.PASSWORD_STR), driver);
			//发微博
			//WeiboSend.sendTweet(driver);
			for (Map<String, String> targetMap : targetList) {
				String user = targetMap.get(Constants.USERNAME_STR);
				String superTalk = targetMap.get(Constants.PASSWORD_STR);
				//查找用户
				driver = WeiboSearchAndFollow.searchUser(map.get(Constants.USERNAME_STR), map.get(Constants.PASSWORD_STR), driver, user);
				//关注用户
				driver = WeiboSearchAndFollow.followUser(driver);
				//查找超话
				driver = WeiboSearchAndFollow.searchSuperTalk(driver, superTalk);
				//关注超话
				driver = WeiboSearchAndFollow.followSuperTalk(driver);
				//签到超话
				driver = WeiboSearchAndFollow.signUpSuperTalk(driver);
				driver.quit();
			}
		}
		driver.quit();
		driver.close();
	}
}
