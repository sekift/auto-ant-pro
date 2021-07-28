package com.ant.auto.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ant.auto.Consts;

/**
 * 装配浏览器
 *
 * @author sekift
 */
public class AssembleBrowser {
    /**
     * 装配chrome浏览器
     *
     * @param browserDir
     * @return
     */
    public static WebDriver setChrome(String browserDir) {
        System.setProperty(Consts.Driver.CHROME_DRIVER, browserDir);
        return new ChromeDriver();
    }

    /**
     * 装配chrome浏览器
     *
     * @param browserDir
     * @param mobile
     * @return
     */
    public static WebDriver setChromeAsPhone(String browserDir, String mobile) {
        System.setProperty(Consts.Driver.CHROME_DRIVER, browserDir);
        Map<String, String> mobileEmulation = new HashMap<>(4);
        // 模拟手机端
        mobileEmulation.put("deviceName", mobile);
        Map<String, Object> chromeOptions = new HashMap<>(4);
        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return new ChromeDriver(capabilities);
    }

    /**
     * 装配firefox浏览器，带配置启动
     *
     * @param dir
     * @param browserDir
     * @param defaultConf
     * @return
     */
    public static WebDriver setFirefox(String dir, String browserDir, boolean defaultConf) {
        System.setProperty(Consts.Driver.GECKO_DRIVER, dir);
        File pathBinary = new File(browserDir);
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        if (defaultConf) {
            ProfilesIni pi = new ProfilesIni();
            firefoxProfile = pi.getProfile("default");
        }
        //20180713 取消旧写法，改用新写法
        //WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
        FirefoxOptions options = new FirefoxOptions().setBinary(firefoxBinary).setProfile(firefoxProfile);
        return new FirefoxDriver(options);
    }

    /**
     * 装配opera浏览器
     *
     * @param dir
     * @param browserDir
     * @return
     */
    public static WebDriver setOpera(String dir, String browserDir) {
        System.setProperty(Consts.Driver.OPERA_DRIVER, dir);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(browserDir);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return new OperaDriver(capabilities);
    }
}
