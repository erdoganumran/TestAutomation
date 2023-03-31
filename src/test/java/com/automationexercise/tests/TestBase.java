package com.automationexercise.tests;

import com.automationexercise.utilities.BrowserUtils;
import com.automationexercise.utilities.ConfigurationReader;
import com.automationexercise.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    protected static ExtentReports report;
    //this class is used to create HTML report file
    protected static ExtentHtmlReporter htmlReporter;
    //this will  define a test, enables adding logs, authors, test steps
    protected static ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        report= new ExtentReports();

        //create a report path
        String projectPath=System.getProperty("user.dir");
        //we will create a test-output folder and under of this folder 'report.html' file
        String path = projectPath + "/test-output/report.html";
        //if you want to keep previous version of screenshots and report you must name ypu folder as;
        // String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //String path = projectPath + "/test-output/report" + date+ ".html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Automation Exercise Smoke Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
    }
    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        actions= new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(ConfigurationReader.get("url"));
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //if test fails
        if (result.getStatus()==ITestResult.FAILURE){
            //record the name of failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());

            //add you screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());
        }
        Thread.sleep(2000);
        Driver.closeDriver();
    }


    @AfterTest
    public void teardown(){
        //this is when the report is actually created
        report.flush();
    }

}
