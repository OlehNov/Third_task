package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    public static WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }

    public void waitAndClick(WebElement locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void waitAndSendKeys(WebElement locator, String value){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(value);
    }
    public void calculatePageIFrame(String locator){
        driver.switchTo().frame(driver.findElement(By.cssSelector(locator)));
    }
}
