package com.automationexercise.tests;

import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.DashboardPage;
import com.automationexercise.utilities.BrowserUtils;
import org.testng.annotations.Test;

public class TC6_ContactUs extends TestBase{

    @Test
    public void contactUs(){
       /* Test Case 6: Contact Us Form
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Contact Us' button*/
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.contactUs.click();

        ContactUsPage contactUsPage= new ContactUsPage();

        contactUsPage.fillOutContactPage();

    }

}
/*

5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
 */