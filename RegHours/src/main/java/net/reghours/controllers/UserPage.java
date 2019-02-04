/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.reghours.datamodel.actions.RecordsManager;
import net.reghours.datamodel.entities.User;
import static net.reghours.types.TimerecordType.ENTRY;
import static net.reghours.types.TimerecordType.EXIT;

/**
 *
 * @author Benjamin Adam Nagy
 */
@WebServlet(name = "UserPage", urlPatterns = {"/UserPage"})
public class UserPage extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("action", "userpage");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        User user = (User) request.getSession().getAttribute("User");
        RecordsManager recordsManager = new RecordsManager();
        String action = request.getParameter("btnRecord");
        request.setAttribute("Username", user.getUsername());
        
        if(recordsManager.emptyRecordList(user.getUsername())) {
            if("ENTRY".equals(action)) {
                
                recordsManager.addTimerecord(ENTRY, user);
                
                request.setAttribute("action", "userpage");
                request.getRequestDispatcher("index.jsp").include(request, response);
            }
            else {
                request.setAttribute("wrongAction", "You don't have any records yet."
                                                  + "<br/>You can only click 'Entry' button.");
                request.setAttribute("action", "userpage");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        else {
            if("ENTRY".equals(action)) {
                if(recordsManager.getLastRecordType(user.getUsername()) != ENTRY) {

                    recordsManager.addTimerecord(ENTRY, user);

                    request.setAttribute("action", "userpage");
                    request.getRequestDispatcher("index.jsp").include(request, response);
                } else {
                    request.setAttribute("wrongAction", "You can not enter if you didn't exit. "
                            + "<br/>You must exit first.");
                    request.setAttribute("action", "userpage");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }

            if("EXIT".equals(action)) {
                if(recordsManager.getLastRecordType(user.getUsername()) != EXIT) {

                    recordsManager.addTimerecord(EXIT, user);

                    request.setAttribute("action", "userpage");
                    request.getRequestDispatcher("index.jsp").include(request, response);
                } else {
                    request.setAttribute("wrongAction", "You can not exit if you didn't enter. "
                            + "<br/>You must enter first.");
                    request.setAttribute("action", "userpage");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
        }
    }
        
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
