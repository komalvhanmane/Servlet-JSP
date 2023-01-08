package com.controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SearchHistoryDao;
import com.info.ShowSimilarMovie;
import com.info.ShowSimilarMovies;
import com.model.Movie;

@WebServlet("/movieShowerController")
public class movieShowerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public movieShowerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchMovie=request.getParameter("searchmovie");
		SearchHistoryDao shd=new SearchHistoryDao();
		HttpSession session=request.getSession();
		shd.insertHistory(searchMovie,(String)session.getAttribute("email1"));
		System.out.println(searchMovie);
		LinkedList<Movie> lst=ShowSimilarMovie.retrive(searchMovie);
		
		System.out.println(lst.size());
		session.setAttribute("similarmovie", lst);
		response.sendRedirect("DashBoard.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
