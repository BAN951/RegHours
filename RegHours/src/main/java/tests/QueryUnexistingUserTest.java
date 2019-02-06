/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import net.reghours.datamodel.actions.UserManager;
import net.reghours.datamodel.entities.User;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class QueryUnexistingUserTest {
 
    public static void main(String[] args) {
        
        UserManager userManager = new UserManager();
        User user = userManager.getUserByUsername("Sifu");
        
    }
    
}
