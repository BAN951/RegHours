/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.rs.webservice.records;

import java.util.List;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class GetRecordsResponse {
    
    private String message;
    private int status;
    private List records;
    
    public GetRecordsResponse() {}
    
    public GetRecordsResponse(String message, int status, List records) {
        this.message = message;
        this.status = status;
        this.records = records;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }
}
