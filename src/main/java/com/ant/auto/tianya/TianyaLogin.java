package com.ant.auto.tianya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.ant.auto.util.S;

/**
* tianya登录
* 
* @author sekift
*/
public class TianyaLogin {
	
	private static final String baseUrl = "https://passport.tianya.cn/";
	
	public static WebDriver login(String username, String password,
			WebDriver driver) {
	    driver.get(baseUrl + "/register/default.jsp?fowardURL=");
	    
	    Actions actions = new Actions(driver);
		actions.moveByOffset(154, 223).click().build().perform();// 点击
		S.s1();
		actions.moveByOffset(322, 445).click().build().perform();// 点击
		S.s1();
		actions.moveByOffset(523, 660).click().build().perform();// 点击
		S.s1();
		actions.moveByOffset(714, 620).click().build().perform();// 点击
		S.s1();
	    
	    driver.findElement(By.id("sign")).click();
	    driver.findElement(By.id("vwriter")).clear();
	    driver.findElement(By.id("vwriter")).sendKeys(username);
	    S.s1();
	    driver.findElement(By.id("vpassword")).clear();
	    driver.findElement(By.id("vpassword")).sendKeys(password);
	    S.s1();
	    driver.findElement(By.id("loginBtn")).click();
	    S.s1();
	    
		return driver;
	}

}
