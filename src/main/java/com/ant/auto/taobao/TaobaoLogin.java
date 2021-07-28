package com.ant.auto.taobao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.core.WebDriverOperate;
import com.ant.auto.core.WebElementType;
import com.ant.auto.util.S;

/**
 * 淘宝登录
 *
 * @author sekift
 */
public class TaobaoLogin {
    private static final Logger logger = LoggerFactory
            .getLogger(TaobaoLogin.class);

    /**手机端URL*/
    //private static final String taobaoLoginUrl_wap = "https://login.m.taobao.com/login.htm?loginFrom=wap_tb";
    /**PC端URL*/
    private static final String TAOBAO_LOGIN_URL = "https://login.taobao.com/member/login.jhtml";

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param driver
     */
    public static void taobaoLogin(String username, String password, WebDriver driver) {
        driver.manage().window().maximize();
        S.s1();
        driver.navigate().to(TAOBAO_LOGIN_URL);
        S.s1();
        //切换
        driver.findElement(By.id("J_Quick2Static")).click();
        S.s1();
        driver.findElement(By.id("TPL_username_1")).sendKeys(username);
        S.s1();
        driver.findElement(By.id("TPL_password_1")).sendKeys(password);
        S.s1();

        // nc-lang-cnt 请按住滑块，拖动到最右边 滑块破解，如果有的话就要做
        WebElement dragger = WebDriverOperate.getWebElement(driver, WebElementType.Class.toString(), "nc-lang-cnt");
        if (null != dragger) {
            Actions actions = new Actions(driver);
            //开始拖动：
            for (int i = 0; i < 1; i++) {
                actions.dragAndDropBy(dragger, 300, 0).perform();
                S.s1();
            }
        }
        S.s1();
        driver.findElement(By.id("J_SubmitStatic")).click();
        S.s2();

        // 暂时没有判断是否真正登录成功，通过即成功
        if (!"淘宝网 - 淘！我喜欢".equals(driver.getTitle())) {
            logger.info("登录成功，username= " + username);
        } else {
            logger.info("登录失败，标题为：" + driver.getTitle());
        }
        S.s3();
    }
}
