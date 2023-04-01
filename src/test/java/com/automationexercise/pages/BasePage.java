package com.automationexercise.pages;

import com.automationexercise.utilities.BrowserUtils;
import com.automationexercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
    public abstract class BasePage {

        @FindBy(xpath = "//img[@src='/static/images/home/logo.png']")
        protected WebElement logo;

        @FindBy(xpath = "//i[@class='fa fa-home']/..")
        public WebElement home;

        @FindBy(xpath = "//i[@class='material-icons card_travel']/..")
        public WebElement products;

        @FindBy(xpath = "(//i[@class='fa fa-shopping-cart']/..)[1]")
        public WebElement cart;
        @FindBy(css = "[href='/logout']")
        public WebElement logout;
        @FindBy(css= "[href='/delete_account']")
        public WebElement deleteAccount;
        @FindBy(xpath= "//a[@href='/login']")
        public WebElement signUpLogin;
        @FindBy(xpath = "(//a[@href='/test_cases'])[1]")
        public WebElement testCases;
        @FindBy(xpath = "(//a[@href='/api_list'])[1]")
        public WebElement apiTesting;
        @FindBy(xpath = "//i[@class='fa fa-youtube-play']/..")
        public WebElement videoTutorials;
        @FindBy(xpath = "//a[@href='/contact_us']")
        public WebElement contactUs;
        @FindBy(id = "subscribe_email")
        public WebElement subscriptionEmailBox;
        @FindBy(id = "subscribe")
        public WebElement subscriptionEmailBoxClickButton;
        @FindBy(xpath = "//i[@class='fa fa-user']")
        public WebElement userName;

        public BasePage() {
            PageFactory.initElements(Driver.get(), this);
        }

        public String getUserName(){
            BrowserUtils.waitForVisibility(userName, 5);
            return userName.getText();
        }

        public void logOut(){
            BrowserUtils.waitFor(2);
            BrowserUtils.clickWithJS(logout);
        }
        public void deleteAccount(){
            BrowserUtils.waitFor(2);
            BrowserUtils.clickWithJS(deleteAccount);
        }
        public void goToHomePage(){
            BrowserUtils.waitFor(2);
            BrowserUtils.clickWithJS(logo);
        }

        public void goToCart(){
            BrowserUtils.waitFor(2);
            BrowserUtils.clickWithJS(cart);
        }

        /**
         * This method will navigate user to the specific module in application.
         * For example: if tab is equals to Activities, and module equals to Calls,
         * Then method will navigate user to this page: http://qa2.vytrack.com/call/
         *
         * @param tab
         */
        public void navigateToModule(String tab) {
            String tabLocator = "//a[contains(text(),' "+tab+"')]";

            try {
                BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
                WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
                new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
            } catch (Exception e) {
                BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
            }
        }



        /**
         * Waits until loader screen present. If loader screen will not pop up at all,
         * NoSuchElementException will be handled  by try/catch block
         * Thus, we can continue in any case.
         */
        /*
        public void waitUntilLoaderScreenDisappear() {
            try {
                WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));
                wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void goToMyUser(){
            waitUntilLoaderScreenDisappear();
            BrowserUtils.waitForClickablility(userName, 5).click();
            BrowserUtils.waitForClickablility(myUser, 5).click();

        }

        */
    }
