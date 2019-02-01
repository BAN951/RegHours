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
    </head>
    <body>
        <header>
            <jsp:include page="/WEB-INF/components/header.jsp"/>
        </header>
        <main>
            <% if(request.getAttribute("noSessionAccessAttempt") != null) { %>
                <p style="color: orange"><%= (String) request.getAttribute("noSessionAccessAttempt") %></p>
            <% } %>
            <jsp:include page="<%=
                ((String) request.getAttribute("action")) == null ? 
                    "/WEB-INF/pages/home.jsp" : 
                    "/WEB-INF/pages/"  + (String) request.getAttribute("action") + ".jsp"
            %>"/>
        </main>
        <footer>
            <jsp:include page="/WEB-INF/components/footer.jsp"/>
        </footer>
    </body>
</html>
