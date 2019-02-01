/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.validation;

import java.util.List;
import net.reghours.datamodel.actions.UserList;
import net.reghours.datamodel.entities.User;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class UserValidator {
    
    public UserValidator() {}
    
    public boolean userExists(String username, String email) {
        
        UserList userList = new UserList();
        List<User> users = userList.getAllUsers();
        boolean exists = false;
        
        for (User u : users) {
            if (u.getUsername().equals(username) || u.getEmail().equals(email)) {
                exists = true;
            }
        }
        
        return exists;
    }
    
    public boolean userExists(String username) {
        
        UserList userList = new UserList();
        List<User> users = userList.getAllUsers();
        boolean exists = false;
        
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                exists = true;
            }
        }
        
        return exists;
    }
    
    public boolean loginPasswordCorrect(String username, String passwd) {
        
        UserList userList = new UserList();
        User user = userList.getUserByUsername(username);
        
        if(user != null) {
            String passwdHash = DigestUtils.sha256Hex(passwd);
            return user.getPasswd().equals(passwdHash);
        } 
        else {
            return false;
        }
    }
    
}
