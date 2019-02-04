/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Benjamin Adam Nagy
 */
@WebFilter(filterName = "SessionFilter", urlPatterns = {"/UserPage", "/Logout"})
public class SessionFilter implements Filter {

    private FilterConfig filterConfig = null;
    
    public SessionFilter() {
    }    
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
   
            HttpServletRequest req = (HttpServletRequest) request;
            
            if(req.getSession().getAttribute("User") == null) {
                System.out.println("RequestURL: " + req.getRequestURI());
                
                if("/RegHours/UserPage".equals(req.getRequestURI()))
                    req.setAttribute("noSessionAccessAttempt", "You must log in to access your user page");
                else
                    req.setAttribute("noSessionAccessAttempt", "Log in to your user page<br/>Can not log out without logging in");
                
                req.setAttribute("action", "login");
                req.getRequestDispatcher("index.jsp").forward(request, response);  
            } 
            else {
                chain.doFilter(request, response);
            }
    }

    /**
     * Return the filter configuration object for this filter.
     * 
     * @return (this.filterConfig)
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     * 
     */
    @Override
    public void destroy() {        
    }

    /**
     * Init method for this filter
     * 
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("SessionFilter()");
        }
        StringBuilder sb = new StringBuilder("SessionFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    

    
}
