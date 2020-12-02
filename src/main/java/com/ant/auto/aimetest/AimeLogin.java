package com.ant.auto.aimetest;

import com.ant.auto.util.S;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AimeLogin {
    private static final String BASE_URL = AimeMain.BASE_URL;

    public static WebDriver login(WebDriver driver){
        driver.manage().window().maximize();
        //S.s1();
        driver.navigate().to(BASE_URL);
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
