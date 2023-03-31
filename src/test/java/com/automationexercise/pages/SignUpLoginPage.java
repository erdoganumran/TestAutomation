package com.automationexercise.pages;

import com.automationexercise.tests.TestBase;
import com.automationexercise.utilities.ConfigurationReader;
import com.automationexercise.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpLoginPage extends BasePage {
    public SignUpLoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    protected WebElement emailBoxSignUp;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    protected WebElement signUpClick;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    protected WebElement signUpName;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    protected WebElement loginEmailBox;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    protected WebElement loginPassword;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    protected WebElement loginButton;
    @Test
    public void login(){
        loginEmailBox.sendKeys(ConfigurationReader.get("valid_mail"));
        loginPassword.sendKeys(ConfigurationReader.get("valid_password"));
        loginButton.click();
    }
    @Test
    public void loginWithValidCredentials(String userName, String password){
        loginEmailBox.sendKeys(userName);
        loginPassword.sendKeys(password);
        loginButton.click();
    }
    @Test
    public void loginWithInvalidEmail(){
        loginEmailBox.sendKeys(ConfigurationReader.get("invalid_username_valid_password"));
        loginPassword.sendKeys(ConfigurationReader.get("invalid_user_valid_password_password"));
        loginButton.click();
    }
    @Test
    public void loginWithInvalidPassword(){
        loginEmailBox.sendKeys(ConfigurationReader.get("invalid_password_valid_user"));
        loginPassword.sendKeys(ConfigurationReader.get("valid_user_invalid_password_password"));
        loginButton.click();
    }

    @Test
    public void signUp(){
        signUpName.sendKeys(ConfigurationReader.get("sign_up_name"));
        emailBoxSignUp.sendKeys(ConfigurationReader.get("sign_up_mail"));
        signUpClick.click();
    }


}
