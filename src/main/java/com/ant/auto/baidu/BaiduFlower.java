package com.ant.auto.baidu;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.Constants;
import com.ant.auto.core.AssembleProperties;
import com.ant.auto.util.JsoupUtil;
import com.ant.auto.util.SleepUtil;

/**
 * 百度给小偶像送花
 * 
 * @author Administrator
 * 
 */
public class BaiduFlower {
	private static final Logger logger = LoggerFactory
			.getLogger(BaiduFlower.class);

	// 百度送花
	public static void sendFlower(String username, String password,
			WebDriver driverPre) {
		WebDriver driver = BaiduLogin.baiduLogin(username, password, driverPre);

		Navigation navigation = driver.navigate();
		// 多个对象
		List<Map<String, String>> list = AssembleProperties.loadProString(
				Constants.BAIDU_FLOWER_STR, Constants.URL_STR);
		for (Map<String, String> map : list) {
			navigation.to(map.get(Constants.USERNAME_STR));// 手机端
			SleepUtil.sleepBySecond(1, 5);
			// 滚动
			// 2018.4.5 改版已经不用滚动,改成跳转到页面后再点了
			// ((JavascriptExecutor) driver).executeScript("scrollTo(0, 1200)");
			int maxCount = Integer.valueOf(map.get(Constants.PASSWORD_STR));
			if (maxCount > 0) {// 大于0才执行
				driver.findElement(By.id("J-send-flower")).click();
				// 点击送花，每天一共只可以送3次，所以下面是按需分配给每一个小偶像
				// 获取lemmaid
				String lemmaId = JsoupUtil.getQueryString(
						driver.getCurrentUrl(), "lemmaId");
				// 获取元素
				WebElement element = driver.findElement(By
						.xpath("//*[@data-lemmaid='" + lemmaId + "']"));
				try {
					for (int i = 0; i < maxCount; i++) {
						SleepUtil.sleepBySecond(1, 2);
						element.click();
					}
				} catch (WebDriverException e) {
					logger.error("出错了：" + e.getMessage());
				}
			}
			SleepUtil.sleepBySecond(2, 5);
		}
		SleepUtil.sleepBySecond(3, 8);
		// 直接关闭
		driver.quit();
	}
}
