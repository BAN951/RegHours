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

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import net.reghours.filters.beans.CharResponseWrapper;

/**
 *
 * @author Benjamin Adam Nagy
 */
@WebFilter(filterName = "CompressionFilter", urlPatterns = {"/*"})
public class CompressionFilter implements Filter {

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public CompressionFilter() {}

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
        
        try (PrintWriter out = response.getWriter()) {
            HttpServletResponse res = (HttpServletResponse) response;
            CharResponseWrapper wrapper = new CharResponseWrapper(res);
            
            chain.doFilter(request, wrapper);
            
            if (wrapper.getContentType().equals("text/html")) {
                CharArrayWriter arrayWriter = new CharArrayWriter();
                arrayWriter.write(wrapper.toString().substring(0,wrapper.toString().indexOf("</body>") - 1));
                arrayWriter.write(wrapper.toString());
                response.setContentLength(arrayWriter.toString().length());
                out.write(arrayWriter.toString());
            } else {
                out.write(wrapper.toString());
            }
        }
    }

    /**
     * Return the filter configuration object for this filter.
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
     */
    public void destroy() {}

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("CompressionFilter()");
        }
        StringBuffer sb = new StringBuffer("CompressionFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
}
