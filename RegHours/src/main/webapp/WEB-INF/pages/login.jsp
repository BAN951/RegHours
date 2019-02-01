<%-- 
    Document   : login
    Created on : 29-ene-2019, 20:31:39
    Author     : Benjamin Adam Nagy
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="login-page">
    <h1>Login</h1>
    <form name="login-form" method="POST" action="Login">
        
        <label for="username">Username:</label>
        <input type="text" name="username"/>
        
        <label for="passwd">Password:</label>
        <input type="password" name="passwd"/>
        
        <button type="submit">Login</button>
    </form>
</div>
<% if(request.getAttribute("errorLogin") != null) { %>
    <div class="errorContainer">
        <% for(String error : (ArrayList<String>) request.getAttribute("errorLogin")) { %>
            <p style="color: red"><%= error %></p>
        <% } %>
    </div>
<% } %>

