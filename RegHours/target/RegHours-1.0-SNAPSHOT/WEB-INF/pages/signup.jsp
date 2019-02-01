<%-- 
    Document   : signup
    Created on : 29-ene-2019, 20:31:47
    Author     : Benjamin Adam Nagy
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="signup-page">
    <h1>Signup</h1>
    <form name="signup-form" method="POST" action="Signup">
        
        <label for="username">Username:</label>
        <input type="text" name="username"/>
        
        <label for="firstname">First name:</label>
        <input type="text" name="firstname"/>
        
        <label for="lastname">Last name:</label>
        <input type="text" name="lastname"/>
        
        <label for="">Email address:</label>
        <input type="email" name="email"/>
        
        <label for="passwd">Password:</label>
        <input type="password" name="passwd"/>
        
        <label for="confirmPasswd">Confirm password:</label>
        <input type="password" name="confirmPasswd"/>
        
        <button type="reset">Reset form data</button>
        <button type="submit">Signup</button>
    </form>
</div>
<% if(request.getAttribute("errorSignup") != null) { %>
    <div class="errorContainer">
        <% for(String error : (ArrayList<String>) request.getAttribute("errorSignup")) { %>
            <p style="color: red"><%= error %></p>
        <% } %>
    </div>
<% } %>