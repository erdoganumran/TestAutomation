package com.automationexercise.tests;

import com.automationexercise.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class forShortTest {

        @Test
        public void test() {
            WebDriver driver = WebDriverFactory.getDriver("Chrome");
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com/signup");
            driver.findElement(By.name("name")).sendKeys("test");
            driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("testfortestortest@gmail.com");
            driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

            WebElement testDropDown3 = driver.findElement(By.id("years"));
            Select dropdown = new Select(testDropDown3);
            dropdown = new Select(testDropDown3);
            dropdown.selectByValue("2001");
            System.out.println(dropdown.getOptions());
        }


    }
