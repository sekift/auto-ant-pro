package com.ant.auto.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ant.auto.Constants;

/**
 * 装配浏览器
 * 
 * @author sekift
 * 
 */
public class AssembleBrowser {
	// 装配chrome浏览器
	public static WebDriver setChrome(String browserDir) {
		System.setProperty(Constants.Driver.driverChrome, browserDir);
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	// 装配chrome浏览器
	public static WebDriver setChromeAsPhone(String browserDir, String mobile) {
		System.setProperty(Constants.Driver.driverChrome, browserDir);
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		//20180315 修复BUG
		mobileEmulation.put("deviceName", mobile);// 模拟手机端
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		WebDriver driver = new ChromeDriver(capabilities);
		return driver;
	}

	// 装配firefox浏览器，带配置启动
	public static WebDriver setFirefox(String dir, String browserDir, boolean defaultConf) {
		System.setProperty(Constants.Driver.gecko, dir);
		File pathBinary = new File(browserDir);
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		if (defaultConf) {
			ProfilesIni pi = new ProfilesIni();
			firefoxProfile = pi.getProfile("default");
		}
		//20180713 取消旧写法，改用新写法
		//WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		FirefoxOptions options = new FirefoxOptions().setBinary(firefoxBinary).setProfile(firefoxProfile);
		WebDriver driver = new FirefoxDriver(options);
		return driver;
	}

	// 装配opera浏览器
	public static WebDriver setOpera(String dir, String browserDir) {
		System.setProperty(Constants.Driver.opera, dir);
		ChromeOptions options = new ChromeOptions();
		options.setBinary(browserDir);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		OperaDriver browser = new OperaDriver(capabilities);
		WebDriver driver = browser;
		return driver;
	}
}
