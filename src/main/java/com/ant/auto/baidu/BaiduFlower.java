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

import com.ant.auto.Consts;
import com.ant.auto.core.AssembleProperties;
import com.ant.auto.util.JsoupUtil;
import com.ant.auto.util.S;

/**
 * 百度给小偶像送花
 * 
 * @author Administrator
 * 
 */
public class BaiduFlower {
	private static final Logger logger = LoggerFactory
			.getLogger(BaiduFlower.class);

	/**
	 * 百度送花
	 *
	 * @param username
	 * @param password
	 * @param driverPre
	 */
	public static void sendFlower(String username, String password,
			WebDriver driverPre) {
		WebDriver driver = BaiduLogin.baiduLogin(username, password, driverPre);

		Navigation navigation = driver.navigate();
		// 多个对象
		List<Map<String, String>> list = AssembleProperties.loadProString(
				Consts.BAIDU_FLOWER_STR, Consts.URL_STR);
		for (Map<String, String> map : list) {
			// 手机端
			navigation.to(map.get(Consts.USERNAME_STR));
			S.s1();
			// 滚动
			// 2018.4.5 改版已经不用滚动,改成跳转到页面后再点了
			// ((JavascriptExecutor) driver).executeScript("scrollTo(0, 1200)");
			int maxCount = Integer.valueOf(map.get(Consts.PASSWORD_STR));
			// 大于0才执行
			if (maxCount > 0) {
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
						S.s1();
						element.click();
					}
				} catch (WebDriverException e) {
					logger.error("出错了：" + e.getMessage());
				}
			}
			S.s1();
		}
		S.s2();
		// 直接关闭
		driver.quit();
	}
}
