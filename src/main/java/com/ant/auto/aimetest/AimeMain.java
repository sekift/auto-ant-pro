package com.ant.auto.aimetest;

import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.util.KillProcess;
import org.openqa.selenium.WebDriver;

public class AimeMain {

    public static final String UAT_INSIDE_BASE_URL = "http://oms-front-end-inside.aam.test";
    public static final String UAT_OUTSIDE_BASE_URL = "http://oms-front-end-outside.aam.test";
    public static final String DEV_BASE_URL = "http://10.0.2.137:8000";

    public static final String BASE_URL = DEV_BASE_URL;

    public static void main(String[] args) {
        WebDriver driver = AssembleBrowserFactory.getBrower();
        AimeLogin.login(driver);// 登录
        AimeTableListTest.test(driver);//资源位列表
        AimeAdCreateTest.test(driver);//广告创意
        AimeAdvertisingTest.test(driver);//广告投放
        AimeAdTest.test(driver);//投放测试
        KillProcess.quit(driver);
    }
}
