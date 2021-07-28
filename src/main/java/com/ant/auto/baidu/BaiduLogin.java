package com.ant.auto.baidu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.util.S;

/**
 * 百度登录
 * @author sekift
 *
 */
public class BaiduLogin {
	private static final Logger logger = LoggerFactory
			.getLogger(BaiduLogin.class);

	private static final String BAIDU_LOGIN_URL = "https://wappass.baidu.com/passport/?"
			+ "login&tpl=wimn&ssid%3D0%26amp%3B"
			+ "from%3D844b%26amp%3Buid%3D%26amp%3Bpu%3Dsz%25401320_2001%252Cta%2540"
			+ "iphone_1_11.0_3_602%26amp%3Bbd_page_type%3D1&tn=&regtype=1"
			+ "&u=https%3A%2F%2Fm.baidu.com";

	public static WebDriver baiduLogin(String username, String password,
			WebDriver driver) {
		driver.navigate().to(BAIDU_LOGIN_URL);
		S.s1();
		driver.findElement(By.id("login-username")).sendKeys(username);
		S.s1();
		driver.findElement(By.id("login-password")).sendKeys(password);
		S.s1();
		driver.findElement(By.id("login-submit")).click();
		S.s1();

		// 可能的手机、邮箱或钱包绑定银行卡验证（开启登录保护才有）
		try {
			WebElement we = driver.findElement(By.partialLinkText("跳过"));
			//noinspection EqualsBetweenInconvertibleTypes
			if (we != null && !"".equals(we)) {
				we.click();
			}
		} catch (Exception e) {
			logger.info("[baidu登录]不需要跳过");
		}
		// 暂时没有判断是否真正登录成功，通过即成功
		logger.info("登录成功，username= " + username);
		S.s1();
		return driver;
	}
}
