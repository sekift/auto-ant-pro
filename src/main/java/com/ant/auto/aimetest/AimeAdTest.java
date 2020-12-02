package com.ant.auto.aimetest;

import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.util.KillProcess;
import com.ant.auto.util.S;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/11 10:15
 * @description:
 */
public class AimeAdTest {
    private static final String TEST_URL = "http://oms-front-end.aam.test/create/advertising-test";
    /**
     * 投放测试
     * @param driver
     * @return
     */
    public static WebDriver test(WebDriver driver){
        driver.navigate().to(TEST_URL);
        S.s1();
        driver.findElement(By.cssSelector(".ant-page-header-heading")).click();
        S.s1();
        driver.findElement(By.cssSelector("#trmlTypeId .ant-select-selection__placeholder")).click();
        S.s1();
        driver.findElement(By.cssSelector(".ant-select-dropdown-menu-item-active")).click();
        S.s1();
        driver.findElement(By.cssSelector("#prdctTypeId .ant-select-selection__placeholder")).click();
        S.s1();
        driver.findElement(By.cssSelector(".ant-select-dropdown-menu-item-active")).click();
        S.s1();
        driver.findElement(By.name("mid")).click();
        driver.findElement(By.name("mid")).sendKeys(Keys.CONTROL, "a");
        driver.findElement(By.name("mid")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("mid")).sendKeys("8000031");
        S.s1();
        driver.findElement(By.name("uid")).click();
        driver.findElement(By.name("uid")).sendKeys(Keys.CONTROL, "a");
        driver.findElement(By.name("uid")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("uid")).sendKeys("1000140174");
        S.s1();
        driver.findElement(By.name("resLocId")).click();
        driver.findElement(By.name("resLocId")).sendKeys(Keys.CONTROL, "a");
        driver.findElement(By.name("resLocId")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("resLocId")).sendKeys("80");
        S.s1();
        AdvertisingTestSubmit(driver);
        S.s1();
        driver.findElement(By.cssSelector("#trmlTypeId .ant-select-selection__rendered")).click();
        S.s1();
        driver.findElement(By.xpath("//div[4]/div/div/div/ul/li[2]")).click();
        S.s1();
        driver.findElement(By.cssSelector("#prdctTypeId .ant-select-selection__rendered")).click();
        S.s1();
        driver.findElement(By.cssSelector(".ant-select-dropdown-menu-item-active")).click();
        S.s1();
        driver.findElement(By.name("resLocId")).click();
        driver.findElement(By.name("resLocId")).sendKeys(Keys.CONTROL, "a");
        driver.findElement(By.name("resLocId")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("resLocId")).sendKeys("90");
        S.s1();
        AdvertisingTestSubmit(driver);

        S.s1();
        driver.findElement(By.cssSelector("#trmlTypeId .ant-select-selection__rendered")).click();
        S.s1();
        driver.findElement(By.xpath("//div[4]/div/div/div/ul/li[1]")).click();
        S.s1();
        driver.findElement(By.cssSelector("#prdctTypeId .ant-select-selection__rendered")).click();
        S.s1();
        driver.findElement(By.xpath("//div[5]/div/div/div/ul/li[2]")).click();
        S.s1();
        driver.findElement(By.name("resLocId")).click();
        driver.findElement(By.name("resLocId")).sendKeys(Keys.CONTROL, "a");
        driver.findElement(By.name("resLocId")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("resLocId")).sendKeys("78");
        S.s1();
        AdvertisingTestSubmit(driver);

        S.s1();
        driver.findElement(By.cssSelector("#trmlTypeId .ant-select-selection__rendered")).click();
        S.s1();
        driver.findElement(By.xpath("//div[4]/div/div/div/ul/li[2]")).click();
        S.s1();
        driver.findElement(By.cssSelector("#prdctTypeId .ant-select-selection__rendered")).click();
        S.s1();
        driver.findElement(By.xpath("//div[5]/div/div/div/ul/li[2]")).click();
        S.s1();
        driver.findElement(By.name("resLocId")).click();
        driver.findElement(By.name("resLocId")).sendKeys(Keys.CONTROL, "a");
        driver.findElement(By.name("resLocId")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("resLocId")).sendKeys("85");
        S.s1();
        AdvertisingTestSubmit(driver);

        S.s1();
        driver.findElement(By.cssSelector("#trmlTypeId .ant-select-selection__rendered")).click();
        S.s1();
        driver.findElement(By.xpath("//div[4]/div/div/div/ul/li[1]")).click();
        S.s1();
        driver.findElement(By.cssSelector("#prdctTypeId .ant-select-selection__rendered")).click();
        S.s1();
        driver.findElement(By.xpath("//div[5]/div/div/div/ul/li[1]")).click();
        S.s1();
        driver.findElement(By.name("resLocId")).click();
        driver.findElement(By.name("resLocId")).sendKeys(Keys.CONTROL, "a");
        driver.findElement(By.name("resLocId")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("resLocId")).sendKeys("95");
        S.s1();
        AdvertisingTestSubmit(driver);

        S.s1();
        driver.findElement(By.name("resLocId")).click();
        driver.findElement(By.name("resLocId")).sendKeys(Keys.CONTROL, "a");
        driver.findElement(By.name("resLocId")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("resLocId")).sendKeys("100");
        S.s1();
        AdvertisingTestSubmit(driver);
        return driver;
    }

    /**
     * 提交与后续动作
     * @param driver
     * @return
     */
    public static WebDriver AdvertisingTestSubmit(WebDriver driver){
        driver.findElement(By.cssSelector(".ant-btn-primary")).click();
        S.s1();
        {
            WebElement element = driver.findElement(By.cssSelector(".ant-btn-primary"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        S.s1();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        S.s1();
        {
            WebElement element = driver.findElement(By.cssSelector(".ant-btn-primary"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        S.s1();
        driver.findElement(By.cssSelector(".ant-btn:nth-child(2)")).click();
        return driver;
    }


}
