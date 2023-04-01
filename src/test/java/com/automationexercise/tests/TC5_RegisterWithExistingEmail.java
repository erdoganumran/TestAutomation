package com.automationexercise.tests;

import com.automationexercise.pages.DashboardPage;
import com.automationexercise.pages.RegistrationPage;
import com.automationexercise.pages.SignUpLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5_RegisterWithExistingEmail extends TestBase {

    @Test
    public void registerWithExistingMail(){
        /*1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully */
        DashboardPage dashboardPage= new DashboardPage();
        SignUpLoginPage signUpLoginPage= new SignUpLoginPage();

        String expectedHomePageTitle ="Automation Exercise";
        Assert.assertEquals(expectedHomePageTitle,driver.getTitle(), "Webpage isn't loaded");

        /* 4. Click on 'Signup / Login' button
        5. Verify 'New User Signup!' is visible*/
        String expectedSignUpTitle= "New User Signup!";
        dashboardPage.signUpLogin.click();
        String actualSignUpTitle = signUpLoginPage.getSignUpText();
        Assert.assertEquals(expectedSignUpTitle, actualSignUpTitle, "Signup message is wrong. It must be: " + expectedSignUpTitle);


        /*6. Enter name and already registered email address
        7. Click 'Signup' button
        8. Verify error 'Email Address already exist!' is visible*/
        signUpLoginPage.signUpWithExistingMail();

        String expectedSignUpPageText ="Email Address already exist!";
        String actualSignUpPageText= signUpLoginPage.getSignUpExistingMail();
        Assert.assertEquals(expectedSignUpPageText, actualSignUpPageText, "Text is not matching or not visible");

    }
}