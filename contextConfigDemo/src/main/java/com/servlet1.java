package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		PrintWriter out = response.getWriter();
		out.print("<br/><h1> Accessing Config Parameters in servlet 1</h1>");
		out.print("sql = "+config.getInitParameter("SQL"));
		out.print("<br/> Message = "+config.getInitParameter("message"));
		out.print("<br/><h1> Accessing Content Parameters in servet 1.</h1>");
		ServletContext application = getServletContext();
		out.print("Driver name = "+application.getInitParameter("driver"));
		out.print("<br/> Url name = "+application.getInitParameter("url"));
	}

}
