package com.ant.auto.aimetest;

import com.ant.auto.util.S;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AimeLogin {

    private static final String FRONT_BASE_URL = "http://oms-front-end.aam.test";

    public static WebDriver login(WebDriver driver){
        driver.manage().window().maximize();
        //S.s1();
        driver.navigate().to(FRONT_BASE_URL);
        //S.s1();
        driver.findElement(By.id("username")).sendKeys("admin");
        //S.s1();
        driver.findElement(By.id("password")).sendKeys("admin");
        S.s1();
        driver.findElement(By.className("login-button")).click();
        S.s2();

        return driver;
    }
}
