package tests;

import base.DriverManager;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    public static final WebDriver driver = DriverManager.getDriver("chrome");

    public static final String CLOUD_URL = "https://cloud.google.com/";

    public static void setUp(WebDriver driver){
        driver.get(CLOUD_URL);
        driver.manage().window().maximize();
    }

    public void closeBrowser(WebDriver driver){
        driver.quit();
    }
}


