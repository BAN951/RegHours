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
    <div class="row">
        <div class="col">
        <form name="timerecord-form" method="POST" action="UserPage">
            <h4 class="pt-3">Action buttons</h4>
            <button id="user_page_entrada" class="btn btn-info btn-block" name="btnRecord" value="ENTRY" type="submit">ENTRY</button>
            <button id="user_page_salida" class="btn btn-primary btn-block" name="btnRecord" value="EXIT" type="submit">EXIT</button>
        </form>
        </div>
        <div class="col-3">
            <% if(request.getAttribute("wrongAction") != null) { %>
            <div id="wrongActionAlert" class="alert alert-danger mt-5">
                <strong><%= request.getAttribute("wrongAction") %><strong>
            </div>
            <% } %>
        </div>
    </div>
    <%! RecordsManager recordsManager = new RecordsManager(); %>
    <div class="row">
        <div class="col">
        <div id="timerecords-table">
        <% if(recordsManager.getTimerecords((String) request.getAttribute("Username")) != null 
                && !(recordsManager.emptyRecordList((String) request.getAttribute("Username")))) { %>
            <h3 class="mt-5">Timerecords:</h3>
            <div class="table-wrapper-scroll-y">
            <table class="table table-hover">
                <thead class="bg-dark">
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
                            class="table-info"
                        <%  } %>>
                        <td><%= record.getType() %></td>
                        <td><%= record.getFormattedDate() %></td>
                        <td><%= record.getFormattedTime() %></td>
                        <%
                        if(record.getType().toUpperCase().equals("ENTRY")) {
                            entryDate = record.getRecord();
                            out.println("<td class='bg-black'></td>");
                        } 
                        else {
                            exitDate = record.getRecord();
                            out.println("<td id='diff_cell' class='bg-black text-dark'>" + record.getDifference(entryDate, exitDate) + "</td>");
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
        </div></div>
</div>