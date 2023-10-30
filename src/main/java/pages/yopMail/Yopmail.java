package pages.yopMail;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Yopmail extends BasePage {

    // ***Locators and selectors***//

    @FindBy(css = ".nw>button[onclick^='newgen();']")
    public static WebElement newButton; //click
    @FindBy(xpath = "//button[@id='cprnd']")
    WebElement copyButton; //click

    //Methods
    public Yopmail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Yopmail newRefreshButtonClick() {
        waitAndClick(newButton);
        System.out.println("Click new Button");
        return this;
    }

    public Yopmail copyButtonClick() {
        waitAndClick(copyButton);
        System.out.println("Click copy Button");
        return this;
    }

    public Yopmail yopMailPageOpen(String yopmail_url){
        driver.get(yopmail_url);
        return this;
    }

    public void generateEmail(){
        //Scroll page to the generate button
        js.executeScript("arguments[0].scrollIntoView(true);", newButton);
        //Generate email
        newRefreshButtonClick();
        copyButtonClick();
    }
}
