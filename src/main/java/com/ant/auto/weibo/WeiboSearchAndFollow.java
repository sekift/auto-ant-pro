package com.ant.auto.weibo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ant.auto.core.WebDriverOperate;
import com.ant.auto.core.WebElementType;
import com.ant.auto.util.SleepUtil;

/**
 * 微博搜索并关注
 * 
 * @author sekift
 *
 */
public class WeiboSearchAndFollow {
	private static final String WeiboSearchUserUrl = "http://s.weibo.com/user/";
	private static final String WeiboSearchSuperTalkUrl = "http://s.weibo.com/weibo/";
	/**
	 * 搜索用户，默认取第一个用户，因为是全称匹配
	 * 
	 * @param username
	 * @param password
	 * @param driverDis
	 */
	public static WebDriver searchUser(String username, String password, WebDriver driver, String user) {
		SleepUtil.sleepBySecond(3, 5);
		driver.navigate().to(WeiboSearchUserUrl + user);
		SleepUtil.sleepBySecond(3, 5);
		driver.findElement(By.cssSelector("em.red")).click();
		SleepUtil.sleepBySecond(5, 10);
		return driver;
	}

	/**
	 * 点击关注用户
	 * 
	 * @param driver
	 */
	public static WebDriver followUser(WebDriver driver) {
		// 如果还没有关注先关注
		WebDriverOperate.switchToWindow(driver, "的微博_微博", false);
		WebElement we = WebDriverOperate.getWebElement(driver, WebElementType.LinkText.toString(), "+关注");

		if (null != we) {
			we.click();
		}
		/**
		 * driver.findElement(By.linkText("+关注")).click();
		 * driver.findElement(By.linkText("Y已关注")).click();
		 * driver.findElement(By.linkText("取消关注")).click();
		 */
		SleepUtil.sleepBySecond(2, 5);
		return driver;
	}
	
	/**
	 * 搜索话题
	 * 
	 * @param username
	 * @param password
	 * @param driverDis
	 */
	public static WebDriver searchSuperTalk(WebDriver driver, String superTalk) {
		try {
			driver.navigate().to(WeiboSearchSuperTalkUrl + URLEncoder.encode(superTalk, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SleepUtil.sleepBySecond(3, 5);
	    driver.findElement(By.linkText("【超话】"+superTalk.replaceAll("#", ""))).click();
		SleepUtil.sleepBySecond(5, 10);
		return driver;
	}
	
	/**
	 * 点击关注超话
	 * 
	 * @param driver
	 */
	public static WebDriver followSuperTalk(WebDriver driver) {
		WebDriverOperate.switchToWindow(driver, "新浪微博超级话题", false);
		SleepUtil.sleepBySecond(2, 4);
		// 如果还没有关注先关注
		WebElement we = WebDriverOperate.getWebElement(driver, WebElementType.LinkText.toString(), "+关注");

		if (null != we) {
			we.click();
		}
		/**
		 * driver.findElement(By.linkText("+关注")).click();
		 * driver.findElement(By.linkText("Y已关注")).click();
		 * driver.findElement(By.linkText("取消关注")).click();
		 */
		SleepUtil.sleepBySecond(3, 7);
		return driver;
	}
	
	/**
	 * 超话签到
	 * 
	 * @param driver
	 */
	public static WebDriver signUpSuperTalk(WebDriver driver) {
		// 还没有签到就签到
		WebElement we = WebDriverOperate.getWebElement(driver, WebElementType.LinkText.toString(), "签到");
		if (null != we) {
			we.click();
		}
		SleepUtil.sleepBySecond(5, 10);
		return driver;
	}
    
}
