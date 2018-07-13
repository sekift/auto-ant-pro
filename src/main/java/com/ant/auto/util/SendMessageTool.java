package com.ant.auto.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

/**
 * 短信猫收发短信工具
 * @author:Administrator
 * @time:2015-9-6 上午09:49:39
 * @version:
 */
public class SendMessageTool {
	/**
	 * 短信猫RemoteSMS发送短信
	 * 返回1代表成功，其他：可能是0代表不成功
	 * @param numbers
	 * @param text
	 * @return
	 */
	public static String sendMessageByRemoteSMS(String numbers,String text){
		// 接口地址
		String url = "http://localhost:8080/";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("numbers", numbers);
		try {
			params.put("text", URLEncoder.encode(text, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String response = HttpUtil.get(url, params, null, 5*1000, 3 * 60 * 1000, "UTF-8");
		if(response==null){
			return "0";
		}
		return response;
	}
	
	/**
	 * 短信猫RemoteSMS接收新短信，分几步：
	 * 1.check 监控接口：http://localhost:8080/?checkHistory=1&_=1480572282335；返回0表示没有新信息，
	 * 返回0|xxx表示有xxx div的新信息
	 * 2.获取信息：http://localhost:8080/?showConversation=308&_=1480572297973 ；返回的最后一条就是新信息。
	 * 以上方法仅是当没有获取过的可用，即需要定时器轮询接口。
	 * 还可以获取全部，然后取第一条数据。
	 * @param numbers
	 * @param text
	 * @return
	 */
	public static String getMessageByRemoteSMS() {
		// 接口地址
		String url = "http://localhost:8080/?showConversation=308";
		String response = HttpUtil.get(url, null, null, 5 * 1000, 3 * 60 * 1000, "UTF-8");
		String docment = "<html><head></head><body>" + response + "</body></html";
		Elements eles = null;
		String ele = null;
		String result = "";
		try {
			eles = Jsoup.parse(docment).getElementsByClass("one");
			ele = eles.last().text();
			String[] str = ele.split("，");
			result = str[0].substring(str[0].length() - 5, str[0].length()).trim();
		} catch (Exception e) {
			System.out.println("页面错误");
		}
		return result;
	}
	
	public static void main(String args[]){
		System.out.println(getMessageByRemoteSMS());
	}
}
