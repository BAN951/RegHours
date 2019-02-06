/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.webservice;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.reghours.datamodel.actions.RecordsManager;
import net.reghours.datamodel.actions.UserManager;
import net.reghours.datamodel.entities.Timerecord;
import net.reghours.datamodel.entities.User;
import net.reghours.validation.UserValidator;
import net.reghours.webservice.records.AddRecordRequest;
import net.reghours.webservice.records.AddRecordResponse;
import net.reghours.webservice.records.GetRecordsRequest;
import net.reghours.webservice.records.GetRecordsResponse;

/**
 *
 * @author Benjamin Adam Nagy
 */
@Path("/records")
public class TimerecordsService {
    
    private final UserManager userManager = new UserManager();
    private final UserValidator userValidator = new UserValidator();
    private final RecordsManager recordsManager = new RecordsManager();
    
    @POST
    @Path("/getRecords")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GetRecordsResponse getRecords(GetRecordsRequest request) {

        if(request == null) 
            return new GetRecordsResponse("Bad request", 400, null);
        
        User user = userManager.getUserByUsername(request.getUsername());
        
        if(user != null && userValidator.passwordCorrect(request.getUsername(), request.getPasswd())) {

            List<Timerecord> records = recordsManager.getTimerecords(request.getUsername());
            return new GetRecordsResponse("OK", 200, records);
        }
        else {
            return new GetRecordsResponse("Forbidden", 403, null);
        }
    }
    
    @POST
    @Path("/addRecord")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AddRecordResponse addRecord(AddRecordRequest request) {
        
        if(request == null)
            return new AddRecordResponse("Bad request", 400, null);
        
        User user = userManager.getUserByUsername(request.getUsername());
        
        if(user != null && userValidator.passwordCorrect(request.getUsername(), request.getPasswd())) {
            if(request.checkTypeCorrect(request.getType())) {
                
                Timerecord record = recordsManager.insertTimerecord(request.getType(), user);
                return new AddRecordResponse("OK", 200, record);
            }
        }

        return new AddRecordResponse("Forbidden", 403, null);
    }
    
    
}
