package com.ant.auto.taobao;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.util.S;

/**
 * 淘宝登录
 * @author sekift
 *
 */
public class TaobaoLogin {
	private static final Logger logger = LoggerFactory
			.getLogger(TaobaoLogin.class);

	//手机端
	//private static final String taobaoLoginUrl_wap = "https://login.m.taobao.com/login.htm?loginFrom=wap_tb";
	//PC端
	private static final String taobaoLoginUrl = "https://login.taobao.com/member/login.jhtml";

	public static WebDriver taobaoLogin(String username, String password,
			WebDriver driver) {
		//driver.manage().window().setSize(new Dimension(700, 800));
		driver.navigate().to(taobaoLoginUrl);
		S.s2();
		driver.findElement(By.id("TPL_username_1")).sendKeys("许");//
		S.s1();
		driver.findElement(By.id("TPL_username_1")).sendKeys("少");//
		S.s1();
		driver.findElement(By.id("TPL_username_1")).sendKeys("是");//
		S.s1();
		driver.findElement(By.id("TPL_username_1")).sendKeys("大");//
		S.s1();
		driver.findElement(By.id("TPL_username_1")).sendKeys("x");//
		S.s2();
		driver.findElement(By.id("TPL_username_1")).sendKeys(Keys.TAB);//
		S.s1();
		driver.findElement(By.id("TPL_password_1")).sendKeys("s");//
		S.s1();
		driver.findElement(By.id("TPL_password_1")).sendKeys("x");//
		S.s1();
		driver.findElement(By.id("TPL_password_1")).sendKeys("k");//
		S.s1();
		driver.findElement(By.id("TPL_password_1")).sendKeys("x");//
		S.s1();
		driver.findElement(By.id("TPL_password_1")).sendKeys("");//
		S.s1();
		driver.findElement(By.id("TPL_password_1")).sendKeys("t");//
		S.s1();
		driver.findElement(By.id("TPL_password_1")).sendKeys("1");//
		S.s1();
		driver.findElement(By.id("TPL_password_1")).sendKeys("23");//
		S.s1();
		driver.findElement(By.id("TPL_password_1")).sendKeys("4");//
		S.s1();
		driver.findElement(By.id("TPL_password_1")).sendKeys("x");//
		S.s1();
		driver.findElement(By.id("J_SubmitStatic")).click();//
		S.s2();

		// 暂时没有判断是否真正登录成功，通过即成功
		if(!"淘宝网 - 淘！我喜欢".equals(driver.getTitle())){
			logger.info("登录成功，username= " + username);
		} else {
		    logger.info("登录失败，标题为：" + driver.getTitle());
		}
		S.s3();
		return driver;
	}
}
