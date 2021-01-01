package com.qa.base;

import com.qa.utils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class DriverFactory {
    private static DriverFactory driverFactory=new DriverFactory();
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();


    private DriverFactory() {

    }

    public static DriverFactory getInstance() {
        return driverFactory;
    }

    public void setDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

    public void initDriver() {
        String browser=ReadProperties.getProperties("browser");

        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                setDriver(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                setDriver(new FirefoxDriver());
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                setDriver(new InternetExplorerDriver());
                break;
            default:
                System.out.println("Please provide valid WebDriver");

        }
    }






}
