package com.automationexercise.tests;

import com.automationexercise.pages.DashboardPage;
import com.automationexercise.pages.SignUpLoginPage;
import com.automationexercise.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC3_LoginWithInvalidCredentials extends TestBase{

    @Test
    public void login(){
        /*1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully */
        DashboardPage dashboardPage= new DashboardPage();
        SignUpLoginPage signUpLoginPage= new SignUpLoginPage();

        String expectedHomePageTitle ="Automation Exercise";
        Assert.assertEquals(expectedHomePageTitle,driver.getTitle(), "Webpage don't load");

      /*4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible*/
        String expectedLoginTitle= "Login to your account";
        dashboardPage.signUpLogin.click();
        String actualLoginTitle = signUpLoginPage.getLoginText();
        Assert.assertEquals(expectedLoginTitle, actualLoginTitle, "Login message is wrong. It must be: " + expectedLoginTitle);

        /*6. Enter incorrect email address and password
        7. Click 'login' button
        8. Verify error 'Your email or password is incorrect!' is visible*/
        signUpLoginPage.loginWithInvalidEmail();
        String expectedText = "Your email or password is incorrect!";
        String actualText= signUpLoginPage.getInvalidCredentialsText();
        Assert.assertEquals(actualText, expectedText);
    }
}
