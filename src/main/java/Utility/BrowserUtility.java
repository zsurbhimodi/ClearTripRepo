package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserUtility {


    public static WebDriver OpenBrowser(WebDriver driver, String browserName, String url) throws InterruptedException {

        if(browserName.equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Surbhi_Modi\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            Thread.sleep(5000);
            return driver;
        }else
        if(browserName.equals("IE"))
        {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\Surbhi_Modi\\Downloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
            DesiredCapabilities capabilities=new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "accept");
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver=new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.get(url);
            return driver;
        } else if(browserName.equals("Firefox"))
        {
            System.setProperty("webdriver.gecko.driver","C:\\Users\\Surbhi_Modi\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(url);
            return driver;
        }
        return null;
    }

    }




