/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.webservice.records;

import net.reghours.datamodel.entities.Timerecord;

/**
 *
 * @author admin
 */
public class AddRecordResponse {
    
    private String message; 
    private int status;
    private Timerecord record;
    
    public AddRecordResponse() {}

    public AddRecordResponse(String message, int status, Timerecord record) {
        this.message = message;
        this.status = status;
        this.record = record;
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

    public Timerecord getRecord() {
        return record;
    }

    public void setRecord(Timerecord record) {
        this.record = record;
    }
}
