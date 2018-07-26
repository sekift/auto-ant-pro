package com.ant.auto.toutiao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.Constants;
import com.ant.auto.core.WebDriverOperate;
import com.ant.auto.core.WebElementType;
import com.ant.auto.util.SleepUtil;

/**
 * 头条登录
 * 
 * @author sekift
 *
 */
public class ToutiaoLogin {
	private static final Logger logger = LoggerFactory.getLogger(ToutiaoLogin.class);
	private static final String toutiaoUrl = "http://www.toutiao.com";

	/**
	 * 头条登录 type的作用是区分微博还是qq：1 微博，2 qq
	 * 
	 * @param username
	 * @param password
	 * @param type
	 * @return
	 */
	public static WebDriver ttLogin(String username, String password, WebDriver driver, int type) {
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to(toutiaoUrl);
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		// 点击跳到登录
		// driver.findElement(By.cssSelector("div.nav-login > a")).click();// >
		// span
		driver.findElement(By.linkText("登录")).click();
		/**
		 * 1再点击去到具体微博/qq登录授权登录 2使用手机或者邮箱可能需要验证码
		 */
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		if (Constants.SHARE_WEIBO == type) {
			// 微博
			driver.findElement(By.cssSelector("li.sns.weibo-login")).click();
			SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
			driver = weiboOauth(username, password, driver);
		} else if (Constants.SHARE_QQ == type) {
			// qq Firefox（49.0.2）下有问题，跳不转 原因是js加载错误
			driver.findElement(By.cssSelector("li.sns.qq-login")).click();
			SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
			driver = qqOauth(username, password, driver);
		}

		// 登录后 1最近授权过，无需再点击授权；2 点击授权
		// 首先判断是否已经登录

		// 20180315 授权bug修复
		// WebDriverOperate.getWebElementByClassName(driver,
		// "a.WB_btn_oauth.formbtn_01");
		// WebElement oauthButton =
		// WebDriverOperate.getWebElementByCssSelector(driver,
		// "a.WB_btn_oauth.formbtn_01");
		WebElement oauthButton = WebDriverOperate.getWebElement(driver, WebElementType.CssSelector.toString(),
				"a.WB_btn_oauth.formbtn_01");
		if (oauthButton != null) {
			oauthButton.click();
		}

		// 去到 授权如果是502，可能是oauth的问题，可以直接去到主页
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		driver.navigate().to(toutiaoUrl);
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);

		// 判断真实是否已经登录, 已经改变
		// 20180315 获取用户名bug修复
		// String userHead =
		// WebDriverOperate.getStringTextByCssSelector(driver,"p.name > a >
		// span");
		String userHead = WebDriverOperate
				.getWebElement(driver, WebElementType.CssSelector.toString(), "p.name > a > span").getText();
		if (null == userHead || "".equals(userHead)) { // "".equals(userHeadSpan)
														// &&
			logger.error("登录失败了，请检查！");
			SleepUtil.sleepBySecond(Constants.SPEED_THR_MIN, Constants.SPEED_THR_MAX);
			driver.quit();
			return null;
		}
		// 登录成功
		logger.info("账号 " + userHead + " 登录成功！");
		return driver;
	}

	/**
	 * 微博授权
	 * 
	 * @param username
	 * @param password
	 * @param driver
	 * @return
	 */
	private static WebDriver weiboOauth(String username, String password, WebDriver driver) {
		// 首先判断是否已经登录
		// WebElement webEle =
		// WebDriverOperate.getWebElementByClassName(driver,"account_name");
		WebElement webEle = WebDriverOperate.getWebElement(driver, WebElementType.Class.toString(), "account_name");

		// 未登录，有两种选择 1去WeiboLogin登录再返回授权界面，
		// 2直接在本页登录（如果是本页登录需要验证码那么去引用登录）
		if (webEle == null) {
			// 本页登录
			driver.findElement(By.id("userId")).clear();
			driver.findElement(By.id("userId")).sendKeys(username);
			SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
			driver.findElement(By.id("passwd")).clear();
			driver.findElement(By.id("passwd")).sendKeys(password);
			SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
			driver.findElement(By.cssSelector("a.WB_btn_login.formbtn_01")).click();
			SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);

			// 第一次可能有验证码
			// 引用登录 就是去到WeiboLogin登录然后再返回这个授权页面 暂时不提供
		}
		return driver;
	}

	/**
	 * qq授权
	 * 
	 * @param username
	 * @param password
	 * @param driver
	 * @return
	 */
	private static WebDriver qqOauth(String username, String password, WebDriver driver) {
		// 首先判断是否已经登录
		WebElement webEle = WebDriverOperate.getWebElement(driver, WebElementType.Class.toString(), "account_name");
		if (webEle == null) {
			// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// 切换到iframe内部
			driver.switchTo().frame("ptlogin_iframe");
			SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
			driver.findElement(By.id("switcher_plogin")).click();
			SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
			driver.findElement(By.id("u")).clear();
			driver.findElement(By.id("u")).sendKeys(username);
			SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
			driver.findElement(By.id("p")).clear();
			driver.findElement(By.id("p")).sendKeys(password);
			SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);

			/**
			 * 验证码？很久未登录才需要验证码 判断验证码---接入打码机
			 */
			driver.findElement(By.id("login_button")).click();
			SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
		}
		return driver;
	}
}
