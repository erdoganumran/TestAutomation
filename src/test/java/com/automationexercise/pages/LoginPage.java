package com.automationexercise.pages;

import com.automationexercise.utilities.ConfigurationReader;
import com.automationexercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
    public class LoginPage extends BasePage{
        public LoginPage() {//constructor
            PageFactory.initElements(Driver.get(), this);
            //initElements();-> initializes the elements
            //Driver.get()--> which driver we will use
        }
        @FindBy(name = "_username")
        //@FindBy represents driver.findElement()   Method
        public WebElement userNameInput;

        @FindBy(id = "prependedInput2")
        public WebElement passwordInput;

        @FindBy(id="_submit")
        public WebElement loginButton;

        public void login(String userName, String password){
            userNameInput.sendKeys(userName);
            passwordInput.sendKeys(password);
            loginButton.click();
        }

        @Test
        public void loginAsStoreManager(){
            String userName = ConfigurationReader.get("storemanager_username");
            String password= ConfigurationReader.get("storemanager_password");

            userNameInput.sendKeys(userName);
            passwordInput.sendKeys(password);
            loginButton.click();
        }
        @Test
        public void loginAsDriver(){
            String userName = ConfigurationReader.get("driver_username");
            String password= ConfigurationReader.get("driver_password");

            userNameInput.sendKeys(userName);
            passwordInput.sendKeys(password);
            loginButton.click();
        }
        @Test
        public void loginAsSalesManager(){
            String userName = ConfigurationReader.get("salesmanager_username");
            String password= ConfigurationReader.get("salesmanager_password");

            userNameInput.sendKeys(userName);
            passwordInput.sendKeys(password);
            loginButton.click();
        }
    }

