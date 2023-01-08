package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.ManagerDao;
import com.model.Manager;

/**
 * Servlet implementation class Managerservlet
 */
public class Managerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Managerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		    System.out.println("Komal");
		    String id=request.getParameter("id");
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String email=request.getParameter("email");
			String pass=request.getParameter("psw");
			System.out.println(id+" "+fname+" "+lname+" "+email+" "+pass);
			Manager m=new Manager(Integer.parseInt(id),fname,lname,email,pass);
			ManagerDao md=new ManagerDao();
			try {
				int i=md.create(m);
				if (i>0) {
				System.out.println("Manager added succesfully");
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert(''Manager added succesfully"); 
				out.println("</script>");}
				response.sendRedirect("AdminDashBoard.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
//		else if(str.equalsIgnoreCase("DELETE MANAGER")) {
//			
//		}
//		else {
//			
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
