/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.validation.ejbs;

import javax.ejb.Stateful;

/**
 *
 * @author Benjamin Adam Nagy
 */
@Stateful
public class LoginBean implements LoginBeanLocal {

    private String username; 
    private String passwd; 
    
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }

    @Override
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
