package com.ant.auto.util;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

/**
 * chromedriver.exe、geckodriver.exe、operadriver.exe
 * 杀死xxxdriver驻留进程，浏览器由driver.quit退出
 * 
 * @author:sekift
 * @time:2018-12-10 14:20:45
 * @version: 1.0
 *
 */
public class KillProcess {
	public static void main(String[] args) {
		kill();
	}
	
	public static void quit(WebDriver driver){
		try {
			if(driver != null){
				driver.quit();
			}
			kill();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 杀死启动的进程
	public static void kill() {
		Scanner in = null;
		try {
			Process process = Runtime.getRuntime().exec("taskList");
			in = new Scanner(process.getInputStream());
			while (in.hasNextLine()) {
				String temp = in.nextLine();

				if (temp.contains("chromedriver.exe")) {
					temp = temp.replaceAll(" ", "");
					// 获得pid
					String pid = temp.substring("chromedriver.exe".length(), temp.indexOf("Console"));
					System.out.println(pid + "-----------------");
					Runtime.getRuntime().exec("tskill " + pid);
				}

				if (temp.contains("geckodriver.exe")) {
					temp = temp.replaceAll(" ", "");
					// 获得pid
					String pid = temp.substring("geckodriver.exe".length(), temp.indexOf("Console"));
					System.out.println(pid + "-----------------");
					Runtime.getRuntime().exec("tskill " + pid);
				}

				if (temp.contains("operadriver.exe")) {
					temp = temp.replaceAll(" ", "");
					// 获得pid
					String pid = temp.substring("operadriver.exe".length(), temp.indexOf("Console"));
					System.out.println(pid + "-----------------");
					Runtime.getRuntime().exec("tskill " + pid);
				}

				 /**
				  * 浏览器由原quit退出
				  * if (temp.contains("firefox.exe")) {
				 temp = temp.replaceAll(" +"," ");
				 System.out.println(temp);
				 temp = temp.replaceAll("firefox.exe ","");
				 int t1 = temp.indexOf(" ");
				 temp = temp.substring(0, t1);
				 // 获得pid
				 String pid = temp;
				 System.out.println(pid+"-----------------");
				 Runtime.getRuntime().exec("tskill " + pid);
				 }*/
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 结束进程
		} finally {
			in.close();
		}
	}

}
