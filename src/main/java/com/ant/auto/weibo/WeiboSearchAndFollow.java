package com.ant.auto.weibo;

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
	public static void searchUser(String username, String password, WebDriver driver, String user) {
		driver.navigate().to(WeiboSearchUserUrl + user);
		SleepUtil.sleepBySecond(3, 5);
		driver.findElement(By.cssSelector("em.red")).click();
		SleepUtil.sleepBySecond(5, 10);
	}

	/**
	 * 点击关注用户
	 * 
	 * @param driver
	 */
	public static void followUser(WebDriver driver) {
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
		SleepUtil.sleepBySecond(5, 10);
	}
	
	/**
	 * 搜索用户，默认取第一个用户，因为是全称匹配
	 * 
	 * @param username
	 * @param password
	 * @param driverDis
	 */
	public static void searchSuperTalk(WebDriver driver, String superTalk) {
		driver.navigate().to(WeiboSearchSuperTalkUrl + superTalk);
		SleepUtil.sleepBySecond(3, 5);
	    driver.findElement(By.linkText("【超话】"+superTalk.replaceAll("#", ""))).click();
		SleepUtil.sleepBySecond(5, 10);
	}
	
	/**
	 * 点击关注超话
	 * 
	 * @param driver
	 */
	public static void followSuperTalk(WebDriver driver) {
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
		SleepUtil.sleepBySecond(5, 10);
	}
	
	/**
	 * 超话签到
	 * 
	 * @param driver
	 */
	public static void signUpSuperTalk(WebDriver driver) {
		// 还没有签到就签到
		WebElement we = WebDriverOperate.getWebElement(driver, WebElementType.LinkText.toString(), "签到");

		if (null != we) {
			we.click();
		}
		//driver.findElement(By.cssSelector("a.W_btn_b.btn_32px> span")).click();
		SleepUtil.sleepBySecond(5, 10);
	}
    
}
