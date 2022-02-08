package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class StudentRegServlet extends GenericServlet {
	private Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		ServletContext scxt= config.getServletContext(); 
	String driver=	scxt.getInitParameter("driver");
	String url=	scxt.getInitParameter("url");
		String username=config.getInitParameter("username");
		String password=config.getInitParameter("password");
		System.out.println("student username = "+username);
		System.out.println("student password = "+password);
	
		
		try {
			Class.forName(driver);
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {}
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		try {
		PreparedStatement pst = ((java.sql.Connection) con).prepareStatement("insert into student values (?,?,?)");
		pst.setInt(1, id);
		pst.setString(1, name);
		pst.setString(3, email);
		int i =pst.executeUpdate();
		if(i!=0)
		out.println("student reg success:");
		else
			out.print("studnet reg fail");
	
		}
		catch(Exception e)
		{
			out.println("student teg fail");
		}
		
	}
	
	public void destroy()
	{
		try 
		{
			con.close();
		}
		catch(Exception e)
		{}
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

     
	}


