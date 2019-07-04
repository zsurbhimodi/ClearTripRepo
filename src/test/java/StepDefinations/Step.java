package StepDefinations;

import Utility.BrowserUtility;
import Utility.ExcelUtility;
import Utility.PropertiesFileReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.HomePage;

import java.util.Map;
import java.util.Properties;

public class Step {

    PropertiesFileReader obj = new PropertiesFileReader();
    private WebDriver driver;
    HomePage homepage;

    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() throws Throwable {
        Properties properties = obj.getProperty();
        driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
    }


    @When("User select {string} trip and enter the required details and click on search")
    public void user_select_trip_and_enter_the_required_details_and_click_on_search(String string) throws Throwable {
        Properties properties = obj.getProperty();
        String filePath = properties.getProperty("testdatafilepath");
        Map<String, String> TestDataInMap = ExcelUtility.getTestDataInMap(filePath, properties.getProperty("sheetname"), string);
        homepage = new HomePage(driver);
        homepage.fill_Tripdetails(TestDataInMap, string);


    }

    @Then("Message displayed Login Successfully")
    public void message_displayed_Login_Successfully() throws Throwable {
        Properties properties = obj.getProperty();
        System.out.println("*************************");
        System.out.println(properties.getProperty("pageTitle"));
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println(driver.getTitle());
        System.out.println("*************************");
        Assert.assertTrue(properties.getProperty("pageTitle").equalsIgnoreCase(driver.getTitle()));
        driver.quit();

    }


}