package com.ant.auto.tianya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.ant.auto.Constants;
import com.ant.auto.core.AssembleBrowser;
import com.ant.auto.util.SleepUtil;

public class LoginTest {
	private static final String baseUrl = "https://passport.tianya.cn/";
	public static void main(String args[]){
		WebDriver driver = AssembleBrowser.setChrome(Constants.Driver.driverChromeDir);
		
	    driver.get(baseUrl + "/register/default.jsp?fowardURL=");
//	    assertEquals("天涯社区账号_注册", driver.getTitle());
	    
	    Actions actions = new Actions(driver);
		actions.moveByOffset(154, 223).click().build().perform();// 点击
		SleepUtil.sleepBySecond(1, 4);
		actions.moveByOffset(322, 445).click().build().perform();// 点击
		SleepUtil.sleepBySecond(1, 4);
		actions.moveByOffset(523, 660).click().build().perform();// 点击
		SleepUtil.sleepBySecond(1, 4);
		actions.moveByOffset(714, 620).click().build().perform();// 点击
		SleepUtil.sleepBySecond(1, 4);
	    
	    driver.findElement(By.id("sign")).click();
	    driver.findElement(By.id("vwriter")).clear();
	    driver.findElement(By.id("vwriter")).sendKeys("东皇战影");
	    SleepUtil.sleepBySecond(5, 8);
	    driver.findElement(By.id("vpassword")).clear();
	    driver.findElement(By.id("vpassword")).sendKeys("访问纷纷为");
	    SleepUtil.sleepBySecond(5, 8);
	    driver.findElement(By.id("loginBtn")).click();
//	    assertEquals("登录中......", driver.getTitle());
//	    assertEquals("登录中......", driver.getTitle());
//	    assertEquals("东皇战影_天涯社区", driver.getTitle());
	    
	    SleepUtil.sleepBySecond(30, 40);
	    driver.quit();
	}

}
