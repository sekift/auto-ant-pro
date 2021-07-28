package com.ant.auto.tianya;

import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.core.WebDriverOperate;
import com.ant.auto.core.WebElementType;
import com.ant.auto.util.S;

/**
 * 天涯自动点赞
 * 
 * @author sekift
 *
 */
public class TianyaZan {
	private static final Logger logger = LoggerFactory.getLogger(TianyaZan.class);

	/** 热贴版URL*/
	private static final String BBS_URL = "http://bbs.tianya.cn";
	/**  自行修改页数URL*/
	public static final String HOT_URL = "http://bbs.tianya.cn/hotArticle.jsp?pn=" + 1;
	/**  钱包页面URL*/
	private static final String WALLET_URL = "http://bei.tianya.cn/wallet/index.do";

	/**
	 * 点赞
	 *
	 * @param username
	 * @param password
	 * @param driverPre
	 */
	public static void dianZan(String username, String password, WebDriver driverPre) {
		WebDriver driver = TianyaLogin.login(username, password, driverPre);

		S.s1();
		Actions actions = new Actions(driver);
		actions.moveByOffset(1, 3).click().build().perform();

		String wd = driver.getPageSource();
		Document doc = Jsoup.parse(wd);
		Elements eles = doc.getElementsByClass("td-title").select("a");
		// 100%的能量最多只能点29次赞
		for (int i = 0; i < 33; i++) {
			String url = BBS_URL + eles.get(i).attr("href");
			// 设置为15秒
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			// 跳转到具体帖子
			driver.navigate().to(url);
			
			/**
			 * driver.findElement(By.cssSelector("a.zan")).click(); //未点赞
			 * driver.findElement(By.cssSelector("a.zan.active")).click();//已经点赞
			 * driver.findElement(By.cssSelector("#rid_11985757 >
			 * span.tuijian.hasZan > a.zan")).click();//回复点赞
			 */
			// 滚动看起来更真实
			((JavascriptExecutor) driver).executeScript("scrollTo(0, 200)");
			((JavascriptExecutor) driver).executeScript("scrollTo(0, 100)");
			S.s1();

			// 获取点赞元素
			WebElement zan = WebDriverOperate.getWebElement(driver, WebElementType.CssSelector.toString(), "a.zan");
			try {
				if (null != zan) {
					zan.click();
					logger.info("页面：" + url +" 点赞。");
				}
			} catch (WebDriverException e) {
				logger.error("[天涯点赞]出错了：" + e.getMessage());
			}
			S.s1();
		}

		// 之后跳去钱包核查
		driver.navigate().to(WALLET_URL);
		S.s1();

		// 点击天涯分
		WebElement fen = WebDriverOperate.getWebElement(driver, WebElementType.LinkText.toString(), "天涯分");
		if (null != fen) {
			fen.click();
		}
		S.s1();
		S.s3();
	}

}
