package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enter_From(String name, WebElement element) {
        element.sendKeys(name);
    }

    public void enter_To(String name, WebElement element) throws InterruptedException {
        Thread.sleep(2);
        element.sendKeys(name);
    }


    public void click_Searchbutton() {
        SearchBtn.click();
    }

    public void SelectDropdown(String visibleTextToBeSelected, String dropdownid) {

        Select childrensDropdown = new Select(driver.findElement(By.id(dropdownid)));


        boolean flag = childrensDropdown.getOptions().stream().anyMatch(item -> item.getText().equals(visibleTextToBeSelected));

        if (flag) {

            childrensDropdown.selectByVisibleText(visibleTextToBeSelected);
        }

    }

    public void clickonOnTripRadioButton(String radio) {

        if (radio.equals("RoundTrip")) {
            roundTrip.click();
        } else if (radio.equals("Multicity"))

            multicity.click();

    }

    public void clickOnRoundTrip() {
        roundTrip.click();
    }

    public void fill_Tripdetails(Map<String, String> map, String tripSelection) throws InterruptedException {


        clickonOnTripRadioButton(tripSelection);

        if (!tripSelection.equals("Multicity")) {
            enter_From(map.get("From"), from);
            enter_To(map.get("To"), to);
            enter_departdate(departdate);
        }
        if (!tripSelection.equals("OneWay") && !tripSelection.equals("Multicity")) {
            enter_ReturnOn(returnDate);
        }
        if (tripSelection.equalsIgnoreCase("Multicity")) {
            enter_From(map.get("From1"), from1);
            enter_To(map.get("To1"), to1);
            enter_departdate(departdate1);
            enter_From(map.get("From2"), from2);
            enter_To(map.get("To2"), to2);
            enter_departdate(departdate2);
            enter_From(map.get("From3"), from3);
            enter_To(map.get("To3"), to3);
            enter_departdate(departdate3);

        }


        SelectDropdown(map.get("Adult"), "Adults");
        SelectDropdown(map.get("Children"), "Childrens");
        SelectDropdown(map.get("Infants"), "Infants");
        if (!tripSelection.equals("Multicity")) {
            clickOnMoreOptionsLink();
        }
        SelectDropdown(map.get("Class_of_Travel"), "Class");
        click_Searchbutton();

        System.out.println("Verifying the git commit changes");

    }

    public void enter_ReturnOn(WebElement element) {
        element.click();
        CalendarDateSelection.click();

    }

    public void enter_departdate(WebElement element) {
        element.click();
        CalendarDateSelection.click();
    }

    public void clickOnMoreOptionsLink() {
        MoreOptionsLink.click();
    }

    @FindBy(xpath = "//*[@id='block_top_menu']")
    public WebElement oneway;
    @FindBy(xpath = "//*[@id='RoundTrip']")
    public WebElement roundTrip;
    @FindBy(xpath = "//*[@id='MultiCity']")
    public WebElement multicity;
    @FindBy(xpath = "//*[@id='FromTag' or @tabindex='5']")
    public WebElement from;
    @FindBy(xpath = "//*[@id='ToTag']")
    public WebElement to;
    @FindBy(xpath = "//*[@id='FromTag1']")
    public WebElement from1;
    @FindBy(xpath = "//*[@id='ToTag1']")
    public WebElement to1;
    @FindBy(xpath = "//*[@id='FromTag2']")
    public WebElement from2;
    @FindBy(xpath = "//*[@id='ToTag2']")
    public WebElement to2;
    @FindBy(xpath = "//*[@id='FromTag3']")
    public WebElement from3;
    @FindBy(xpath = "//*[@id='ToTag3']")
    public WebElement to3;
    @FindBy(xpath = "//*[@id=\"DepartDate1\"]")
    WebElement departdate1;
    @FindBy(xpath = "//*[@id=\"DepartDate2\"]")
    WebElement departdate2;
    @FindBy(xpath = "//*[@id=\"DepartDate3\"]")
    WebElement departdate3;
    @FindBy(xpath = "//*[@id=\"DepartDate\"]")
    WebElement departdate;
    @FindBy(xpath = "//*[@id='ReturnDate']")
    WebElement returnDate;
    @FindBy(xpath = "//*[@id='Adults']")
    public WebElement adults;
    @FindBy(xpath = "//*[@id='Childrens']")
    public WebElement children;
    @FindBy(xpath = "//*[@id='MoreOptionsLink']")
    WebElement MoreOptionsLink;
    @FindBy(xpath = "//*[@id='Class']")
    public WebElement classofTravel;
    @FindBy(xpath = "//*[@id='SearchBtn']")
    public WebElement SearchBtn;
    @FindBy(xpath = "//*[@id='block_top_menu']")
    WebElement PreferredAirline;
    @FindBy(xpath = "//*[text()=20]")
    WebElement CalendarDateSelection;

}
