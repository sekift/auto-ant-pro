package com.ant.auto;

public class Constants {
	// 驱动
	public interface Driver {
		// chrome驱动
		String driverChrome = "webdriver.chrome.driver";
		// gecko驱动
		String gecko = "webdriver.gecko.driver";
		//opera驱动
		String opera = "webdriver.opera.driver";
	}

	// 账号分割
	public static final String ACCOUNT_SEPARATOR = "----";
	
	//配置关键字
	public static final String USERNAME_STR = "username"; 
	public static final String PASSWORD_STR = "password"; 

	public static final String BAIDU_STR = "baidu"; 
	public static final String WEIBO_STR = "weibo"; 
	public static final String ACCOUNT_STR = "account"; 
	public static final String TARGET_STR = "target"; 
	public static final String TOUTIAO_TARGET_STR = "toutiao_target"; 
	public static final String WEIBO_TARGET_STR = "weibo_target"; 
	public static final String QQ_STR = "qq"; 
	public static final String BAIDU_FLOWER_STR = "baidu_flower"; 
	public static final String URL_STR = "url"; 
	
	// 驱动地址和浏览器地址
	public static final String CHROME = "chrome"; 
	public static final String FIREFOX = "firefox"; 
	public static final String OPERA = "opera"; 
	public static final String DRIVER = "driver"; 
	public static final String BROWSER_DIR = "browser_dir"; 
	public static final String USE = "use"; 
	public static final String NEW = "new"; 
	public static final String MOBILE = "mobile"; 
	public static final String OPTION = "option"; 
	public static final String CHROME_DIR = "chrome_dir"; 
	public static final String FIREFOX_GECKO_DIR = "firefox_gecko_dir"; 
	public static final String FIREFOX_BROWSER_DIR = "firefox_browser_dir"; 
	public static final String FIREFOX_OLD_BROWSER_DIR = "firefox_old_browser_dir"; 
	public static final String OPERA_DRIVER_DIR = "opera_driver_dir"; 
	public static final String OPERA_BROWSER_DIR = "opera_browser_dir"; 
	
	// 头条分享类型
	public static final int SHARE_WEIBO = 1;
	public static final int SHARE_QQ = 2;
	
	// 模拟停留时间，控制速度，分3档：1-5，5-10，10-20；单位为秒s
	public static final int SPEED_ONE_MIN = 1;
	public static final int SPEED_ONE_MAX = 3;
	public static final int SPEED_TWO_MIN = 5;
	public static final int SPEED_TWO_MAX = 7;
	public static final int SPEED_THR_MIN = 10;
	public static final int SPEED_THR_MAX = 14;
	
	
}
