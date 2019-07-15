package StepDefinations;

import TestBase.TestBaseClass;
import Utility.BrowserUtility;
import Utility.ExcelUtility;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pageobject.HomePage;
import java.util.Map;


public class Step extends TestBaseClass {

    Logger log = Logger.getLogger(Step.class);
    public HomePage homepage = null;

    @Before
    public void setUp() throws Throwable {
        driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
        homepage = new HomePage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() throws Throwable {
        log.info("Opened URL successfully");
        Assert.assertEquals(driver.getCurrentUrl(), properties.getProperty("browser.baseURL"));

    }

    @When("User select {string} trip and enter the required details and click on search")
    public void user_select_trip_and_enter_the_required_details_and_click_on_search(String string) throws Throwable {

        String filePath = properties.getProperty("testdatafilepath");
        Map<String, String> TestDataInMap = ExcelUtility.getTestDataInMap(filePath, properties.getProperty("sheetname"), string);
        System.out.println(string.equals("OneWay"));
        homepage.fillTripDetails(TestDataInMap, string);
    }

    @Then("Message displayed Login Successfully")
    public void message_displayed_Login_Successfully() throws Throwable {
        log.info("Verified the pageTitle");
        Assert.assertTrue(properties.getProperty("pageTitle").equalsIgnoreCase(driver.getTitle()));
    }


}