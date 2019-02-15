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
        <h4>Action buttons</h4>
        <button class="btn btn-success btn-block" name="btnRecord" value="ENTRY" type="submit">ENTRY</button>
        <button class="btn btn-danger btn-block" name="btnRecord" value="EXIT" type="submit">EXIT</button>
    </form>
    <%! RecordsManager recordsManager = new RecordsManager(); %>
<div id="timerecords-table">
<% if(recordsManager.getTimerecords((String) request.getAttribute("Username")) != null 
        && !(recordsManager.emptyRecordList((String) request.getAttribute("Username")))) { %>
    <h3>Timerecords:</h3>
    <div class="table-wrapper-scroll-y">
    <table class="table table-hover">
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
            <tr <% if(record.getType().toUpperCase().equals("ENTRY")) { %>
                    class="table-primary"
                <% } else { %>
                    class="table-secondary"
                <%  } %>>
                <td><%= record.getType() %></td>
                <td><%= record.getFormattedDate() %></td>
                <td><%= record.getFormattedTime() %></td>
                <%
                if(record.getType().toUpperCase().equals("ENTRY")) {
                    entryDate = record.getRecord();
                    out.println("<td class='bg-primary'></td>");
                } 
                else {
                    exitDate = record.getRecord();
                    out.println("<td id='diff_cell' class='bg-primary text-white'>" + record.getDifference(entryDate, exitDate) + "</td>");
                    entryDate = null; 
                    exitDate = null; 
                } %>
            </tr>
            <% } %>
        </tbody>
    </table>
    </div>
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