package com.ant.auto.weibo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ant.auto.core.WebDriverOperate;
import com.ant.auto.core.WebElementType;
import com.ant.auto.util.S;

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
		S.s1();
		driver.navigate().to(WeiboSearchUserUrl + user);
		S.s1();
		driver.findElement(By.cssSelector("em.red")).click();
		S.s1();
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
		S.s1();
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
		S.s1();
	    driver.findElement(By.linkText("【超话】"+superTalk.replaceAll("#", ""))).click();
	    S.s2();
		WebDriverOperate.switchToWindow(driver, "新浪微博超级话题", false);
		S.s1();
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
		S.s1();
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
		S.s1();
		//driver.findElement(By.linkText("签到")).click();
		WebElement we = WebDriverOperate.getWebElement(driver, WebElementType.LinkText.toString(), "签到");
		if (null != we) {
			we.click();
		}
		S.s1();
		//20180726 签到后刷新本页，确认签到成功
		driver.navigate().refresh();
		S.s2();
		return driver;
	}
    
}
