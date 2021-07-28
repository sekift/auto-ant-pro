package com.ant.auto.weibo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.ant.auto.util.S;

/**
 * 发微博
 * @author sekift
 *
 */
public class WeiboSend {
	public static void sendTweet(WebDriver driver) {
		Actions actions = new Actions(driver);
		// 点击空白
		actions.moveByOffset(0, 0).click().build().perform();
		driver.findElement(By.cssSelector("textarea.W_input")).clear();
		S.s1();
		driver.findElement(By.cssSelector("textarea.W_input")).sendKeys(
				"你好啊！");
		S.s1();
		driver.findElement(By.linkText("发布")).click();
		S.s1();
		driver.navigate()
				.to("http://weibo.com/");
		S.s2();
	}
}
