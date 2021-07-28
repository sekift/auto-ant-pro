package com.ant.auto.baidu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.util.JsoupUtil;
import com.ant.auto.util.S;
import com.ant.auto.util.SleepUtil;

/**
 * 百度签到
 * @author sekift
 *
 */
public class BaiduSignUp {
	private static final Logger logger = LoggerFactory.getLogger(BaiduSignUp.class);
	private static final String TIEBA_URL = "https://tieba.baidu.com";
	private static final String SING_URL_PRO = "/?page=like";

	public static void signUpRun(String username, String password, WebDriver driverPre) {
		WebDriver driver = BaiduLogin.baiduLogin(username, password, driverPre);

		Navigation navigation = driver.navigate();
		navigation.to(TIEBA_URL + SING_URL_PRO);
		S.s1();
		String wd = driver.getPageSource();
		Document doc = Jsoup.parse(wd);
		Elements eles = doc.getElementsByClass("j_forumTile_wrapper");
		String tbs = getTbs();
		// 有的吧被禁也没有判断
		for (Element ele : eles) {
			navigation.to("https:" + ele.select("a").attr("href"));
			SleepUtil.sleepBySecond(2, 5);
			// 这里可以换成点击 签到 按钮 更加真实，而且不用tbs
			navigation.to(TIEBA_URL + "/mo/q/sign?tbs=" + tbs + "&kw=" + ele.select("a").
					attr("data-start-app-param")
					+ "&is_like=1&fid=" + ele.select("a").attr("data-fid"));
			S.s1();
		}
		S.s1();
		navigation.to(TIEBA_URL + SING_URL_PRO);
		S.s3();
	}

	private static final String GET_TBS_URL = "http://tieba.baidu.com/dc/common/tbs";

	/**
	 * 获取他的tbs
	 *
	 * @return
	 */
	private static String getTbs() {
		// 默认值
		String result = "27a56e5bfff3adec1489030202";
		try {
			String tbsLogin = JsoupUtil.getByTag(GET_TBS_URL, "body").text();
			String[] tbs1 = tbsLogin.split(",");
			String[] tbs2 = tbs1[0].split(":");
			result = tbs2[1].replaceAll("\"", "");
		} catch (Exception e) {
			logger.error("百度获取tbs出错了", e);
		}
		return result;
	}
}
