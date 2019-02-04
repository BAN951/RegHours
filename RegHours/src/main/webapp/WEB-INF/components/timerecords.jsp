<%-- 
    Document   : timerecords
    Created on : 01-feb-2019, 16:57:36
    Author     : admin
--%>

<%@page import="net.reghours.datamodel.entities.Timerecord"%>
<%@page import="net.reghours.datamodel.actions.RecordsManager"%>
<%@page import="net.reghours.datamodel.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! RecordsManager recordsManager = new RecordsManager(); %>
<div id="timerecords-table">
<% if(recordsManager.getTimerecords((String) request.getAttribute("Username")) != null) { %>
    <h3>Timerecords:</h3>
    <table border="1px">
        <thead>
            <tr>
                <th>Action</th>
                <th>Date</th>
                <th>Time</th>
            </tr>
        </thead>
        <tbody>
            <% for(Timerecord record : recordsManager.getTimerecords((String) request.getAttribute("Username"))) { %>
            <tr id="<%= record.getIdRecord() %>">
                <td><%= record.getType() %></td>
                <td><%= record.getFormattedDate() %></td>
                <td><%= record.getFormattedTime() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>   
<% } else { %>
    <p>You don't have any records yet...</p>
    <p>To add new records use the Entry and Exit buttons above.</p>
<% } %>
</div>
