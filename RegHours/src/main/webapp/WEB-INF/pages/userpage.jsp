<%-- 
    Document   : main_page
    Created on : 29-ene-2019, 20:32:09
    Author     : Benjamin Adam Nagy
--%>

<%@page import="java.util.Date"%>
<%@page import="net.reghours.datamodel.entities.Timerecord"%>
<%@page import="net.reghours.datamodel.actions.RecordsManager"%>
<%@page import="net.reghours.datamodel.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! private Date entryDate = null; %>
<%! private Date exitDate = null; %>
<div id="user-page">
    <h1 class="display-4 mt-3">User Page</h1>
    <form name="timerecord-form" method="POST" action="UserPage">
        <legend>Action buttons</legend>
        <button class="btn btn-primary border border-success" name="btnRecord" value="ENTRY" type="submit">ENTRY</button>
        <button class="btn btn-primary border border-danger" name="btnRecord" value="EXIT" type="submit">EXIT</button>
    </form>
    <%! RecordsManager recordsManager = new RecordsManager(); %>
<div id="timerecords-table">
<% if(recordsManager.getTimerecords((String) request.getAttribute("Username")) != null 
        && !(recordsManager.emptyRecordList((String) request.getAttribute("Username")))) { %>
    <h3>Timerecords:</h3>
    <table border="1px">
        <thead>
            <tr>
                <th>Action</th>
                <th>Date</th>
                <th>Time</th>
                <th>Difference</th>
            </tr>
        </thead>
        <tbody>
            <%
            for(Timerecord record : recordsManager.getTimerecords((String) request.getAttribute("Username"))) { %>
            <tr id="<%= record.getIdRecord() %>">
                <td><%= record.getType() %></td>
                <td><%= record.getFormattedDate() %></td>
                <td><%= record.getFormattedTime() %></td>
                <%
                if(record.getType().toUpperCase().equals("ENTRY")) {
                    entryDate = record.getRecord();
                    out.println("<td></td>");
                } 
                else {
                    exitDate = record.getRecord();
                    out.println("<td>" + record.getDifference(entryDate, exitDate) + "</td>");
                    entryDate = null; 
                    exitDate = null; 
                } %>
            </tr>
            <% } %>
        </tbody>
    </table>
<% } else { %>
    <p>You don't have any records yet...</p>
    <p>To add new records use the Entry and Exit buttons above.</p>
<% } %>
    </div>
    <% if(request.getAttribute("wrongAction") != null) { %>
        <div id="wrongActionAlert">
            <p style="color: red;"><%= request.getAttribute("wrongAction") %></p>
        </div>
    <% } %>
</div>