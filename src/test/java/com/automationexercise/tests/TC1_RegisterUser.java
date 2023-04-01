package com.automationexercise.tests;

import com.automationexercise.pages.DashboardPage;
import com.automationexercise.pages.RegistrationPage;
import com.automationexercise.pages.SignUpLoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_RegisterUser extends TestBase{
    @Test
    public void registerUser() throws InterruptedException {
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully */
        DashboardPage dashboardPage= new DashboardPage();
        SignUpLoginPage signUpLoginPage= new SignUpLoginPage();

        String expectedHomePageTitle ="Automation Exercise";
        Assert.assertEquals(expectedHomePageTitle,driver.getTitle(), "Webpage don't load");

     /* 4. Click on 'Signup / Login' button
        5. Verify 'New User Signup!' is visible*/
        String expectedSignUpTitle= "New User Signup!";
        dashboardPage.signUpLogin.click();
        String actualSignUpTitle = signUpLoginPage.getSignUpText();
        Assert.assertEquals(expectedSignUpTitle, actualSignUpTitle, "Signup message is wrong. It must be: " + expectedSignUpTitle);


      /*6. Enter name and email address
        7. Click 'Signup' button
        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible*/
        signUpLoginPage.signUp();
        RegistrationPage registrationPage= new RegistrationPage();
        String expectedSignUpPageText ="ENTER ACCOUNT INFORMATION";
        String actualSignUpPageText= registrationPage.getSignUpPageText();
        Assert.assertEquals(expectedSignUpPageText, actualSignUpPageText, "Text is not matching or not visible");


    /*  9. Fill details: Title, Name, Email, Password, Date of birth
        10. Select checkbox 'Sign up for our newsletter!'
        11. Select checkbox 'Receive special offers from our partners!'
        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        13. Click 'Create Account button'
        14. Verify that 'ACCOUNT CREATED!' is visible*/
        registrationPage.fillOutRegistrationForm();
        String actualCreatedSignUp= driver.findElement(By.cssSelector("[data-qa='account-created']")).getText();
        Assert.assertEquals(actualCreatedSignUp, "ACCOUNT CREATED!", "Text is not visible or different than expected!" );

/*      15. Click 'Continue' button
        16. Verify that 'Logged in as username' is visible
        17. Click 'Delete Account' button
        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button*/
        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();

        driver.navigate().refresh();

        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();

        String expectedUser="Logged in as test";
        String actualUser= dashboardPage.userName.getText();
        //Assert.assertEquals(actualUser,expectedUser, "Username looks different than you provided");

        dashboardPage.deleteAccount();

        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();

        //Assert.assertEquals("Account Deleted!",driver.findElement(By.cssSelector("[data-qa='account-deleted']")).getText(),"text is different!");
    }
}
