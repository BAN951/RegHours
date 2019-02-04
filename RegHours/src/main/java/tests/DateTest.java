/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class DateTest {
    
    public static void main(String[] args) {
        System.out.println("New date: " + new Date());
        System.out.println("Simple date format: " + new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()));
    }
    
}
