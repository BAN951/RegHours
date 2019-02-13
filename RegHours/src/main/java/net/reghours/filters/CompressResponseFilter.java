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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.reghours.filters.wrappers.GZipServletResponseWrapper;


/**
 *
 * @author Benjamin Adam Nagy
 */
public class CompressResponseFilter implements Filter {

    private FilterConfig filterConfig = null;
    
    public CompressResponseFilter() {}    

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
        
        HttpServletRequest  req  = (HttpServletRequest)  request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (acceptsGZipEncoding(req)) {
            res.addHeader("Content-Encoding", "gzip");
          
            GZipServletResponseWrapper gzipResponse = new GZipServletResponseWrapper(res);
          
            chain.doFilter(request, gzipResponse);
            System.out.println("Filter info log: response compressed - GZIP");
          
            gzipResponse.close();
        
        } else {
            chain.doFilter(request, response);
        }
        
        
    }
    
    private boolean acceptsGZipEncoding(HttpServletRequest httpRequest) {
        String acceptEncoding
                = httpRequest.getHeader("Accept-Encoding");

        return acceptEncoding != null
                && acceptEncoding.contains("gzip");
    }

    /**
     * Return the filter configuration object for this filter.
     * @return 
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
    @Override
    public void destroy() {}

    /**
     * Init method for this filter
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
            return ("CompressResponseFilter()");
        }
        StringBuilder sb = new StringBuilder("CompressResponseFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
}
