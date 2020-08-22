package com.sms;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
@Component
	public class SmsCrossFilter implements Filter {
		 
	    /**
	     * Default constructor.
	     */
	    public SmsCrossFilter() {
	    }
	 
	 
	    /**
	     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	     */
	    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
	            throws IOException, ServletException {
	 
	        HttpServletRequest req = (HttpServletRequest) servletRequest;
	        HttpServletResponse res =(HttpServletResponse) servletResponse;
	        System.out.println("CORSFilter HTTP Request: " + req.getMethod());
	 
	        // Authorize (allow) all domains to consume the content
	        res.addHeader("Access-Control-Allow-Origin", "*");
	        res.addHeader("Access-Control-Allow-Methods","*");
	        res.setHeader("Access-Control-Allow-Headers", "*");
	 
	        // pass the request along the filter chain
	        chain.doFilter(req, res);
	    }


		@Override
		public void destroy() {
		}


		@Override
		public void init(FilterConfig arg0) throws ServletException {
			
		}
	 
	 
}
