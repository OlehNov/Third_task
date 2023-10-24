package pages.googleCloud;

import base.BasePage;
import base.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalculatePage extends BasePage {

                                         // ***Locators and selectors***//

    //Google Cloud Pricing Calculator selectors//
    @FindBy(css = ".md-paginated>md-pagination-wrapper div.tab-holder.compute")
    WebElement computerEngineButton; //click

    @FindBy(css = "input[ng-model^='listingCtrl.computeServer.quantity']")
    WebElement amountOfInstancesInput; //input

    @FindBy(css = "input[ng-model^='listingCtrl.computeServer.label']")
    WebElement whatInstancesForInput; //input

    @FindBy(css="md-select[ng-model^='listingCtrl.computeServer.series'] .md-select-icon")
    WebElement seriesDropDownButton; //click

    @FindBy(css="md-select[ng-model^='listingCtrl.computeServer.instance'] .md-select-icon")
    WebElement machineTypeDropDownButton; //click

    @FindBy(css="md-checkbox[ng-model^='listingCtrl.computeServer.addGPUs'] .md-container")
    WebElement addGPUsCheckButton; //click

    @FindBy(css ="div[ng-if^='listingCtrl.computeServer.addGPUs'] .layout-column md-select[aria-label^='GPU type']")
    WebElement typeGPUDropDownButton; //click

    @FindBy(css = "md-select[placeholder^='Number of GPUs'] .md-select-icon")
    WebElement numberOfGPUDropDownButton; //click

    @FindBy(css = "md-select[ng-model^='listingCtrl.computeServer.ssd'] .md-select-icon")
    WebElement localSSDDropDownButton; //click

    @FindBy(css = "md-select[ng-model^='listingCtrl.computeServer.location'] .md-select-icon")
    WebElement datacenterLocationDropDownButton; //Click

    @FindBy(css = "md-select[ng-disabled^='listingCtrl.isCudDisabled'] .md-select-icon")
    WebElement committedUsageDropDownButton; //Click

    @FindBy(css = "button[ng-click^='listingCtrl.addComputeServer(ComputeEngineForm);']")
    WebElement addToEstimateButton; //Click

                                 //Right Side Estimate Window selectors//
    @FindBy(css = "div.cpc-cart-total .ng-binding")
    WebElement totalPrice; //Take text

    @FindBy(css = "div.cpc-cart-buttons #Email\\ Estimate")
    WebElement emailButton; //click

                                    //New Window Email Your Estimate
    @FindBy(css = "form[name='emailForm']>md-content input[type^='email']")
    WebElement estimateEmail; //input

    @FindBy(css = "md-dialog-actions.layout-row .md-raised.md-primary")
    WebElement estimateSendEmailButton; //Click


    public CalculatePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
                                                //***Methods***//

    // Google Cloud Pricing Calculator methods//

    public CalculatePage computerEngineClick(){
        googleCloudIFrame();
        waitAndClick(computerEngineButton);
        System.out.println("Click Engine Button");
        return this;
    }

    public CalculatePage ofInstancesInput(String amount){
        waitAndSendKeys(amountOfInstancesInput, amount);
        System.out.println("Amount Instances");
        return this;
    }

    public CalculatePage whatInstancesInput(String instances){
        waitAndSendKeys(whatInstancesForInput, instances);
        System.out.println("What Instances");
        return this;
    }

    public CalculatePage seriesListButtonClick(String locator, String serious_value){
        waitAndClick(seriesDropDownButton);
        System.out.println("Click Series_ List_Button");
        calcOptionsCSS(locator, serious_value);
        return this;
    }

    public CalculatePage machineTypeDropDownButtonClick(String locator, String machine_standard){
        waitAndClick(machineTypeDropDownButton);
        calcOptionsXpath(locator,machine_standard);
        System.out.println("Click Machine_Type_List Button");
        return this;
    }

    public CalculatePage GPUsCheckButtonClick(){
        waitAndClick(addGPUsCheckButton);
        System.out.println("Click GPUs CheckBox");
        return this;
    }

    public CalculatePage typeGPUDropDownButtonClick(String locator, String card_model){
        waitAndClick(typeGPUDropDownButton);
        System.out.println("Click GPU List_Button");
        calcOptionsCSS(locator, card_model);
        return this;
    }

    public CalculatePage numberOfGPUDropDownButtonClick(String locator, String gpu_amount){
        waitAndClick(numberOfGPUDropDownButton);
        calcOptionsCSS(locator, gpu_amount);
        System.out.println("Click Number_Of_GPU_List Button");
        return this;
    }

    public CalculatePage localSSDDropDownButtonClick(String locator, String ssd_amount){
        waitAndClick(localSSDDropDownButton);
        calcOptionsCSS(locator, ssd_amount);
        System.out.println("Click SSD List_Button");
        return this;
    }

    public CalculatePage datacenterLocationClick(String locator, String address){
        waitAndClick(datacenterLocationDropDownButton);
        calcOptionsCSS(locator, address);
        System.out.println("Click Data_Center_Location List_Button");
        return this;
    }

    public CalculatePage  committedUsageDropDownButtonClick(String locator, String years_amount){
        waitAndClick(committedUsageDropDownButton);
        calcOptionsCSS(locator, years_amount);
        System.out.println("Click Committed_Usage List_Button");
        return this;
    }

    public CalculatePage  addToEstimateButtonClick(){
        waitAndClick(addToEstimateButton);
        System.out.println("Click Add_To_Estimate Button");
        return this;
    }

                                     //Right Side Estimate Window methods
    public String readNewPasteTitle(){
        return wait.until(ExpectedConditions.visibilityOf(totalPrice)).getText();
    }

    public void emailButtonClick(){
        waitAndClick(emailButton);
        System.out.println("Click EstimateEmail Button");
    }
                                        //New Window Email Your Estimate
    public void estimateWindowEmailInput(){
        googleCloudIFrame();
        wait.until(ExpectedConditions.elementToBeClickable(estimateEmail)).sendKeys(Keys.CONTROL + "v");
        System.out.println("Enter generate email in Estimate field");
        driver.switchTo().defaultContent();
    }

    public void estimateSendEmailButtonClick(){
        googleCloudIFrame();
        waitAndClick(estimateSendEmailButton);
        System.out.println("Click Send Email Button");
        driver.switchTo().defaultContent();
    }

    public CalculatePage calcOptionsCSS(String locator, String value){
        String selector = String.format(locator, value);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector))).click();
        return this;
    }

    public CalculatePage calcOptionsXpath(String locator, String value){
        String selector = String.format(locator, value);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector))).click();
        return this;
    }

    public void enterGenerateYopMail(){
        estimateWindowEmailInput();
        estimateSendEmailButtonClick();
    }
    public void googleCloudIFrame(){
        firstCloudFrame();
        secondCloudFrame();
    }
    public void firstCloudFrame(){
        calculatePageIFrame(Locators.FIRST_CALCULATE_IFRAME);
    }
    public void secondCloudFrame(){
        driver.switchTo().frame(driver.findElement(By.id(Locators.SECOND_CALCULATE_IFRAME)));
    }
}
