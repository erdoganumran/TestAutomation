package com.automationexercise.tests;

import com.automationexercise.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC1_RegisterUser {
    WebDriver driver;
    @BeforeClass
    public void before(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }
    @Test
    public void getHomePage(){
     driver.get("http://automationexercise.com");
     String expectedTitle ="Automation Exercise";
     Assert.assertEquals(expectedTitle,driver.getTitle(), "Webpage don't load");
    }
    @Test
    public void signUpMessage(){
        getHomePage();
        String expectedText = "New User Signup!";
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        String actualText =driver.findElement(By.xpath("//h2[.= 'New User Signup!']")).getText();
        Assert.assertEquals(expectedText,actualText, "Signup message is wrong. It must be: " + expectedText);
    }
    @Test
    public void EnterAccountInformation(){
        String expectedText ="ENTER ACCOUNT INFORMATION";
        signUpMessage();
        driver.findElement(By.name("name")).sendKeys("test");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("testfortestortest@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        String actualText = driver.findElement(By.cssSelector("div>.title.text-center")).getText();
        Assert.assertEquals(expectedText, actualText, "Text is not matching or not visible");
    }
    @Test
    public void fillSignUpDetails() throws InterruptedException {
        EnterAccountInformation();
        //radio button mrs id= id_gender2 mr id= id_gender1
        String title="Mrs.";
        driver.findElement(By.id("id_gender2")).click();

        //input field
        String password = "123456";
        driver.findElement(By.id("password")).sendKeys(password);

        //radio button
        String birthDay="12.11.2001";
        WebElement testDropDown = driver.findElement(By.id("days"));
        Select dropdown= new Select(testDropDown);
        dropdown.selectByIndex(12);

        dropdown= new Select(driver.findElement(By.id("months")));
        // dropdown= (Select) driver.findElement(By.id("1"));  --> try like this for the shortest way
        dropdown.selectByIndex(11);

        dropdown= new Select(driver.findElement(By.id("years")));
        dropdown.selectByValue("2001");

        //Sign up for our newsletter! checkbox
     //   driver.findElement(By.xpath("//input[@value='1']")).click();

        WebElement element1 = driver.findElement(By.xpath("//input[@value='1']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element1);


        //Receive special offers from our partners! - checkbox
     //   driver.findElement(By.xpath("(//input[@value='1'])[2]")).click();
        executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//input[@value='1'])[2]")));

        //Address Information
        driver.findElement(By.id("first_name")).sendKeys("test");
        driver.findElement(By.id("last_name")).sendKeys("test");
        driver.findElement(By.id("company")).sendKeys("Amazon");
        driver.findElement(By.id("address1")).sendKeys("101 NE 51rd St.");
        driver.findElement(By.id("address2")).sendKeys("Apt 2020");

       // WebElement testDropDown4 =driver.findElement(By.id("country"));
        dropdown= new Select(driver.findElement(By.id("country")));
        dropdown.selectByValue("United States");


        driver.findElement(By.id("state")).sendKeys("New York");
        driver.findElement(By.id("city")).sendKeys("New York City");
        driver.findElement(By.id("zipcode")).sendKeys("45102");
        driver.findElement(By.id("mobile_number")).sendKeys("+123456789");

        //create account button
        //driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        //executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//input[@value='1'])[2]")));
        executor.executeScript("arguments[0].click()", driver.findElement(By.cssSelector("[data-qa='create-account']")));

        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertEquals("ACCOUNT CREATED!", driver.findElement(By.cssSelector("[data-qa='account-created']")).getText() , "Text is not visible or differenr than expected!" );

        driver.findElement(By.cssSelector(".btn.btn-primary")).click();



/*      15. Click 'Continue' button
        16. Verify that 'Logged in as username' is visible
        17. Click 'Delete Account' button
        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button*/


/*        Alert alert = driver.switchTo().alert();
        alert.dismiss();*/
        //executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div/div/div/span[@dir='auto']")));
        // driver.findElement(By.xpath("//div/div/div/span[@dir='auto']")).click();
        //driver.findElement(By.id("dismiss-button")).click();


        Assert.assertEquals("Logged in as test", driver.findElement(By.cssSelector(".fa.fa-user")).getText(), "Username looks different than you provided");

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
Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible

6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible


9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'


14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
 */