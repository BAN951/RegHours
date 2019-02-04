/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.validation;

import java.util.List;
import net.reghours.datamodel.actions.UserManager;
import net.reghours.datamodel.entities.User;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class UserValidator {
    
    public UserValidator() {}
    
    public boolean userExists(String username, String email) {
        
        UserManager userManager = new UserManager();
        List<User> users = userManager.getAllUsers();
        
        for (User u : users) {
            if (u.getUsername().equals(username) || u.getEmail().equals(email)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean userExists(String username) {
        
        UserManager userManager = new UserManager();
        List<User> users = userManager.getAllUsers();
        
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean loginPasswordCorrect(String username, String passwd) {
        
        UserManager userManager = new UserManager();
        User user = userManager.getUserByUsername(username);
        
        return user.comparePasswords(passwd);

    }
    
}
