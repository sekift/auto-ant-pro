package com.ant.auto.aimetest;

import com.ant.auto.util.S;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AimeAdvertisingTest {

    private static final String TEST_URL = "http://oms-front-end.aam.test/create/advertising";

    public static WebDriver test(WebDriver driver) {
        driver.navigate().to(TEST_URL);
        S.s1();
        driver.findElement(By.xpath("//button[@type=\'button\']")).click();


        S.s1();
        driver.findElement(By.id("actv_name")).click();
        driver.findElement(By.id("actv_name")).sendKeys("测试广告活动Selenium");
        S.s1();
        ((JavascriptExecutor) driver).executeScript("scrollTo(0, 400)");
        S.s1();
        driver.findElement(By.cssSelector(".ant-table-row:nth-child(1) .ant-table-row-expand-icon")).click();
        driver.findElement(By.cssSelector(".ant-table-row:nth-child(1) .ant-radio-input")).click();
        S.s1();
        ((JavascriptExecutor) driver).executeScript("scrollTo(400, 800)");
        S.s1();
        driver.findElement(By.xpath("//button[@type='button']")).click();


        S.s1();
        driver.findElement(By.xpath("(//input[@value=''])[2]")).click();
        S.s1();
        driver.findElement(By.xpath("(//input[@value=''])[16]")).click();
        S.s1();
        ((JavascriptExecutor) driver).executeScript("scrollTo(400, 800)");
        S.s1();
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();

        S.s1();
        driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();


        S.s1();
        driver.findElement(By.xpath("(//input[@value='4'])[2]")).click();
        driver.findElement(By.id("actv_desc")).click();
        S.s1();
        driver.findElement(By.id("actv_desc")).sendKeys("这也是广告测试Selenium");
        S.s1();
        driver.findElement(By.name("length")).click();
        driver.findElement(By.name("length")).sendKeys("100");
        S.s1();
        driver.findElement(By.cssSelector(".ant-form:nth-child(3) #maxExeCnt .ant-input-number-input")).click();
        driver.findElement(By.cssSelector(".ant-form:nth-child(3) #maxExeCnt .ant-input-number-input"))
                .sendKeys("100");
        S.s1();
        driver.findElement(By.cssSelector("#maxJoinUserCnt .ant-input-number-input")).click();
        driver.findElement(By.cssSelector("#maxJoinUserCnt .ant-input-number-input")).sendKeys("100");
        S.s1();
        driver.findElement(By.cssSelector(".ant-calendar-picker-input")).click();
        driver.findElement(By.cssSelector(".ant-calendar-today > .ant-calendar-date")).click();
        S.s1();
        driver.findElement(By.cssSelector(".ant-calendar-selected-end-date > .ant-calendar-date")).click();
        driver.findElement(By.cssSelector(".date-picker-choose > span > .anticon > svg")).click();
        S.s1();
        driver.findElement(By.cssSelector("span:nth-child(2) > .anticon-up > svg")).click();
        S.s1();
        //driver.findElement(By.cssSelector(".ant-row:nth-child(4) .ant-btn-primary")).click();
        S.s1();
        driver.navigate().to(TEST_URL);
        S.s2();
        return driver;
    }

}
