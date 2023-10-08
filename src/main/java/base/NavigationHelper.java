package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Set;

public class NavigationHelper {
    WebDriver driver;
    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void returnToCalculatePage(){
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    };

    public NavigationHelper click(ArrayList<String> tabs){
        driver.switchTo().window(tabs.get(0));
        return this;
    }

    public ArrayList<String> switchToANewBrowserTab(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return tabs;
    }

    public NavigationHelper returnToPreviousTab(){
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]);
        return this;
    }

    public NavigationHelper refreshBrowserPage(){
        driver.navigate().refresh();
        return this;
    }

}
