package com.ant.auto.aimetest;

import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.util.KillProcess;
import org.openqa.selenium.WebDriver;
/**
 *
 * @author sekift
 */
public class AimeMain {
    public static final String DEV_BASE_URL = "http://10.0.2.137:8000";

    public static final String BASE_URL = DEV_BASE_URL;

    public static void main(String[] args) {
        WebDriver driver = AssembleBrowserFactory.getBrower();
        // 登录
        AimeLogin.login(driver);
        //资源位列表
//        AimeTableListTest.test(driver);
        //广告创意
//        AimeAdCreateTest.test(driver);
        //广告投放
//        AimeAdvertisingTest.test(driver);
        //投放测试
        AimeAdTest.test(driver);
        //杀死进程
        KillProcess.quit(driver);
    }
}
