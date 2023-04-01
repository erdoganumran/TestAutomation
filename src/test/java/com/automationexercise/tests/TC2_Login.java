package com.automationexercise.tests;

import com.automationexercise.pages.DashboardPage;
import com.automationexercise.pages.SignUpLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_Login extends TestBase {

    @Test
    public void login(){
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully */
        DashboardPage dashboardPage= new DashboardPage();
        SignUpLoginPage signUpLoginPage= new SignUpLoginPage();

        String expectedHomePageTitle ="Automation Exercise";
        Assert.assertEquals(expectedHomePageTitle,driver.getTitle(), "Webpage don't load");

/*      4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible*/
        String expectedLoginTitle= "Login to your account";
        dashboardPage.signUpLogin.click();
        String actualLoginTitle = signUpLoginPage.getLoginText();
        Assert.assertEquals(expectedLoginTitle, actualLoginTitle, "Login message is wrong. It must be: " + expectedLoginTitle);

       /* Enter correct email address and password
        7. Click 'login' button
        8. Verify that 'Logged in as username' is visible*/
        signUpLoginPage.login();
        String expectedUser="Logged in as test";
        String actualUser= dashboardPage.userName.getText();
        //Assert.assertEquals(actualUser,expectedUser, "Username looks different than you provided");

        /*9. Click 'Delete Account' button
        10. Verify that 'ACCOUNT DELETED!' is visible*/
       // dashboardPage.deleteAccount();
       // driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();
        //Assert.assertEquals("Account Deleted!",driver.findElement(By.cssSelector("[data-qa='account-deleted']")).getText(),"text is different!");

    }

}
