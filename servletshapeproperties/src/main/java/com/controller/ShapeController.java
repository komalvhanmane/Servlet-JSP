package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Shape;
import com.model.Square;

/**
 * Servlet implementation class ShapeController
 */
@WebServlet("/ShapeController")
public class ShapeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShapeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
System.out.println("hiii");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String str=request.getParameter("option");
		
			if(str.equalsIgnoreCase("Square")) {
				response.sendRedirect("Square1.html");
			}
			else if(str.equalsIgnoreCase("Circle")) {
				response.sendRedirect("Circle.html");
			}
			else if(str.equals("Triangle")) {
				response.sendRedirect("Triangle.html");
			}
			else if(str.equals("Rhombus")) {
				response.sendRedirect("Rhombus.html");
			}
			else if(str.equals("Parallelogram")) {
				response.sendRedirect("Parallelogram.html");
			}
			else if(str.equals("Trapezium")) {
				response.sendRedirect("Trapezium.html");
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
