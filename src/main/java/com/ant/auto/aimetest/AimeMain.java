package com.ant.auto.aimetest;

import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.util.KillProcess;
import org.openqa.selenium.WebDriver;

public class AimeMain {

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
