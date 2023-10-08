package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Set;


public class Helper{
    WebDriver driver;
    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void returnToCalculatePage(){
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    };

    public void click(ArrayList<String> tabs){
        driver.switchTo().window(tabs.get(0));
    }

    public ArrayList<String> switchToANewBrowserTab(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return tabs;
    }

    public void returnToPreviousTab(){
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]);
    }
}
