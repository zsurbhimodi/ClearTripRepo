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

            System.out.println(System.getProperty("user.dir"));
          //  properties.load(new FileInputStream("C:\\Users\\Surbhi_Modi\\Downloads\\cucumberSeleniumFramework-master\\TestClearTrip\\src\\main\\resources\\config.properties"));
            properties.load(new FileInputStream(System.getProperty("user.dir")+ProjectConstant.CONFIG_FILE));
            properties.load(new FileInputStream(System.getProperty("user.dir")+ProjectConstant.TESTDATE_CONFIG));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return properties;
    }

}
