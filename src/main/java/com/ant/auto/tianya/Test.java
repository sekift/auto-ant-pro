package com.ant.auto.tianya;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ant.auto.Constants;
import com.ant.auto.core.AssembleBrowser;
import com.ant.auto.util.SleepUtil;

public class Test {
	public static void main(String[] args) {
		WebDriver driver = AssembleBrowser.setChrome(Constants.Driver.driverChromeDir);
		String baseUrl = "http://192.168.65.97";
		for (int i = 0; i < 20; i++) {
			long time = System.currentTimeMillis();
			driver.get(baseUrl + "/mytest/postTest/reg.jsp?t=" + time);
			String source = driver.getPageSource();
			Document doc = Jsoup.parse(source);
			System.out.println(time + " " + i
					+ " " +doc.getElementById("tok").val());
			SleepUtil.sleepBySecond(1, 1);
			driver.findElement(By.name("uName")).clear();
			driver.findElement(By.name("uName")).sendKeys(time+"");
			driver.findElement(By.cssSelector("input[type=\"submit\"]"))
					.click();
			source = driver.getPageSource();
			doc = Jsoup.parse(source);
			System.out.println(time + " " + i
					+ " " +doc.getElementsByTag("body").text());
			// SleepUtil.sleepBySecond(1, 1);
		}
		SleepUtil.sleepBySecond(5, 10);
		driver.quit();
	}
}
