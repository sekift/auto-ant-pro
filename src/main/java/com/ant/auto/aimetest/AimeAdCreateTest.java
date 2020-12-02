package com.ant.auto.aimetest;

import com.ant.auto.util.S;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AimeAdCreateTest {
    private static final String TEST_URL = "http://oms-front-end.aam.test/create/advertising-creativity";

    public static WebDriver test(WebDriver driver){
        driver.navigate().to(TEST_URL);
        S.s1();
        driver.findElement(By.xpath("//button[@type=\'button\']")).click();
        S.s1();
        driver.findElement(By.id("ideaName")).click();
        driver.findElement(By.id("ideaName")).sendKeys("测试广告创意Selenium");
        S.s1();
        driver.findElement(By.cssSelector("#trmlTypeId .ant-select-selection__placeholder")).click();
        driver.findElement(By.xpath("//div[4]/div/div/div/ul/li")).click();
        S.s1();
        driver.findElement(By.cssSelector("#trml_type_id .ant-select-selection__placeholder")).click();
        driver.findElement(By.xpath("//div[5]/div/div/div/ul/li")).click();
        S.s1();
        driver.findElement(By.cssSelector("#trml_form_id .ant-select-selection__placeholder")).click();
        driver.findElement(By.xpath("//div[6]/div/div/div/ul/li")).click();
        S.s1();
        driver.findElement(By.cssSelector("#resLocId .ant-select-selection__placeholder")).click();
        driver.findElement(By.xpath("//body/div[7]/div/div/div/ul/li")).click();
        S.s1();
        driver.findElement(By.id("resCntnValue")).click();
        driver.findElement(By.id("resCntnValue")).sendKeys("测试广告创意的具体内容Selenium");
        S.s1();
        ((JavascriptExecutor) driver).executeScript("scrollTo(400, 800)");
        S.s1();
        //driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
        S.s2();
        return driver;
    }

}
