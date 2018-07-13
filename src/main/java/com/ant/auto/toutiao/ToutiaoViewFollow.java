package com.ant.auto.toutiao;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.core.WebDriverOperate;
import com.ant.auto.core.WebElementType;
import com.ant.auto.util.SleepUtil;

/**
 * 这个类的目的是登录后从首页切换到关注列表中来， 并挑选需要打开的用户（就是配置中的toutiao_target）
 * 
 * @author Administrator
 * 
 */
public class ToutiaoViewFollow {
	private static final Logger logger = LoggerFactory
			.getLogger(ToutiaoViewFollow.class);

	private static final String titlePro = "的头条主页";

	public static WebDriver viewFollow(WebDriver driver, String target) {
		// 点入我的主页
		//String userHeadSpanStr = "a.user-head > span";//
		String userHeadSpanStr = "p.name > a > span";
		String numberIStr = "em.y-number > i";
		/*String userHead = WebDriverOperate.getStringTextByCssSelector(driver,
				userHeadSpanStr);*/
		WebElement userHead = WebDriverOperate.getWebElement(driver,
				WebElementType.Class.toString(), userHeadSpanStr);
		// 跳转到关注页
		driver.findElement(By.cssSelector(userHeadSpanStr)).click();
		SleepUtil.sleepBySecond(1, 3);

		// 切换到新打开的窗口
		driver = WebDriverOperate.switchToWindow(driver, userHead + titlePro, false);
		SleepUtil.sleepBySecond(1, 3);
		String number = driver.findElement(By.cssSelector(numberIStr))
				.getText();
		int followSum = Integer.valueOf(number);
		// 此处待完善，如果这个人没有被关注，而关注的另外有人，这种情况没有考虑
		if (followSum == 0) {
			logger.warn(userHead + " 此号没有关注人，请先关注。");

			// 先转去搜索并关注
			driver = searchAndFollow(driver, target, userHead + titlePro);
		}
		SleepUtil.sleepBySecond(1, 3);

		// 跳转到关注详情栏
		driver.findElement(By.cssSelector(numberIStr)).click();
		SleepUtil.sleepBySecond(1, 3);
		/**
		 * 关注列表 第一个 driver.findElement(By.cssSelector("a > h3")).click();
		 * 第二个driver
		 * .findElement(By.xpath("//li[@id='table']/ul/li[2]/dl/dd[2]/a/h3"
		 * )).click(); 第三个 driver.findElement(By.xpath(
		 * "//li[@id='table']/ul/li[3]/dl/dd[2]/a/h3")).click();
		 * 
		 */
		int targetNum = 1; //默认第一个
		String pathPre = "//li[@id='table']/ul/li[";
		String pathPro = "]/dl/dd[2]/a/h3";
		for (int i = 1; i <= followSum; i++) {
			if (target.equals(driver.findElement(
					By.xpath(pathPre + i + pathPro)).getText())) {
				targetNum = i;
				break;
			}
		}

		// 接下来可以跳转到target主页去操作了
		// 打开
		driver.findElement(By.xpath(pathPre + targetNum + pathPro)).click();

		// 切换
		driver = WebDriverOperate.switchToWindow(driver, target + titlePro, false);
		return driver;
	}

	/**
	 * 没有关注的先搜索并关注，然后再返回自己的页面
	 * 
	 * @param driver
	 * @return
	 */
	public static WebDriver searchAndFollow(WebDriver driver, String target,
			String targetTitle) {
		String searchTitle = "头条搜索";
		driver.findElement(By.name("keyword")).click();
		driver.findElement(By.name("keyword")).clear();
		driver.findElement(By.name("keyword")).sendKeys(target);
		SleepUtil.sleepBySecond(1, 3);
		// 错误
		// driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		// 改用回车键代替
		driver.findElement(By.name("keyword")).sendKeys(Keys.ENTER);
		SleepUtil.sleepBySecond(1, 2);
		//转到
		driver = WebDriverOperate.switchToWindow(driver, searchTitle, false);
		SleepUtil.sleepBySecond(3, 5);
		driver.findElement(By.cssSelector("div.subscribe.subscribe-active"))
				.click();
		logger.info("关注成功，target=" + target);
		// 取消关注
		// driver.findElement(By.cssSelector("div.subscribe.")).click();
		// 跳回去并刷新
		SleepUtil.sleepBySecond(1, 3);
		driver = WebDriverOperate.switchToWindow(driver, targetTitle, false);
		driver.navigate().refresh();
		SleepUtil.sleepBySecond(1, 3);
		return driver;
	}

}
