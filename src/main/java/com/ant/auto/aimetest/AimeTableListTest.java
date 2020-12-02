package com.ant.auto.aimetest;

import com.ant.auto.util.S;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AimeTableListTest {

    private static final String TEST_URL = "http://oms-front-end.aam.test/list/table-list";

    public static WebDriver test(WebDriver driver){
        driver.navigate().to(TEST_URL);
        S.s1();
        driver.findElement(By.xpath("//button")).click();
        S.s1();
        driver.findElement(By.id("resLocName")).click();
        driver.findElement(By.id("resLocName")).sendKeys("资源位测试Selenium");
        S.s1();
        driver.findElement(By.cssSelector("#prdctTypeId .ant-select-selection__placeholder")).click();
        driver.findElement(By.cssSelector(".ant-select-dropdown-menu-item-active")).click();
        S.s1();
        driver.findElement(By.cssSelector("#trmlTypeId .ant-select-selection__placeholder")).click();
        driver.findElement(By.cssSelector(".ant-select-dropdown-menu-item-active")).click();
        S.s1();
        driver.findElement(By.id("resLocVersion")).click();
        driver.findElement(By.id("resLocVersion")).sendKeys("V2.0");
        S.s1();
        driver.findElement(By.cssSelector("#posTypeId .ant-select-selection__placeholder")).click();
        driver.findElement(By.cssSelector(".ant-select-dropdown-menu-item-active")).click();
        S.s1();
        driver.findElement(By.cssSelector("#resLocType .ant-select-selection__placeholder")).click();
        driver.findElement(By.cssSelector(".ant-select-dropdown-menu-item-active")).click();
        S.s1();
        driver.findElement(By.id("path")).click();
        driver.findElement(By.id("path")).sendKeys("首页-左上角");
        S.s1();
        ((JavascriptExecutor) driver).executeScript("scrollTo(0, 500)");
        S.s1();
        driver.findElement(By.name("length")).click();
        driver.findElement(By.name("length")).sendKeys("123");
        S.s1();
        driver.findElement(By.name("width")).click();
        driver.findElement(By.name("width")).sendKeys("123");

        S.s1();
        //driver.findElement(By.cssSelector(".anticon-plus > svg")).click();
        driver.findElement(By.id("previewPath")).sendKeys("C:\\Users\\yinzhang.lu\\Desktop\\timg.jpg");

        S.s1();
        driver.findElement(By.xpath("//button")).click();
        S.s1();
//        driver.findElement(By.id("resCntnNum")).click();
//        driver.findElement(By.id("resCntnNum")).sendKeys("2");
//        S.s1();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        S.s1();
        driver.findElement(By.name("count")).click();
        driver.findElement(By.name("count")).sendKeys("100");
        S.s1();
        driver.findElement(By.id("resCntnValue")).click();
        driver.findElement(By.id("resCntnValue")).sendKeys("这是测试的内容Selenium");
        S.s1();
        //driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
        S.s1();
        driver.navigate().to(TEST_URL);
        S.s2();
        return driver;
    }

}
