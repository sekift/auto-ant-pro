package com.ant.auto.weibo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.ant.auto.Constants;
import com.ant.auto.util.SleepUtil;

/**
 * 发微博
 * @author sekift
 *
 */
public class WeiboSend {
	public static void sendTweet(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 0).click().build().perform();// 点击空白
		driver.findElement(By.cssSelector("textarea.W_input")).clear();
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		driver.findElement(By.cssSelector("textarea.W_input")).sendKeys(
				"http://www.bubbt.com/btc/pan 云车站");
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		driver.findElement(By.linkText("发布")).click();
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		driver.navigate()
				.to("http://weibo.com/");
		SleepUtil.sleepBySecond(Constants.SPEED_TWO_MIN, Constants.SPEED_TWO_MAX);
	}
}
