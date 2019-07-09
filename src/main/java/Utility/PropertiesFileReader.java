package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {


    public static Properties getProperty()
    {
        FileInputStream inputStream=null;
        Properties properties = new Properties();
        try {

            System.out.println(System.getProperty("user.dir"));

            properties.load(new FileInputStream(System.getProperty("user.dir")+ProjectConstant.CONFIG_FILE));
            properties.load(new FileInputStream(System.getProperty("user.dir")+ProjectConstant.TESTDATE_CONFIG));
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        return properties;
    }

}
