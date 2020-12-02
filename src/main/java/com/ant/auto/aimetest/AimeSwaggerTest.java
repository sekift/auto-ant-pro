package com.ant.auto.aimetest;

import com.ant.auto.core.AssembleBrowserFactory;
import com.ant.auto.util.KillProcess;
import com.ant.auto.util.S;
import org.openqa.selenium.WebDriver;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/10 13:50
 * @description: 简单的Test，测试swagger能不能行
 */
public class AimeSwaggerTest {

    //PC端地址
    private static final String SWAGGER_TEST_URL = "http://oms-back-end.aam.test/swagger-ui.html";

    /**
     * 简单测试
     */
    private static WebDriver swaggerTest(WebDriver driver){
        driver.manage().window().maximize();
        S.s1();
        driver.navigate().to(SWAGGER_TEST_URL);
        int count = 10; // 检测次数
        for(int i=1;i<=count;i++){
            S.s2();
            driver.navigate().refresh();
            if("Swagger UI".equals(driver.getTitle())){
                System.out.println("进行第" + i + "次测试，页面已恢复正常");
                break;
            }else{
                if(i < count) {
                    System.out.println("进行第" + i + "次测试，页面未恢复");
                }else{
                    System.out.println("未通过测试，请检查");
                }
            }
        }
        return driver;
    }
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        WebDriver driver = AssembleBrowserFactory.getBrower();
        swaggerTest(driver);
        KillProcess.quit(driver);
    }
}
