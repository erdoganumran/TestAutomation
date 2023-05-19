package com.automationexercise.pages;

import com.automationexercise.utilities.BrowserUtils;
import com.automationexercise.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage{
    @FindBy(xpath= "//div[@class='status alert alert-success']/../h2")
    protected WebElement getInTouchText;
    @FindBy(css = "//div[@class='col-sm-12']/h2")
    protected WebElement contactUsText;
    @FindBy(css = "[name='name']")
    protected WebElement name;
    @FindBy(css = "[name='email']")
    protected WebElement email;
    @FindBy(css= "[name='subject']")
    protected WebElement subject;

    @FindBy(css = "[name='message']")
    protected WebElement messageBox;
    @FindBy(css = "[name='upload_file']")
    protected WebElement uploadFileButton;
    @FindBy(css = "[name='submit']")
    protected WebElement submitButton;
    public ContactUsPage() {//constructor
        PageFactory.initElements(Driver.get(), this);
    }

    public void fillOutContactPage(){
        name.sendKeys("test");
        email.sendKeys("test@mail.com");
        subject.sendKeys("test subject");
        messageBox.sendKeys("test message");
      //  submitButton.click();
        BrowserUtils.clickWithJS(submitButton);

        Alert alert =Driver.get().switchTo().alert();
        alert.accept();

    }


}
