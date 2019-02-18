/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import net.reghours.datamodel.actions.UserManager;
import net.reghours.datamodel.entities.User;
import net.reghours.validation.UserValidator;
import net.reghours.validation.ejbs.SignupBeanLocal;
import org.apache.commons.beanutils.BeanUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.HibernateException;

/**
 *
 * @author Benjamin Adam Nagy
 */
@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {

    @Resource
    Validator validator;

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
           
            if(request.getAttribute("errorSignup") != null)
                request.setAttribute("errorSignup", null); 
            
            request.setAttribute("action", "signup"); 
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
        
        try {
           
            SignupBeanLocal bean = (SignupBeanLocal) new InitialContext().lookup("java:global/RegHours/SignupBean");
            BeanUtils.populate(bean, request.getParameterMap());
            
            UserValidator userValidator = new UserValidator();
            ArrayList<String> errorSignup = new ArrayList();
            
            if(validator.validate(bean).isEmpty()) {

                if(request.getParameter("confirmPasswd") != null
                        && ((String) request.getParameter("passwd")).equals((String) request.getParameter("confirmPasswd"))) {

                    if(!(userValidator.userExists(request.getParameter("username"), request.getParameter("email")))) {

                        User user = new User();
                        user.setUsername((String) request.getParameter("username"));
                        user.setFirstname((String) request.getParameter("firstname"));
                        user.setLastname((String) request.getParameter("lastname"));
                        user.setEmail((String) request.getParameter("email"));

                        String passwd = DigestUtils.sha256Hex((String) request.getParameter("passwd"));
                        user.setPasswd(passwd);

                        UserManager userManager = new UserManager();
                        userManager.addNewUser(user);

                        request.setAttribute("action", "login");
                        request.getRequestDispatcher("index.jsp").forward(request, response);

                    }
                    else {
                        errorSignup.add("User already exists<br/>This email address or this username is already in our system");
                    }
                }
                else {
                    errorSignup.add("Password confirmation must match the password");
                }
            }
            else {
                for (ConstraintViolation c : validator.validate(bean))
                    errorSignup.add(c.getMessage());
            }

            if(!(errorSignup.isEmpty())) {
                request.setAttribute("errorSignup", errorSignup);
                request.setAttribute("action", "signup");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
            
        } catch (NamingException | IllegalAccessException | InvocationTargetException | HibernateException ex) {
            
            // TO-DO
            
                // Hacer página de error, redirect.
            
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        
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
