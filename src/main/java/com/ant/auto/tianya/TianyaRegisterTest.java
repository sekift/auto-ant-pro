package com.ant.auto.tianya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ant.auto.Constants;
import com.ant.auto.core.AssembleBrowser;
import com.ant.auto.util.SendMessageTool;
import com.ant.auto.util.SleepUtil;

public class TianyaRegisterTest {
	public static void main(String[] args) {
		WebDriver driver = AssembleBrowser.setChrome(Constants.Driver.driverChromeDir);

		String baseUrl = "https://passport.tianya.cn";
		driver.get(baseUrl
				+ "/register/default.jsp?sourceURL=http://www.tianya.cn");
		SleepUtil.sleepBySecond(3, 6);
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys("abc");
		driver.findElement(By.cssSelector("div.header.clearfix")).click();
		SleepUtil.sleepBySecond(3, 6);
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys("abc12");
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys("abc1789");
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys("abc123490");
		driver.findElement(By.id("userName")).clear();
		SleepUtil.sleepBySecond(3, 6);
		driver.findElement(By.id("userName")).sendKeys("御afefew");
		driver.findElement(By.cssSelector("div.header.clearfix")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("awfe");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.id("get_mobile_vcode")).click();
		SleepUtil.sleepBySecond(3, 6);
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys("18688483843");
		driver.findElement(By.id("get_mobile_vcode")).click();
		//SleepUtil.sleepBySecond(6, 12);
		//driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		//给一分钟时间接收短信
		SleepUtil.sleepBySecond(40, 60);
		driver.findElement(By.id("mobileVcode")).clear();
		//获取短信验证码
		String code = SendMessageTool.getMessageByRemoteSMS();
		driver.findElement(By.id("mobileVcode")).sendKeys(code);
		SleepUtil.sleepBySecond(5, 8);
		driver.findElement(By.id("register_btn")).click();
		SleepUtil.sleepBySecond(5, 9);
		//driver.findElement(By.cssSelector("body")).click();
		driver.findElement(By.partialLinkText("跳过")).click();
		SleepUtil.sleepBySecond(10, 20);
		driver.quit();
	}
}
