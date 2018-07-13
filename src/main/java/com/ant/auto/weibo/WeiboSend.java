package com.ant.auto.weibo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.ant.auto.util.SleepUtil;

/**
 * 发微博
 * @author sekift
 *
 */
public class WeiboSend {
	public static void sendTweet(String username, String password, WebDriver driverDis) {
		WebDriver driver = WeiboLogin.weiboLogin(username, password, driverDis);
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 0).click().build().perform();// 点击空白
		driver.findElement(By.cssSelector("textarea.W_input")).clear();
		SleepUtil.sleepBySecond(1, 3);
		driver.findElement(By.cssSelector("textarea.W_input")).sendKeys(
				"http://www.bubbt.com/btc/pan 云车站");
		SleepUtil.sleepBySecond(3, 5);
		driver.findElement(By.linkText("发布")).click();
		SleepUtil.sleepBySecond(2, 4);
		driver.navigate()
				.to("http://weibo.com/");
		SleepUtil.sleepBySecond(2, 5);
	}
}
