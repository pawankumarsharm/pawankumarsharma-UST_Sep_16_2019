package com.ustglobal.webappp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SERVICE METHOD");
		System.out.println("extra line of code");
		
		ServletContext context=getServletContext();
		String companyName=context.getInitParameter("company-name");
		
		ServletConfig config=getServletConfig();
		String batchName=config.getInitParameter("batch-name");
		
		
		
		
		
		PrintWriter out = resp.getWriter();//printwiter is a concrete class .it is used to helping us to give responce. we cannot create printwriter object using new keyword becaue it will not be a responsible object
		resp.setContentType("text/html");//we are setting the content type , browser only understand html. this perticular servlet  generate only html file. bydefault it will take text.so for text.html we dont have to mention it
		out.println("<html>");
		out.println("<body>");

		Date date = new Date();//date is a java object, we are creating it for getting the current date. 
		out.println("<h1 style='color:Red'>Date and Time is:");// generate  the string repressention of string
		out.println(date);
		out.println("</h1>");
		
		out.println("<h2>");
		out.println(companyName);
		out.println("</h2>");
		
		out.println("<h2>");
		out.println(batchName);
		out.println("</h2>");
		
		String url=req.getRequestURI();
		String method=req.getMethod();
		out.println("<br>");
		out.println(url);
		out.println("<br>");
		out.println(method);
		
		

		out.println("</body>");
		out.println("</html>");// each and every time we have we make a request, thius line of code will reexecute again and again.
	}// end of doGEt()
}// end of myFirstservlet
