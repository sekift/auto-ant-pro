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
	
	private static final String BASE_URL = "https://passport.tianya.cn/";
	
	public static WebDriver login(String username, String password,
			WebDriver driver) {
	    driver.get(BASE_URL + "/register/default.jsp?fowardURL=" + TianyaZan.HOT_URL);
	    
	    Actions actions = new Actions(driver);
		// 随机点击
		actions.moveByOffset(154, 20).click().build().perform();
		S.s1();
		actions.moveByOffset(322, 115).click().build().perform();
		S.s1();
		actions.moveByOffset(123, 82).click().build().perform();
		S.s1();
		actions.moveByOffset(21, 220).click().build().perform();
		S.s1();
	    
	    driver.findElement(By.id("sign")).click();
	    S.s1();
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
