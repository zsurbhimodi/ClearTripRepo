package pageobject;

import TestBase.TestBaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class HomePage extends TestBaseClass {

    Logger log = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        log.info("Driver is initialized in Homepage");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void enterFrom(String name, WebElement element) {
        element.sendKeys(name);
    }

    private void enterTo(String name, WebElement element) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        element.sendKeys(name);
    }

    private void clickSearchbutton() {
        SearchBtn.click();
    }

    private void SelectDropdown(String visibleTextToBeSelected, String dropdownid) {
        Select childrensDropdown = new Select(driver.findElement(By.id(dropdownid)));
        boolean flag = childrensDropdown.getOptions().stream().anyMatch(item -> item.getText().equals(visibleTextToBeSelected));
        if (flag) {
            childrensDropdown.selectByVisibleText(visibleTextToBeSelected);
        }
    }

    private void clickonOnTripRadioButton(String radio) {
        if (radio.equals(properties.getProperty("RoundTrip"))) {
            clickOnRoundTrip();
        } else if (radio.equals(properties.getProperty("Multicity")))
            multicity.click();
    }

    private void clickOnRoundTrip() {
        roundTrip.click();
    }

    public void fillTripDetails(Map<String, String> map, String tripSelection) throws InterruptedException {
        clickonOnTripRadioButton(tripSelection);
        selectFRomAndTo(map, tripSelection);
        selectTheNoOfPassengersAndAdditionalDetails(map, tripSelection);
    }

    private void selectTheNoOfPassengersAndAdditionalDetails(Map<String, String> map, String tripSelection) {
        SelectDropdown(map.get("Adult"), properties.getProperty("Adults"));
        SelectDropdown(map.get("Children"), properties.getProperty("Childrens"));
        SelectDropdown(map.get("Infants"), properties.getProperty("Infants"));
        if (!tripSelection.equals(properties.getProperty("Multicity"))) {
            clickOnMoreOptionsLink();
        }
        SelectDropdown(map.get("Class_of_Travel"), properties.getProperty("Class"));
        clickSearchbutton();
    }

    private void selectFRomAndTo(Map<String, String> map, String tripSelection) throws InterruptedException {
        if (!tripSelection.equals(properties.getProperty("Multicity"))) {
            enterFrom(map.get("From"), from);
            enterTo(map.get("To"), to);
            enterDepartDate(departdate);
        }
        if (!tripSelection.equals(properties.getProperty("OneWay")) && !tripSelection.equals(properties.getProperty("Multicity"))) {
            enter_ReturnOn(returnDate);
        }
        if (tripSelection.equalsIgnoreCase(properties.getProperty("Multicity"))) {
            enterFrom(map.get("From1"), from1);
            enterTo(map.get("To1"), to1);
            enterDepartDate(departdate1);
            enterFrom(map.get("From2"), from2);
            enterTo(map.get("To2"), to2);
            enterDepartDate(departdate2);
            enterFrom(map.get("From3"), from3);
            enterTo(map.get("To3"), to3);
            enterDepartDate(departdate3);
        }
    }

    private void enter_ReturnOn(WebElement element) {
        element.click();
        CalendarDateSelection.click();

    }

    public void enterDepartDate(WebElement element) {
        element.click();
        CalendarDateSelection.click();
    }

    public void clickOnMoreOptionsLink() {
        MoreOptionsLink.click();
    }

    @FindBy(xpath = "//*[@id='block_top_menu']")
    private WebElement oneway;

    @FindBy(xpath = "//*[@id='RoundTrip']")
    private WebElement roundTrip;

    @FindBy(xpath = "//*[@id='MultiCity']")
    private WebElement multicity;

    @FindBy(xpath = "//*[@id='FromTag' or @tabindex='5']")
    private WebElement from;

    @FindBy(xpath = "//*[@id='ToTag']")
    public WebElement to;

    @FindBy(xpath = "//*[@id='FromTag1']")
    public WebElement from1;

    @FindBy(xpath = "//*[@id='ToTag1']")
    private WebElement to1;

    @FindBy(xpath = "//*[@id='FromTag2']")
    private WebElement from2;

    @FindBy(xpath = "//*[@id='ToTag2']")
    private WebElement to2;

    @FindBy(xpath = "//*[@id='FromTag3']")
    private WebElement from3;

    @FindBy(xpath = "//*[@id='ToTag3']")
    private WebElement to3;

    @FindBy(xpath = "//*[@id=\"DepartDate1\"]")
    private WebElement departdate1;

    @FindBy(xpath = "//*[@id=\"DepartDate2\"]")
    private WebElement departdate2;

    @FindBy(xpath = "//*[@id=\"DepartDate3\"]")
    private WebElement departdate3;

    @FindBy(xpath = "//*[@id=\"DepartDate\"]")
    private WebElement departdate;

    @FindBy(xpath = "//*[@id='ReturnDate']")
    private WebElement returnDate;

    @FindBy(xpath = "//*[@id='Adults']")
    private WebElement adults;

    @FindBy(xpath = "//*[@id='Childrens']")
    private WebElement children;

    @FindBy(xpath = "//*[@id='MoreOptionsLink']")
    private WebElement MoreOptionsLink;

    @FindBy(xpath = "//*[@id='Class']")
    private WebElement classofTravel;

    @FindBy(xpath = "//*[@id='SearchBtn']")
    private WebElement SearchBtn;

    @FindBy(xpath = "//*[@id='block_top_menu']")
    private WebElement PreferredAirline;

    @FindBy(xpath = "//*[text()=19]")
    private WebElement CalendarDateSelection;

}
