package pages.googleCloud;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudSearchResult extends BasePage {

    @FindBy(xpath = "//div[@class = 'gs-title']//*[text()='Google Cloud Pricing Calculator']")
    WebElement firstSearchResult; //click

    public CloudSearchResult(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CloudSearchResult searchResultClick(){
        waitAndClick(firstSearchResult);
        System.out.println("Click First_Search_Result");
        return this;
    }
}
