package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDao;
import com.model.User;


@WebServlet("/RegisterrController")
public class RegisterrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterrController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		System.out.println(email+" "+password);
		LoginDao ld=new LoginDao();
		User u=new User(email,password);
		int i=ld.insert(u);
		if(i>0) {
			System.out.println("User inserted");
			response.sendRedirect("Login.jsp");
		}
		else {
			System.out.println("User has not inserted");
			response.sendRedirect("Register.jsp");
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
