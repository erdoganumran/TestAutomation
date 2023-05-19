package com.automationexercise.tests;

import com.automationexercise.pages.DashboardPage;
import com.automationexercise.utilities.BrowserUtils;
import com.automationexercise.utilities.ConfigurationReader;
import com.automationexercise.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.module.Configuration;
import java.util.List;
import java.util.Set;

public class TC7_VerifyTestCasesPage extends TestBase{

    @Test
    public void testCasePage(){
        Driver.get().get(ConfigurationReader.get("url"));
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Test Cases");
        BrowserUtils.waitFor(3);

      /*  Actions actions= new Actions(driver);
        actions.doubleClick();*/

    //    actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();


       // driver.findElement(By.cssSelector("#dismiss-button")).click();
        //#dismiss-button>div>svg>path
       // driver.switchTo().defaultContent();


/*
        Driver.get().switchTo().frame(1);
        Alert alert =Driver.get().switchTo().alert();
        alert.dismiss();

        Driver.get().findElement(By.cssSelector("#dismiss-button>div>svg>path")).click();*/
        BrowserUtils.waitFor(3);

        String expectedURL= "https://automationexercise.com/test_cases";
        Assert.assertEquals(Driver.get().getCurrentUrl(), expectedURL);



    }
}
/*
Test Case 7: Verify Test Cases Page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
 */