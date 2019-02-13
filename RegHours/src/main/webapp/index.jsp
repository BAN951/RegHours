<%-- 
    Document   : index
    Created on : 29-ene-2019, 20:16:02
    Author     : Benjamin Adam Nagy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RegHours</title>
        <link rel="stylesheet" href="bootstrap/bootstrap.sandstone.css"/>
        <link rel="stylesheet" href="stylesheets/main.css"/>
    </head>
    <body>
        <div class="container-fluid">
            <header>
                <jsp:include page="/WEB-INF/components/header.jsp"/>
            </header>
            <main class="ml-3 mr-3">
                
                <% if(request.getAttribute("noSessionAccessAttempt") != null) { %>
                    <!-- Poner un alert -->
                    <p><%= (String) request.getAttribute("noSessionAccessAttempt") %></p>
                <% } %>
                <jsp:include page="<%=
                    ((String) request.getAttribute("action")) == null ? 
                        "/WEB-INF/pages/home.jsp" : 
                        "/WEB-INF/pages/"  + (String) request.getAttribute("action") + ".jsp"
                %>"/>
                
            </main>
            <footer class="bg-primary text-light">
                <jsp:include page="/WEB-INF/components/footer.jsp"/>
            </footer>
        </div>
    </body>
</html>
