package com.ant.auto.core;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 窗口切换
 * 
 * @author Administrator
 * 
 */
public class WebDriverOperate {
	private static final Logger logger = LoggerFactory
			.getLogger(WebDriverOperate.class);

	/**
	 * 根据title切换窗口--模糊匹配
	 * 
	 * @param driver
	 * @param windowTitle
	 * @return
	 */
	public static WebDriver switchToWindow(WebDriver driver, String windowTitle, boolean full) {
		try {
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String s : handles) {
				if (s.equals(currentHandle)) {
					continue;
				} else {
					driver.switchTo().window(s);
					boolean t = false;
					if(full){
						t = driver.getTitle().equals(windowTitle);
					} else {
						t = driver.getTitle().contains(windowTitle);
					}
					if (t) {
						logger.info("转到窗口: " + windowTitle + " 成功！");
						break;
					} else {
						continue;
					}
				}
			}
		} catch (NoSuchWindowException e) {
			logger.error("窗口: " + windowTitle + " 未能找到！", e.fillInStackTrace());
		}
		return driver;
	}

	/**
	 * 下一个窗口
	 * 
	 * @param dr
	 * @return
	 */
	public static WebDriver switchWindows(WebDriver dr) {
		WebDriver window;
		String currentWindow = dr.getWindowHandle();
		Set<String> handles = dr.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next())
				continue;
			window = dr.switchTo().window(it.next());
			return window;
		}
		return null;
	}
	
	/**
	 * 获取web元素
	 * 
	 * @param driver
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */
	public static WebElement getWebElement(WebDriver driver,
			String locatorType, String locatorValue) {
		WebElement result = null;
		try {
			result = driver.findElement(getObjectLocator(locatorType,
					locatorValue));
		} catch (Exception e) {
			logger.warn("页面 " + driver.getCurrentUrl() + ",使用" + locatorType
					+ ",获取元素 " + locatorValue + ",不存在，请注意！");
		}
		return result;
	}

	/**
	 * 根据对象库中的Value来获取By的值
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */
	private static By getObjectLocator(String locatorType, String locatorValue) {
		By locator = null;
		if (locatorType.contains(WebElementType.Id.toString())) {
			locator = By.id(locatorValue);
		} else if (locatorType.contains(WebElementType.Name.toString())) {
			locator = By.name(locatorValue);
		} else if (locatorType.contains(WebElementType.Class.toString())) {
			locator = By.className(locatorValue);
		} else if (locatorType.contains(WebElementType.Xpath.toString())) {
			locator = By.xpath(locatorValue);
		} else if (locatorType.contains(WebElementType.CssSelector.toString())) {
			locator = By.cssSelector(locatorValue);
		} else if (locatorType.contains(WebElementType.LinkText.toString())) {
			locator = By.linkText(locatorValue);
		} else if (locatorType.contains(WebElementType.PartialLinkText.toString())) {
			locator = By.partialLinkText(locatorValue);
		} else if (locatorType.contains(WebElementType.Tag.toString())) {
			locator = By.tagName(locatorValue);
		}
		return locator;
	}

	public void fullMethod() {
		WebDriver driver = new FirefoxDriver();
		// 前进
		driver.navigate().forward();
		// 后退
		driver.navigate().back();
	}
}
