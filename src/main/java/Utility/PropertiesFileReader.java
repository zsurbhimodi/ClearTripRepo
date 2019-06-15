package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

    public Properties getProperty() throws IOException
    {
        FileInputStream inputStream=null;
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Surbhi_Modi\\Downloads\\cucumberSeleniumFramework-master\\TestClearTrip\\src\\main\\resources\\config.properties"));
            properties.load(new FileInputStream("C:\\Users\\Surbhi_Modi\\Downloads\\cucumberSeleniumFramework-master\\TestClearTrip\\src\\main\\resources\\testdataconfig.properties"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return properties;
    }

}
