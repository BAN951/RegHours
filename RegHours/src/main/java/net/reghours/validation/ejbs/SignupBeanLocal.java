/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.validation.ejbs;

import javax.ejb.Local;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import net.reghours.validation.validators.Email;
import net.reghours.validation.validators.Password;
import net.reghours.validation.validators.Username;

/**
 *
 * @author Benjamin Adam Nagy
 */
@Local
public interface SignupBeanLocal {
    
    @NotNull(message = "Username can not be empty")
    @Size(min = 5, max = 32, message = "Username must have a length between 5 and 32 characters")
    @Username(message = "Incorrect username")
    public String getUsername();
    
    @NotNull(message = "First name can not be empty")
    @Size(min = 2, max = 48, message = "Your first name on this page must have a length between 2 and 48 characters")
    public String getFirstname();
    
    @NotNull(message = "Last name can not be empty")
    public String getLastname();
    
    @NotNull(message = "Email can not be empty")
    @Email(message = "Incorrect email. Please make sure your write the email in the correct format")
    public String getEmail();
    
    @NotNull(message = "Password can not be empty")
    @Size(min = 5, max = 35, message="Your password must have a minimun length of 5 characters and a maximum of 35 characters")
    @Password(message = "Incorrect password. Your password must contain lowercase letter/s, "
            + "upparcase letter/s, number/s and a special character (ex: @, #, etc...)")
    public String getPasswd();
    
    public void setUsername(String username);
    public void setFirstname(String firstname);
    public void setLastname(String lastname);
    public void setEmail(String email);
    public void setPasswd(String passwd); 
    
}
