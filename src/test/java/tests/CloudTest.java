package tests;

import base.BasePage;
import base.Helper;
import base.Locators;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.googleCloud.CalculatePage;
import pages.googleCloud.CloudMainPage;
import pages.googleCloud.CloudSearchResult;
import pages.yopMail.EmailHomePage;
import pages.yopMail.Yopmail;
import java.util.ArrayList;

public class CloudTest{
    public static final String CLOUD_URL = "https://cloud.google.com/";
    public static final String YOP_MAIL = "https://yopmail.com/en/email-generator";
    public  static final WebDriver driver = new ChromeDriver();
    public  static final CloudMainPage cloudMainPage = new CloudMainPage(driver);
    public  static final CloudSearchResult searchResult = new CloudSearchResult(driver);
    public  static final CalculatePage calculatePage = new CalculatePage(driver);
    public  static final Yopmail yopmail = new Yopmail(driver);
    public static final Helper helper = new Helper(driver);
    public static final BasePage basePage = new BasePage(driver);
    public static final EmailHomePage emailHomePage = new EmailHomePage(driver);
                                 // Test Variables //
    public static  final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";
    public static  final String AMOUNT = "4";
    public static  final String INSTANCES = "leave blank";
    public static  final String SERIOUS_VALUE = "n1";
    public static  final String MACHINE_STANDARD = "CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8";
    public static  final String CARD_MODEL = "NVIDIA_TESLA_T4";
    public static  final String GPU_AMOUNT = "1";
    public static  final String SSD_AMOUNT = "2";
    public static  final String ADDRESS = "europe-west3";
    public static  final String YEARS_AMOUNT = "1";

    @Before
    public void start(){
        basePage.googleCloudPageOpen(CLOUD_URL);
        basePage.maximizeWindow();
    }

    @Test
    public void createNewPaste(){
        cloudMainPage.calculatorSearch(SEARCH_TEXT);
        searchResult.searchResultClick();
        calculatePage
                .computerEngineClick()
                .whatInstancesInput(INSTANCES)
                .ofInstancesInput(AMOUNT)
                .seriesListButtonClick(Locators.SERIOUS, SERIOUS_VALUE)
                .machineTypeDropDownButtonClick(Locators.MACHINE, MACHINE_STANDARD)
                .GPUsCheckButtonClick()
                .typeGPUDropDownButtonClick(Locators.VIDEO_CARD, CARD_MODEL)
                .numberOfGPUDropDownButtonClick(Locators.GPU, GPU_AMOUNT)
                .localSSDDropDownButtonClick(Locators.SSD, SSD_AMOUNT)
                .datacenterLocationClick(Locators.LOCATION, ADDRESS)
                .committedUsageDropDownButtonClick(Locators.YEARS, YEARS_AMOUNT)
                .addToEstimateButtonClick()
                .emailButtonClick();
        String expect_monthly_cost = calculatePage.readNewPasteTitle();
        ArrayList<String> tabs = helper.switchToANewBrowserTab();
        yopmail.yopMailPageOpen(YOP_MAIL)
                .generateEmail();
        helper.click(tabs);
        helper.returnToCalculatePage();
        calculatePage.enterGenerateYopMail();
        helper.returnToPreviousTab();
        emailHomePage.checkPopUpDisplayed();
        Assert.assertTrue(expect_monthly_cost.contains(emailHomePage.getYopMailCost()));
    }
    @After
    public void end(){
        basePage.closeBrowser();
    }
}
