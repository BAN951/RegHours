/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.webservice.records;

/**
 *
 * @author admin
 */
public class AddRecordRequest {
    
    private String username; 
    private String passwd; 
    private String type;
    
    public AddRecordRequest() {}
    
    public AddRecordRequest(String username, String passwd, String type) {
        this.username = username;
        this.passwd = passwd;
        this.type = type;
    }
    
    public boolean checkTypeCorrect(String type) {
        String t = type.toLowerCase();
        return ("entrada".equals(t) || "salida".equals(t));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
