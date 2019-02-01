<%-- 
    Document   : header
    Created on : 29-ene-2019, 20:33:05
    Author     : Benjamin Adam Nagy
--%>

<%@page import="net.reghours.datamodel.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <h1 id="title" onclick='window.location.href="/RegHours"'>Reghours</h1>
    <div id="user-section">
        
        <% if((User) session.getAttribute("User") == null) { %>
        
            <form method="GET" action="Login">
                <button type="submit">Login</button>
            </form>
            <form method="GET" action="Signup">
                <button type="submit">Signup</button>
            </form>
        
        <% } else { %>
        
            <p>Welcome, <%= ((User) session.getAttribute("User")).getUsername() %></p>
            <form method="POST" action="Logout">
                <button type="submit">Logout</button>
            </form>

        <% } %>
    </div>
</div>
