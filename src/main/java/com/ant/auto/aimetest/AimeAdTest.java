package com.ant.auto.aimetest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ant.auto.aimetest.vo.ChangeType;
import com.ant.auto.aimetest.vo.TerminalResLocCntnVO;
import com.ant.auto.core.WebDriverOperate;
import com.ant.auto.core.WebElementType;
import com.ant.auto.util.JsonUtil;
import com.ant.auto.util.S;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

/**
 * @author: yinzhang.lu
 * @date: 2020/12/09 10:15
 * @description:
 */
public class AimeAdTest {

    private static final String TEST_URL = AimeMain.BASE_URL+"/create/advertising-test";
    /**
     * 投放测试
     * @param driver
     * @return
     */
    public static WebDriver test(WebDriver driver){
        Map<String, List<JSONObject>> testJsonMap =  JsonUtil.getJsonByName("adtest");
        if(testJsonMap.isEmpty()){
            return driver;
        }
        driver.navigate().to(TEST_URL);
        for(List<JSONObject> list : testJsonMap.values()){
            for(JSONObject object : list){
                TerminalResLocCntnVO vo = JSON.parseObject(object.toJSONString(), TerminalResLocCntnVO.class);
                driver = pageTest(driver, vo);
            }
        }
        return driver;
    }

    /**
     * 测试
     * @param driver
     * @return
     */
    public static WebDriver pageTest(WebDriver driver, TerminalResLocCntnVO vo){
        S.s1();
        driver.findElement(By.cssSelector(".ant-page-header-heading")).click();
        S.s0();
        WebElement trmlTypeSelector = WebDriverOperate.getWebElement(driver, WebElementType.CssSelector.toString(),
                "#trmlTypeId .ant-select-selection__rendered");
        if(null == trmlTypeSelector){
            trmlTypeSelector = WebDriverOperate.getWebElement(driver, WebElementType.CssSelector.toString(),
                    "#trmlTypeId .ant-select-selection__placeholder");
        }
        trmlTypeSelector.click();
        S.s0();
        driver.findElement(By.xpath("//li[contains(.,\'"+ ChangeType.getTrmlTypeName(vo.getTrmlTypeId())+"\')]")).click();
        S.s1();

        WebElement prdctTypeSelector = WebDriverOperate.getWebElement(driver, WebElementType.CssSelector.toString(),
                "#prdctTypeId .ant-select-selection__rendered");
        if(null == trmlTypeSelector){
            prdctTypeSelector = WebDriverOperate.getWebElement(driver, WebElementType.CssSelector.toString(),
                    "#prdctTypeId .ant-select-selection__placeholder");
        }
        prdctTypeSelector.click();
        S.s0();
        driver.findElement(By.xpath("//li[contains(.,\'"+ChangeType.getPrdctTypeName(vo.getPrdctTypeId())+"\')]")).click();
        S.s1();
        driver.findElement(By.name("mid")).click();
        driver.findElement(By.name("mid")).sendKeys(Keys.CONTROL, "a");
        driver.findElement(By.name("mid")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("mid")).sendKeys(vo.getMid().toString());
        S.s1();
        driver.findElement(By.name("uid")).click();
        driver.findElement(By.name("uid")).sendKeys(Keys.CONTROL, "a");
        driver.findElement(By.name("uid")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("uid")).sendKeys(vo.getUid().toString());
        S.s1();
        driver.findElement(By.name("resLocId")).click();
        driver.findElement(By.name("resLocId")).sendKeys(Keys.CONTROL, "a");
        driver.findElement(By.name("resLocId")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("resLocId")).sendKeys(vo.getResLocId().toString());
        S.s0();
        AdvertisingTestSubmit(driver);
        return driver;
    }

    /**
     * 提交与后续动作
     * @param driver
     * @return
     */
    public static WebDriver AdvertisingTestSubmit(WebDriver driver) {
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
