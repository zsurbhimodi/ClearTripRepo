package TestBase;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class TestBaseClass {
   @Test
    public void test1() throws Exception {


        Fillo fillo=new Fillo();
       Map<String,String> TestDataInMap=new TreeMap<String,String>();

        Connection connection=fillo.getConnection("C:\\Users\\Surbhi_Modi\\Documents\\ClearTrip1.xlsx");
        String strQuery="Select * from ClearTripData where TripType='RoundTrip'";
        Recordset recordset=connection.executeQuery(strQuery);

        while(recordset.next()){


            for(String field:recordset.getFieldNames())
            {
                TestDataInMap.put(field, recordset.getField(field));
            }


            for(Map.Entry m:TestDataInMap.entrySet())
            {
                System.out.println(m.getKey()+" "+m.getValue());
            }



            System.out.println(recordset.getField("Adult"));
        }

        recordset.close();
        connection.close();

    }

  /*  @Test(dataProvider = "data")
    public void integrationTest(Map<Object, Object> map) {
        System.out.println("-------------Test case started ----------------");
        System.out.println(map.get("TripType"));
        System.out.println(map.get("From"));
        System.out.println(map.get("To"));

        System.out.println("-------------Test case Ended ----------------");
        try {
            String Browser=getPropertyData().getProperty("browser");
            System.out.println(Browser);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public Properties getPropertyData() throws IOException
    {
        FileInputStream inputStream=null;
        Properties properties = new Properties();
        try {
         //   properties.load(new FileInputStream(""));
            properties.load(new FileInputStream("C:\\Users\\Surbhi_Modi\\Downloads\\cucumberSeleniumFramework-master\\TestClearTrip\\src\\main\\resources\\config.properties"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return properties;
    }


    @DataProvider(name = "data")
    public Object[][] dataSupplier() throws IOException {

        File file = new File("C:\\Users\\Surbhi_Modi\\Documents\\ClearTrip1.xlsx");
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int lastRowNum = sheet.getLastRowNum() ;
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        Object[][] obj = new Object[lastRowNum][1];

        for (int i = 0; i < lastRowNum; i++) {
            Map<Object, Object> datamap = new HashMap<>();
            for (int j = 0; j < lastCellNum; j++) {
                datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
            }
            obj[i][0] = datamap;

        }
        return  obj;
    }*/
}
