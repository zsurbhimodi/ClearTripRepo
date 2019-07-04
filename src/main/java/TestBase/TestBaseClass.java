/*
package TestBase;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.testng.annotations.Test;

import java.util.Map;

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

}
*/
