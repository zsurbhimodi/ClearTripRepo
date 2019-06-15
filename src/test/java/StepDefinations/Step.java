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
        System.out.println("*******************************");
        System.out.println(System.getProperty("user.dir"));
        System.out.println("*******************************");
        driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
    }


    @When("User select {string} trip and enter the required details and click on search")
    public void user_select_trip_and_enter_the_required_details_and_click_on_search(String string) throws Throwable {
        Properties properties = obj.getProperty();

        String filePath = properties.getProperty("testdatafilepath");
        Map<String, String> TestDataInMap = ExcelUtility.getTestDataInMap(filePath, properties.getProperty("sheetname"), string);
        homepage = new HomePage(driver);
        homepage.fill_Tripdetails(TestDataInMap,string);
/*
        if (string.equalsIgnoreCase("OneWay")) {

            homepage.fill_Onewaydetails(TestDataInMap,string);
        } else if (string.equalsIgnoreCase("RoundTrip")){
            homepage.fill_RoundTripdetails(TestDataInMap);

        }
*/

    }

    @Then("Message displayed Login Successfully")
    public void message_displayed_Login_Successfully() throws Throwable{

        Properties properties = obj.getProperty();
        System.out.println("*************************");
        System.out.println(properties.getProperty("pageTitle"));
        System.out.println("*************************");


        System.out.println("*************************");

        System.out.println(driver.getTitle());


        System.out.println("*************************");
        Assert.assertTrue(properties.getProperty("pageTitle").equalsIgnoreCase(driver.getTitle()));


    }






















   /* @When("^User select oneway trip nad enter the required details and click on search$")
    public void user_select_oneway_trip_nad_enter_the_required_details_and_click_on_search() throws Throwable {


        HomePage homepage;
        homepage = new HomePage(driver);
       // homepage.fill_Onewaydetails();


       *//* driver.findElement(By.id("FromTag")).sendKeys("Pune");
        driver.findElement(By.id("ToTag")).sendKeys("Mumbai");

        driver.findElement(By.xpath("//*[@title=\"Depart date\"]")).click();
        driver.findElement(By.xpath("//*[text()=20]")).click();

        Select adultDropdown = new Select(driver.findElement(By.id("Adults")));
        adultDropdown.selectByIndex(1);


        Select childrensDropdown = new Select(driver.findElement(By.id("Childrens")));
        childrensDropdown.selectByIndex(1);

        Select infantsDropdown = new Select(driver.findElement(By.id("Infants")));
        infantsDropdown.selectByIndex(1);

        driver.findElement(By.id("MoreOptionsLink")).click();

        Select classofTravelDropdown = new Select(driver.findElement(By.id("Class")));
        classofTravelDropdown.selectByIndex(1);*//*



    }

    @Then("^The flights according to seach is expected to be displayed$")
    public void the_flights_according_to_seach_is_expected_to_be_displayed() throws Throwable {
      //  driver.findElement(By.id("SearchBtn")).click();
    }*/

}