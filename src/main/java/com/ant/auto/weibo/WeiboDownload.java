package com.ant.auto.weibo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.util.SleepUtil;

public class WeiboDownload {
	// 下载周杰伦歌曲
	private static final String weiboUrl = "http://vdisk.weibo.com/s/dWVaAJ4sP93L?category_id=0";

	public static void main(String args[]) {
		WebDriver driver = AssembleBrowserFactory.getBrower();
		driver = WeiboLogin.weiboLogin("sekift@sina.com", "xxxx", driver);

		driver.navigate().to(weiboUrl);
		SleepUtil.sleepBySecond(2, 5);
		driver.findElement(By.cssSelector("body.vd_detail_page")).click();
		for (int i = 8; i < 200; i++) {
			driver.findElement(
					By.cssSelector("#file_share_list_" + i
							+ " > td.sort_select_m > input.fileListCheckbox"))
					.click();
			driver.findElement(
					By.cssSelector("#file_share_list_"
							+ i
							+ " > th.sort_set_m > span.vd_us_del.share_file_action > a.vd_pic_v2.vd_dload"))
					.click();
			SleepUtil.sleepBySecond(1, 2);
		}
	}

}
