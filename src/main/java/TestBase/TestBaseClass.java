package TestBase;


import Utility.PropertiesFileReader;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class TestBaseClass{
    public WebDriver driver;
   public  PropertiesFileReader propertiesFileReader = new PropertiesFileReader();
   public Properties properties = propertiesFileReader.getProperty();



}