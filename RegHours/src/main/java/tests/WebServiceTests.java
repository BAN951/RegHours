/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import net.reghours.webservice.records.GetRecordsRequest;

/**
 *
 * @author admin
 */
public class WebServiceTests {
    
    public static void main(String[] args) {
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client
                .target("http://localhost:8080/RegHours/webservice/")
                .path("records");
        
        
        GetRecordsRequest request = new GetRecordsRequest("Benji", "Benjamin995#");
        Gson gson = new Gson();
        System.out.println("Sended data: " + gson.toJson(request));
        
        
    }
}
