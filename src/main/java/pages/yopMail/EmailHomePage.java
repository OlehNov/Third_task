package pages.yopMail;

import base.BasePage;
import base.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailHomePage extends BasePage {

    @FindBy(css = "tbody>:nth-child(2)>:nth-child(2)>h3") // This is a table, so there are many tabs and identical locators
    WebElement yopMailMonthlyCost; //text
    @FindBy(xpath = "//button[@id='refresh']")
    WebElement refreshButton;//click
    @FindBy (xpath="//div[@id=\"nbmail\"]")
    WebElement emailInformation;

    @FindBy(css = ".nw>button[onclick^='egengo();']")
    WebElement checkInbox; //click
    public EmailHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public EmailHomePage emailRefreshClick() {
        waitAndClick(refreshButton);
        System.out.println("Click refresh email Button");
        return this;
    }

    public String getYopMailCost(){
        iFrameEmailField();
        return wait.until(ExpectedConditions.visibilityOf(yopMailMonthlyCost)).getText();
    }

    public String getEmailAmount(){
        return emailInformation.getText();
    }

    public void checkCost(){
        checkInboxClick();
        int i = 1;
        int maxAttempts = 5;
        while (!getEmailAmount().equals("1 mail") && i <= maxAttempts) {
            emailRefreshClick();
            i++;
        }
    }

    public EmailHomePage checkInboxClick() {
        waitAndClick(checkInbox);
        System.out.println("Click check inbox Button");
        return this;
    }

    public void iFrameEmailField(){
        calculatePageIFrame(Locators.YOPMAIL_IFRAME);
    }

    public EmailHomePage checkPopUpDisplayed(){
        try {
            WebElement popup = driver.findElement(By.xpath(Yopmail.popupWindow));
            if (popup.isDisplayed()) {
                popup.findElement(By.xpath(Yopmail.popupCloseButton)).click();
            }
        } catch (org.openqa.selenium.NoSuchElementException continue_test) {}
        checkCost();
        return this;
    }
}
