package pages.googleCloud;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CloudMainPage extends BasePage {

    // ***Locators and selectors***
    @FindBy(xpath = "//input[@aria-label='Search']")
    WebElement searchButton; //click

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchInput; //input

    public CloudMainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Methods
    public CloudMainPage searchButtonClick(){
        waitAndClick(searchButton);
        System.out.println("Click Search_Button");
        return this;
    }

    public CloudMainPage searchTextInput(String searchText){
        waitAndSendKeys(searchInput, searchText);
        System.out.println("Text entered into the Search_Field");
        return this;
    }

    public CloudMainPage pressEnterButtonInput(){
        wait.until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(Keys.ENTER);
        System.out.println("Click Enter_Button");
        return this;
    }

    public void calculatorSearch(String searchText){
        searchButtonClick();
        searchTextInput(searchText);
        pressEnterButtonInput();
    }
}
