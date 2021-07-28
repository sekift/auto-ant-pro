package com.ant.auto.weibo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.util.S;

/**
 * 微博登录
 * @author sekift
 *
 */
public class WeiboLogin {
	private static final Logger logger = LoggerFactory
			.getLogger(WeiboLogin.class);
	private static final String WEIBO_URL = "http://weibo.com/";

	/**
	 * weibo登录
	 *
	 * @param username
	 * @param password
	 * @param driver
	 * @return
	 */
	static void weiboLogin(String username, String password, WebDriver driver) {
		Navigation navigation = driver.navigate();
		navigation.to(WEIBO_URL);
		S.s2();

		driver.findElement(By.id("loginname")).clear();
		driver.findElement(By.id("loginname")).sendKeys(username);
		S.s1();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		S.s1();
		driver.findElement(
				By.xpath("//div[@id='pl_login_form']/div/div[3]/div[6]/a/span"))
				.click();

		if ("微博-随时随地发现新鲜事".equals(driver.getTitle())
				|| "我的首页 微博-随时随地发现新鲜事".equals(driver.getTitle())) {
			logger.info("weibo登录成功，username=" + username);
		} else if ("兴趣推荐 微博-随时随地发现新鲜事".equals(driver.getTitle())) {
			// 推荐需要点击 进入微博
			driver.findElement(By.cssSelector("a.W_btn_big > span")).click();
			logger.info("weibo登录成功，username=" + username);
		} else {
			logger.info("weibo登录失败，username=" + username);
		}
		S.s1();
	}
}
