package com.automationexercise.tests;

import com.automationexercise.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC2_Login {
    WebDriver driver;
    @BeforeClass
    public void before(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }
    @Test
    public void getHomePage(){
        /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
         */
        driver.get("http://automationexercise.com");
        String expectedTitle ="Automation Exercise";
        Assert.assertEquals(expectedTitle,driver.getTitle(), "Webpage don't load");
    }
    @Test
    public void login(){
        getHomePage();
/*        Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible*/
        String expectedText = "Login to your account";
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        String actualText =driver.findElement(By.className("login-form")).getText();
        Assert.assertTrue(actualText.contains(expectedText), "Login message is wrong. It must be: " + expectedText);

        /*
        Enter correct email address and password
        7. Click 'login' button
         */
        String expectedText1 ="Logged in as test";
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("testfortestortest@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

/*      8. Verify that 'Logged in as username' is visible*/
        String actualText1 = driver.findElement(By.xpath("//a/b")).getText();
        Assert.assertEquals(actualText1, "test");
    }

    @Test
    public void deleteAccount() {
        /*9. Click 'Delete Account' button
        10. Verify that 'ACCOUNT DELETED!' is visible*/
       login();
        driver.findElement(By.cssSelector("[href='/delete_account']")).click();
        Assert.assertEquals("Account Deleted!",driver.findElement(By.cssSelector("[data-qa='account-deleted']")).getText(),"text is different!");
        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();
    }

    @AfterClass
    public void after(){
        driver.quit();
    }
}
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible
 */