package com.controller;
import com.model.*;
import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MovieDao;

@WebServlet("/movieController")
public class movieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public movieController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		MovieDao md=new MovieDao();
		LinkedList<Movie> lst=md.getPopularMovie();
		HttpSession session = request.getSession();
		LinkedList<Movie> finalList=new LinkedList<>();
		for(int i=0;i<10;i++) {
			finalList.add(lst.get(i));
		}
		session.setAttribute("popularMovie", finalList);
		//System.out.println(lst.size());
		//System.out.println("Hell0");
		response.sendRedirect("index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
