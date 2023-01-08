package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.ManagerDao;

/**
 * Servlet implementation class ManagerUpdate
 */
public class ManagerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String id=request.getParameter("id");
		String c=request.getParameter("role");
		String upd=request.getParameter("update");
		ManagerDao md=new ManagerDao();
		int i=0;
		if(c.equalsIgnoreCase("fname")) {
			i=md.update(Integer.parseInt(id), upd, 1);
		}
		else if(c.equalsIgnoreCase("lname")) {
			i=md.update(Integer.parseInt(id), upd, 2);
		}
		else if(c.equalsIgnoreCase("email")) {
			i=md.update(Integer.parseInt(id),upd, 3);
		}
		else {
			i=md.update(Integer.parseInt(id), upd, 4);
		}
		if(i>0) {
			System.out.println("Manager Updated Successfully!!");
		}
		response.sendRedirect("AdminDashBoard.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
