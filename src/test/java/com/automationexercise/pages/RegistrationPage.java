package com.automationexercise.pages;

import com.automationexercise.utilities.BrowserUtils;
import com.automationexercise.utilities.ConfigurationReader;
import com.automationexercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Integer.*;

public class RegistrationPage {
    @FindBy(xpath = "(//h2[@class='title text-center'])[1]")
    protected WebElement signUpPageText;
    //css=div>.title.text-center
    @FindBy(id = "id_gender1")
    protected WebElement genderMr;
    @FindBy(id = "id_gender2")
    protected WebElement genderMrs;
    @FindBy(id = "password")
    protected WebElement password;
    @FindBy(id = "days")
    protected WebElement dayOfBirth;
    @FindBy(id = "months")
    protected WebElement monthOfBirth;
    @FindBy(id = "years")
    protected WebElement yearOfBirth;
    @FindBy(xpath = "//input[@value='1']")
    protected WebElement signUpCheckBox;
    @FindBy(xpath = "(//input[@value='1'])[2]")
    protected WebElement receivingNewsCheckBox;
    @FindBy(id= "first_name")
    protected WebElement firstNameAddress;
    @FindBy(id = "last_name")
    protected WebElement lastNameAddress;
    @FindBy(id = "company")
    protected WebElement company;
    @FindBy(id = "address1")
    protected WebElement address;
    @FindBy(id = "address2")
    protected WebElement address2;
    @FindBy(id = "country")
    protected WebElement country;
    @FindBy(id = "state")
    protected WebElement state;
    @FindBy(id = "city")
    protected WebElement city;
    @FindBy(id = "zipcode")
    protected WebElement zipCode;
    @FindBy(id = "mobile_number")
    protected WebElement mobileNumber;
    @FindBy(css = "[data-qa='create-account']")
    protected WebElement createAccountButton;

    public RegistrationPage() {//constructor
        PageFactory.initElements(Driver.get(), this);
    }

    @Test
    public void fillOutRegistrationForm(){
        genderMr.click();
        password.sendKeys(ConfigurationReader.get("password"));

        Select dropdown= new Select(dayOfBirth);
        dropdown.selectByVisibleText(ConfigurationReader.get("dayOfBirth"));

        dropdown= new Select(monthOfBirth);
        dropdown.selectByIndex(Integer.parseInt(ConfigurationReader.get("monthOfBirth")));

        dropdown= new Select(yearOfBirth);
        dropdown.selectByValue(ConfigurationReader.get("yearOfBirth"));


        //Sign up for our newsletter! checkbox
        JavascriptExecutor executor = (JavascriptExecutor) Driver.get();
        executor.executeScript("arguments[0].click()", signUpCheckBox);
        executor.executeScript("arguments[0].click()", receivingNewsCheckBox);

        //Address Information
        firstNameAddress.sendKeys(ConfigurationReader.get("first_name"));
        lastNameAddress.sendKeys(ConfigurationReader.get("last_name"));
        company.sendKeys(ConfigurationReader.get("company"));
        address.sendKeys(ConfigurationReader.get("addressLine1"));
        address2.sendKeys(ConfigurationReader.get("addressLine2"));


        dropdown= new Select(country);
        dropdown.selectByValue(ConfigurationReader.get("country"));


        state.sendKeys(ConfigurationReader.get("state"));
        city.sendKeys(ConfigurationReader.get("city"));
        zipCode.sendKeys(ConfigurationReader.get("zipCode"));
        mobileNumber.sendKeys(ConfigurationReader.get("mobilePhone"));

        //create account button
        executor.executeScript("arguments[0].click()", createAccountButton);

    }

    @Test
    public String getSignUpPageText(){
        return signUpPageText.getText();
       //return Driver.get().findElement(By.xpath("(//h2[@class='title text-center'])[1]")).getText();
    }

}
