package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;
import com.model.Employee;

/**
 * Servlet implementation class addEmployee
 */
@WebServlet("/addEmployee")
public class addEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String emplid=request.getParameter("Eid");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String Designation=request.getParameter("Designation");
		String Department=request.getParameter("Department");
		String Level=request.getParameter("Level");
		String Gender=request.getParameter("gender");
		String birthday=request.getParameter("birthday");
		String jobjoin=request.getParameter("jobjoin");
		//public Employee(int emp_id, String name, String email, String dOB, String gender, String designation, String level,
//		String intervention, String dOJ, String status)
		Employee e=new Employee(Integer.parseInt(emplid),name,email,birthday,Gender,Designation,Level,Department,jobjoin,"Active");
		CustomerDao cd=new CustomerDao();
		int i=cd.insert(e);
		if(i>0) {
			System.out.println("Employee record inserted");
		}
		else {
			System.out.println("unable to insert");
		}
		response.sendRedirect("hrDashBoard.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
