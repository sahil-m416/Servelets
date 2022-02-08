package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class ValidationFilter
 */
public class ValidationFilter implements Filter {

    
public void init(FilterConfig fConfig) throws ServletException {
    String value	=	fConfig.getInitParameter("key");
    System.out.println(value);
	}
	

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
	String name =	request.getParameter("name");
		String email = request.getParameter("email");
		int marks =0;
		try {
			marks=Integer.parseInt(request.getParameter("marks"));
		}
		
		catch(Exception e)
		{
			
		}
		
		if(name.equals(""))
		{
			out.println("Name is required");
		}
		
		else if(email.equals(""))
		
		{
			out.println("Email is required");
		}
		
		else if(marks==0)
		{
			out.println("Marks is required");
		}
		
		else 
		{
			out.println("<div style='border-style: dashed;border-color:red; color:green;font-size: 30'>");
			out.println("<pre>");
			chain.doFilter(request, response);
			out.println("</pre>");
			out.println("</div>");
		}
	}

	
	
	public void destroy() {
	
	System.out.println("Fileter destroy");
		
	}

}
