package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



/**
 * Servlet implementation class CourseRegServlet
 */
public class CourseRegServlet extends GenericServlet implements Servlet {
	
	private Connection con;

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		ServletContext scxt= config.getServletContext(); 
		String driver=	scxt.getInitParameter("driver");
		String url=	scxt.getInitParameter("url");
		
		
		String username=config.getInitParameter("username");
		String password=config.getInitParameter("password");
		System.out.println("course username = "+username);
		System.out.println("course password = "+password);
		
			
				try {
					con = DriverManager.getConnection(url, username, password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int cid = Integer.parseInt(request.getParameter("cid"));
		String cname = request.getParameter("cname");
		int fee = Integer.parseInt(request.getParameter("fee"));
		try
		{
			PreparedStatement pst = ((java.sql.Connection) con).prepareStatement("inser into course values (?,?,?)");
			pst.setInt(1, cid);
			pst.setString(2, cname);
			pst.setInt(3, fee);
			int i = pst.executeUpdate();
			if(i!=0)
				out.println("course registration success");
			else
				
				out.println("course rsagistraion fual");
		}
		catch(Exception e)
		{
			out.println("course rsagistraion fual");
		}
	}
	
	public void destroy() {
		try {
			con.close();
			
		}
		catch(Exception e)
		{
			
		}
	}

}
