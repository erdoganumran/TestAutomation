package com.automationexercise.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static io.github.bonigarcia.wdm.WebDriverManager.safaridriver;

public class WebDriverFactory {
        public static WebDriver getDriver(String browserType) {

            WebDriver driver=null;

            switch (browserType.toLowerCase()) {
                case "firefox":
                    driver = new FirefoxDriver();
                    firefoxdriver().setup();
                    break;
                case "chrome":
                    driver = new ChromeDriver();
                    chromedriver().setup();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    edgedriver().setup();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    safaridriver().setup();
                    break;
            }
            return driver;
        }
}
