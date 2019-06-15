package java8;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class TestJavaDateAPI {

    public static void main(String[] args) {


        LocalDateTime localDAteTime= LocalDateTime.now();

        System.out.println("CurrentDataandTime "+localDAteTime);


        LocalDate localdate=localDAteTime.toLocalDate();

        System.out.println("localdate "+localdate);

        int getDayOfYear=localDAteTime.getDayOfYear();


        System.out.println("getDayOfYear "+getDayOfYear);



        int getDayOfMonth=localDAteTime.getDayOfMonth();


        System.out.println("getDayOfMonth "+getDayOfMonth);




        Month month=localDAteTime.getMonth();

        System.out.println("month   "+month);





    }
}
