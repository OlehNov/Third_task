package tests;


import base.*;
import objects.ComputerEngine;
import objects.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.googleCloud.CalculatePage;
import pages.googleCloud.CloudMainPage;
import pages.googleCloud.CloudSearchResult;
import pages.yopMail.EmailHomePage;
import pages.yopMail.Yopmail;
import util.TestListener;
import java.util.ArrayList;
@Listeners({TestListener.class})
public class CloudTest extends BaseTest{
    public static final String YOP_MAIL = "https://yopmail.com/en/email-generator";
    public  static final CloudMainPage cloudMainPage = new CloudMainPage(driver);
    public  static final CloudSearchResult searchResult = new CloudSearchResult(driver);
    public  static final CalculatePage calculatePage = new CalculatePage(driver);
    public  static final Yopmail yopmail = new Yopmail(driver);
    public static final NavigationHelper navigationHelper = new NavigationHelper(driver);
    public static final EmailHomePage emailHomePage = new EmailHomePage(driver);
                                 // Test Variables //
    public String searchText  = "Google Cloud Platform Pricing Calculator";
    public static final String TEST_PROPERTIES = "firstConfig.properties";

    @BeforeMethod
    public void startTest(){
        setUp(driver);
    }

    @Test
    public void createNewPaste(){
        PropertiesReader propertiesReader = new PropertiesReader(TEST_PROPERTIES);
        ComputerEngine businessObject = new ComputerEngine(
                propertiesReader.getProperty("instances"),
                propertiesReader.getProperty("amount"),
                propertiesReader.getProperty("serious.value"),
                propertiesReader.getProperty("machine.standard"),
                propertiesReader.getProperty("card.model"),
                propertiesReader.getProperty("gpu.amount"),
                propertiesReader.getProperty("ssd.amount"),
                propertiesReader.getProperty("address"),
                propertiesReader.getProperty("years.amount")
        );
        cloudMainPage.calculatorSearch(searchText);
        searchResult.searchResultClick();
        calculatePage
                .computerEngineClick()
                .whatInstancesInput(businessObject.getInstances())
                .ofInstancesInput(businessObject.getAmount())
                .seriesListButtonClick(Locators.SERIOUS, businessObject.getSeriousValue())
                .machineTypeDropDownButtonClick(Locators.MACHINE, businessObject.getMachineStandard())
                .GPUsCheckButtonClick()
                .typeGPUDropDownButtonClick(Locators.VIDEO_CARD, businessObject.getCardModel())
                .numberOfGPUDropDownButtonClick(Locators.GPU, businessObject.getGpuAmount())
                .localSSDDropDownButtonClick(Locators.SSD, businessObject.getSsdAmount())
                .datacenterLocationClick(Locators.LOCATION, businessObject.getAddress())
                .committedUsageDropDownButtonClick(Locators.YEARS, businessObject.getYearsAmount())
                .addToEstimateButtonClick()
                .emailButtonClick();
        String expect_monthly_cost = calculatePage.readNewPasteTitle();
        ArrayList<String> tabs = navigationHelper.switchToANewBrowserTab();
        yopmail.yopMailPageOpen(YOP_MAIL)
                .generateEmail();
        navigationHelper
                .click(tabs)
                .returnToCalculatePage();
        calculatePage.enterGenerateYopMail();
        navigationHelper
                .returnToPreviousTab()
                .refreshBrowserPage();
        emailHomePage.checkEmailInPost();
        Assert.assertTrue(expect_monthly_cost.contains(emailHomePage.getYopMailCost()));
    }

    @AfterMethod(alwaysRun = true)
    public void finishTest(){
        closeBrowser(driver);
    }
}