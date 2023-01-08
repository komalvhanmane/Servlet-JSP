package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.AdminDao;
import com.Dao.ManagerDao;
import com.Dao.OperationDao;
import com.model.Admin;
import com.model.Customer;
import com.model.Manager;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		String pass = request.getParameter("psw");
		String role=request.getParameter("role");
		if(role.equalsIgnoreCase("admin")) {
			AdminDao ad=new AdminDao();
//			int i=ad.validate(email,pass);
//			if(i==1) {
//				HttpSession session=request.getSession();
//				session.setAttribute("check2", email);
//				LinkedList<Admin> lst=ad.retrive(email);
//				session.setAttribute("admin", lst.get(0));
//				System.out.println("hello admin");
//				System.out.println("Loged in succesfully!!");
//				//response.sendRedirect("ManagerDashBoard.jsp");
//				response.sendRedirect("Home.jsp");
//			}
//			else {
//				System.out.println("Invalid pass");
//			}
			if(email.equals("admin") && pass.equals("pass")) {
				HttpSession session=request.getSession();
				session.setAttribute("check2", email);
				System.out.println("hello admin");
				//response.sendRedirect("AdminDashBoard.jsp");
				response.sendRedirect("Home.jsp");
			}
		}
		else if(role.equalsIgnoreCase("Manager")) {
			ManagerDao md=new ManagerDao();
			int i=md.validate(email, pass);
			if(i==1) {
				HttpSession session=request.getSession();
				session.setAttribute("check1", email);
				LinkedList<Manager> lst=md.retrive(email);
				session.setAttribute("manager", lst.get(0));
				System.out.println("hello Mangaer");
				System.out.println("Loged in succesfully!!");
				//response.sendRedirect("ManagerDashBoard.jsp");
				response.sendRedirect("Home.jsp");
			}
		}
		else {
			OperationDao op=new OperationDao();
			int i=op.validate(email, pass);
			if(i==1) {
				HttpSession session=request.getSession();
				session.setAttribute("check", email);
				LinkedList<Customer> lst=op.retrive(email);
				session.setAttribute("customer", lst.get(0));
				System.out.println("Loged in succesfully customer!!");
				response.sendRedirect("Home.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
