/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.webservice;

import java.util.Date;
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
import static net.reghours.types.TimerecordType.ENTRY;
import static net.reghours.types.TimerecordType.EXIT;
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
        
        if(request == null || !(request.checkTypeCorrect(request.getType())))
            return new AddRecordResponse("Bad request", 400, null, 
                    "You must send the correct data in the correct structure.");
        
        User user = userManager.getUserByUsername(request.getUsername());
        
        if(user != null && userValidator.passwordCorrect(request.getUsername(), request.getPasswd())) {

                Timerecord record;
                
                if(recordsManager.emptyRecordList(user.getUsername())) {
                    if("ENTRY".equals(request.getType().toUpperCase())) {
                        
                        record = new Timerecord(new Date(), request.getType().toUpperCase(), user);
                        recordsManager.addTimerecord(record);
                        return new AddRecordResponse("OK", 200, record);
                    }
                    else {
                        return new AddRecordResponse("Method not allowed", 405, null, 
                                                     "No records yet, only entry available.");
                    }
                }
                else {
                    if("ENTRY".equals(request.getType().toUpperCase())) {
                        if (recordsManager.getLastRecordType(user.getUsername()) != ENTRY) {
                        
                            record = new Timerecord(new Date(), request.getType().toUpperCase(), user);
                            recordsManager.addTimerecord(record);
                            return new AddRecordResponse("OK", 200, record);
                        }
                        else {
                            return new AddRecordResponse("Method not allowed", 405, null, 
                                                     "Last record is an entry. Must exit first.");
                        }
                    } else if("EXIT".equals(request.getType().toUpperCase())) {
                        if(recordsManager.getLastRecordType(user.getUsername()) != EXIT) {
                        
                            record = new Timerecord(new Date(), request.getType().toUpperCase(), user);
                            recordsManager.addTimerecord(record);
                            return new AddRecordResponse("OK", 200, record);
                        }
                        else {
                            return new AddRecordResponse("Method not allowed", 405, null, 
                                                         "Last record is an exit. Must enter first.");
                        }
                    }
                }
            }
        
        return new AddRecordResponse("Forbidden", 403, null);
    }
}

