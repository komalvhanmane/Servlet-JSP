package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.OperationDao;
import com.model.Customer;

/**
 * Servlet implementation class SignUpController
 */
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String password=request.getParameter("psw");
		String confirmPass=request.getParameter("psw-repeat");
		if(!password.equals(confirmPass)) {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Confirm Password And Password Should be Same !!!')");
			out.println("</script>");
			//response.sendRedirect("home1.html");
		}
		else {
			Customer c=new Customer(fname,lname,email,password);
			OperationDao od=new OperationDao();
			try {
				int i=od.create(c);
				if(i>0) {
					System.out.println("User added succesfully!!");

					PrintWriter out = response.getWriter();  
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert(''User added succesfully"); 
					out.println("</script>");
					response.sendRedirect("Home.jsp");

				}
				else {
					PrintWriter out=response.getWriter();
					response.setContentType("text/html");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Already Email is registered !!!')");
					out.println("</script>");
				}

			}catch(Exception e) {

				//				response.sendRedirect("Home.html");
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
