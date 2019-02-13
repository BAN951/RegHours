<%-- 
    Document   : login
    Created on : 29-ene-2019, 20:31:39
    Author     : Benjamin Adam Nagy
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="login-page">
    <div class="row"><div class="col mr-5 ml-5">
    <h1 class="mt-4 mb-2 text-center">Login</h1>
    <form id="login_page_form" name="login-form" method="POST" action="Login" class="border p-5 mx-auto">
        <div class="form-group mt-2">
            <label for="username" class="lead">Username</label>
            <input type="text" name="username" class="form-control" required autocomplete="on"/>
        </div>
        <div class="form-group mt-2">
            <label for="passwd" class="lead">Password</label>
            <input type="password" name="passwd" class="form-control" required/>
        </div>
        <button id="login_button" 
                class="btn btn-primary btn-lg pl-4 pr-4 mt-2 btn-block" 
                type="submit"><b>Login</b></button>
        <div class="clearfix mt-3">
            <a href="#" class="float-left text-warning">Forgot your password?</a>
            <a href="/RegHours/Signup" class="float-right text-warning">Create account</a>
        </div>
    </form>
    <% if (request.getAttribute("errorLogin") != null) { %>
        <div class="errorContainer">
            <% for (String error : (ArrayList<String>) request.getAttribute("errorLogin")) {%>
            <p style="color: red"><%= error%></p>
            <% } %>
        </div>
    <% }%>
    </div></div>
</div>

