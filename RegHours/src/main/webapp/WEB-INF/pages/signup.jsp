<%-- 
    Document   : signup
    Created on : 29-ene-2019, 20:31:47
    Author     : Benjamin Adam Nagy
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="signup-page">
    <div class="row"><div class="col mr-5 ml-5">
    <h1 class="mt-4 mb-2 text-center">Signup</h1>
    <form id="signup_page_form" name="signup-form" method="POST" action="Signup" class="border p-5 mx-auto">
        <div class="form-group">
            <label for="username" class="lead">Username:</label>
            <input type="text" name="username" class="form-control"/>
        </div>    
        <div class="form-group mt-2">
            <label for="firstname" class="lead">First name:</label>
            <input type="text" name="firstname" class="form-control"/>
        </div>
        <div class="form-group mt-2">
            <label for="lastname" class="lead">Last name:</label>
            <input type="text" name="lastname" class="form-control"/>
        </div>
        <div class="form-group mt-2">
            <label for="email" class="lead">Email address:</label>
            <input type="email" name="email" class="form-control"/>
        </div>
        <div class="form-group mt-2">
            <label for="passwd" class="lead">Password:</label>
            <input type="password" name="passwd" class="form-control"/>
        </div>
        <div class="form-group mt-2">
            <label for="confirmPasswd" class="lead">Confirm password:</label>
            <input type="password" name="confirmPasswd" class="form-control"/>
        </div>
        <button id="signup_button" class="btn btn-primary btn-lg pl-4 pr-4 mt-2 btn-block" type="submit">Signup</button>
        <div class="clearfix text-center m-3">
            <a href="/RegHours/Login" class="text-warning"><b>Already got an account? Log in!</b></a>
        </div>
    </form>
    <div class="clearfix text-center m-3">
        <button class="btn btn-light btn-outline-dark mb-4" type="reset">Reset form data</button>
    </div>
    </div></div>
</div>
<% if(request.getAttribute("errorSignup") != null) { %>
    <div class="errorContainer">
        <% for(String error : (ArrayList<String>) request.getAttribute("errorSignup")) { %>
            <p style="color: red"><%= error %></p>
        <% } %>
    </div>
<% } %>