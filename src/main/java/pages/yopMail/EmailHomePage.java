package pages.yopMail;

import base.BasePage;
import base.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofMillis;

public class EmailHomePage extends BasePage {

    @FindBy(css = "tbody>:nth-child(2)>:nth-child(2)>h3")
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

    public void checkEmailInPost(){
        checkInboxClick();
        new WebDriverWait(driver, ofMillis(5000)).pollingEvery(ofMillis(500))
                .until(condition -> {
                    emailRefreshClick();
                    return getEmailAmount().equals("1 mail");
                });
    }

    public EmailHomePage checkInboxClick() {
        waitAndClick(checkInbox);
        System.out.println("Click check inbox Button");
        return this;
    }

    public void iFrameEmailField(){
        calculatePageIFrame(Locators.YOPMAIL_IFRAME);
    }
}