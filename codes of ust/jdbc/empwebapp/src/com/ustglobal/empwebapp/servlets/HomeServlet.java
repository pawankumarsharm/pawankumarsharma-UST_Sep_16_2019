package com.ustglobal.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ustglobal.empwebapp.dao.EmployeeDAO;
import com.ustglobal.empwebapp.dto.EmployeeInfo;
import com.ustglobal.webapp.util.EmployeeDaoManager;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession(false);
	
	if(session!=null) {
	RequestDispatcher dispatcher=req.getRequestDispatcher("/home.jsp");
	dispatcher.forward(req, resp);
	
	}else {
		RequestDispatcher dispatcher=req.getRequestDispatcher("/login.jsp");
		dispatcher.forward(req, resp);
	}
}//end of doGet

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req,resp);
}//end of doPost
}//end of LoginServlet
