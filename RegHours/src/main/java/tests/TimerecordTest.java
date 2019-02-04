/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class TimerecordTest {
    
    public static void main(String[] args) {
        
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        String currentTime = format.format(d);   
        System.out.println("Current time: " + currentTime);
 
        
        System.out.println("Current time function: " + currentTime());
        
    }
    
    private static String currentTime() {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
