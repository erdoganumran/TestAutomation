package com.automationexercise.tests;

import com.automationexercise.pages.DashboardPage;
import com.automationexercise.utilities.BrowserUtils;
import com.automationexercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v108.input.model.DragDataItem;
import org.testng.annotations.Test;

import java.util.List;

public class TC8_VerifyAllProductsAndDetails extends TestBase{

    @Test
    public void productPage(){
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Products");


        driver.switchTo().defaultContent();
    }

}
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
 */