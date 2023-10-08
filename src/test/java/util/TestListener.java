package util;

import base.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {}
    public void onTestSuccess(ITestResult iTestResult){}
    public void onTestFailure(ITestResult iTestResult){saveScreenShot();}
    public void onTestSkipped(ITestResult iTestResult){}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}
    @Override
    public void onStart(ITestContext iTestContext) {}
    @Override
    public void onFinish(ITestContext iTestContext) {}

    private void saveScreenShot(){
        WebDriver driver = DriverManager.getBrowserDriver();
        File screenCapture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                 ".//target/screenshots/"
                    + getCurrentTimeAsString() + ".png"));
        } catch (IOException e ){
            System.out.println(e.getMessage());
        }
    }
    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
