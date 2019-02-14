/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class CalculateTheDifferenceBetweenTwoDates {
    
    public static void main(String[] args) throws ParseException {
       
         // Calculate the difference between two date and times
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date firstDate = formatter.parse("2019-02-03");
//        Date secondDate = formatter.parse("2019-02-03");
//        
//        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
//        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//        
//        System.out.println("Diff in days: " + diff);
        // ----------------------------------------- WORKS!! ------------
        
        // Now with time
//        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
//        Date time1 = f.parse("10:51:17.0");
//        Date time2 = f.parse("11:12:18.0");
//        
//        long diffM1 = Math.abs(time2.getTime() - time1.getTime());
//        long diffTime = TimeUnit.MINUTES.convert(diffM1, TimeUnit.MILLISECONDS);
//        
//        System.out.println("Diff test with time: " + diffTime);
        
        // Diff in date and time
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime1 = df.parse("2019-02-03 10:51:17.0");
        Date dateTime2 = df.parse("2019-02-03 17:35:26.0");
        
        long diffDT = Math.abs(dateTime2.getTime() - dateTime1.getTime());
        long d = TimeUnit.MINUTES.convert(diffDT, TimeUnit.MILLISECONDS);
        
        System.out.println("Difference in datetime: " + d);
    }
    
    
    
   
    
}
