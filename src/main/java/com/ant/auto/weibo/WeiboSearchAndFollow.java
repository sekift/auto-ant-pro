package com.ant.auto.weibo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ant.auto.Constants;
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
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		driver.navigate().to(WeiboSearchUserUrl + user);
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		driver.findElement(By.cssSelector("em.red")).click();
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
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
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
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
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
	    driver.findElement(By.linkText("【超话】"+superTalk.replaceAll("#", ""))).click();
	    SleepUtil.sleepBySecond(Constants.SPEED_TWO_MIN, Constants.SPEED_TWO_MAX);
		WebDriverOperate.switchToWindow(driver, "新浪微博超级话题", false);
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		return driver;
	}
	
	/**
	 * 点击关注超话
	 * 
	 * @param driver
	 */
	public static WebDriver followSuperTalk(WebDriver driver) {
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
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		return driver;
	}
	
	/**
	 * 超话签到
	 * 
	 * @param driver
	 */
	public static WebDriver signUpSuperTalk(WebDriver driver) {
		//20180726 因为转到页面后可能会自动滚去播放第一条视频，看不到签到按钮，因此需要滚会顶部。
		((JavascriptExecutor) driver).executeScript("scrollTo(0, 50)");
		// 还没有签到就签到
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		//driver.findElement(By.linkText("签到")).click();
		WebElement we = WebDriverOperate.getWebElement(driver, WebElementType.LinkText.toString(), "签到");
		if (null != we) {
			we.click();
		}
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		//20180726 签到后刷新本页，确认签到成功
		driver.navigate().refresh();
		SleepUtil.sleepBySecond(Constants.SPEED_TWO_MIN, Constants.SPEED_TWO_MAX);
		return driver;
	}
    
}
