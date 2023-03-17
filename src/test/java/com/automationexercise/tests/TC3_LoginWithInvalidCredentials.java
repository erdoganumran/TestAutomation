package com.automationexercise.tests;

import com.automationexercise.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC3_LoginWithInvalidCredentials {

    WebDriver driver;

    @BeforeClass
    public void launchBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void login(){
        driver.get("http://automationexercise.com");
        Assert.assertTrue(driver.getTitle().equals("Automation Exercise"), " home page is visible successfully");
        driver.findElement(By.cssSelector("[href='/login']")).click();

        Assert.assertTrue(driver.findElement(By.className("login-form")).getText().startsWith("Login to your account"));
        driver.findElement(By.cssSelector("[data-qa='login-email']")).sendKeys("test1test@gamil.com");
        driver.findElement(By.cssSelector("[data-qa='login-password']")).sendKeys("123abc");
        driver.findElement(By.cssSelector("[data-qa='login-button']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']")).getText().equals("Your email or password is incorrect!"));
    }

    @AfterClass
    public void close(){
        driver.close();
    }

}
/*
Test Case 3: Login User with incorrect email and password
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible
 */