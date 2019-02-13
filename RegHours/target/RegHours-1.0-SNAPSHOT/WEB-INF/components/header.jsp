<%-- 
    Document   : header
    Created on : 29-ene-2019, 20:33:05
    Author     : Benjamin Adam Nagy
--%>

<%@page import="net.reghours.datamodel.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="nav_header">
    <nav class="navbar navbar-dark bg-primary">
        <h2><a class="navbar-brand" href="/RegHours">RegHours</a></h2>
    <div id="user-section">
        <ul class="navbar-nav mr-auto">
        <% if((User) session.getAttribute("User") == null) { %>
        <li class="nav-item">
            <form id="user_section_login" method="GET" action="Login" class="float-left">
                <button class="btn btn-success" type="submit"><b>Login</b></button>
            </form>
            <form id="user_section_login" method="GET" action="Signup" class="float-right ml-3">
                <button class="btn btn-success" type="submit"><b>Signup</b></button>
            </form>
        </li>
        <% } else { %>
        <li class="nav-item">
            <span>Welcome,<strong><%= ((User) session.getAttribute("User")).getUsername() %></strong></span>
            <form method="POST" action="Logout">
                <button class="btn btn-secondary" type="submit">Logout</button>
            </form>
        </li>
        <% } %>       
        </ul>
    </div>
    </nav>
</div>
