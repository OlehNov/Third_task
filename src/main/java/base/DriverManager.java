package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    public static WebDriver driver;
    public DriverManager(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver getDriver(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
    public static WebDriver getBrowserDriver(){
        return driver;
    }
}
