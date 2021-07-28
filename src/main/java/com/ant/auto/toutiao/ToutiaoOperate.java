package com.ant.auto.toutiao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.Consts;
import com.ant.auto.core.WebDriverOperate;
import com.ant.auto.core.WebElementType;
import com.ant.auto.util.S;

/**
 * 包括点赞、收藏、评论、转发等功能
 * 
 * @author Administrator
 * 
 */
public class ToutiaoOperate {
	private static final Logger logger = LoggerFactory
			.getLogger(ToutiaoOperate.class);

	public static void operateTarget(WebDriver driver, int type) {
		/**
		 * 打开第一篇文章li[1] //div/ul/li[1]/div/div/div/div/a
		 */
		S.s1();
		String firstArticle = "//div/ul/li[1]/div/div/div/div/a";
		// 文章的title
		String titleStr = WebDriverOperate.getWebElement(driver,
				WebElementType.Xpath.toString(), firstArticle).getText();
		driver.findElement(By.xpath(firstArticle)).click();
		S.s1();
		// 切换到第一篇文章
		WebDriverOperate.switchToWindow(driver, titleStr,false);
		// 左右切换 driver.findElement(By.cssSelector("ul.tab.tab-1 > li")).click();
		// 暂时用不到

		S.s3();
		// 关注
		/**
		 * unsubscribe 未关注 subscribe 已关注
		 */
		boolean isFollow = false;
		if (isFollow) {
			String unsubscribe = "div.article-unsubscribe.left-arrow > span";
			String followed = WebDriverOperate.getWebElement(
					driver,WebElementType.CssSelector.toString() , unsubscribe).getText();
			if (!"".equals(followed)) {
				driver.findElement(By.cssSelector(unsubscribe)).click();
			}
		}
		S.s1();
		
		Actions actions = new Actions(driver);
		// 点击
		actions.moveByOffset(154, 223).click().build().perform();
		S.s1();
		actions.moveByOffset(322, 445).click().build().perform();
		S.s1();
		actions.moveByOffset(523, 660).click().build().perform();
		S.s1();
		actions.moveByOffset(714, 620).click().build().perform();
		S.s1();
		// 收藏 有bug 重复点击会去掉收藏
		/**
		 * y-icon icon-favorite 未收藏 
		 * y-icon icon-favorite repin 收藏
		 */
		String favorite = "i.y-icon.icon-favorite";
		try {
			driver.findElement(By.cssSelector(favorite)).click();
		} catch (Exception e) {
			logger.warn("已经收藏");
		}

		// 评论 评论不打算开发

		// 分享
		if (Consts.SHARE_WEIBO == type) {
			// 转发到微博
			shareWeibo(driver, titleStr);
		} else if (Consts.SHARE_QQ == type) {
			// 转发到朋友圈
			shareQQ(driver, titleStr);
		}

	}

	// 转发到微博
	public static void shareWeibo(WebDriver driver, String titleStr) {
		/**
		 * assertEquals("分享到微博-微博-随时随地分享身边的新鲜事儿", driver.getTitle());
		 * driver.findElement(By.id("shareIt")).click();
		 */
		//String shareWeibo = "div.share-type > span";
		//driver.findElement(By.cssSelector(shareWeibo)).click();
		driver.findElement(By.cssSelector("i.icon-sina")).click();
		// 打开了新的小窗口
		S.s1();
		// 跳转到
		String shareWeiboTile = "分享到微博-微博-随时随地分享身边的新鲜事儿";
		WebDriverOperate.switchToWindow(driver, shareWeiboTile, false);
		S.s1();
		// 转发 默认点赞
		// TODO 微博必须实名认证才继续进行，待修复BUG
		driver.findElement(By.id("shareIt")).click();
		S.s2();
		WebDriverOperate.switchToWindow(driver, titleStr, false);

		S.s2();

		//TODO 转发完应该关闭小窗口，并回到原窗口

	}

	// 转发到QQ空间
	public static void shareQQ(WebDriver driver, String titleStr) {
		/**
		 * assertEquals("分享到微博-微博-随时随地分享身边的新鲜事儿", driver.getTitle());
		 * driver.findElement(By.id("shareIt")).click();
		 */
		String shareQQ = "i.y-icon.icon-qzone";
		driver.findElement(By.cssSelector(shareQQ)).click();
		// 打开了新的窗口-》跳转到
		String shareQQTile = "分享到QQ空间和朋友网";
		WebDriverOperate.switchToWindow(driver, shareQQTile, false);
		S.s1();
		// 转发
		driver.findElement(By.cssSelector("span.btn_s1_h28_r")).click();
		S.s2();
		WebDriverOperate.switchToWindow(driver, titleStr, false);

		S.s2();

		//TODO 转发完应该关闭小窗口，并回到原窗口
	}
}
