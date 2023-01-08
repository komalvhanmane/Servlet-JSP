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
import com.info.showPopularMovies;
import com.model.Movie;

@WebServlet("/FilterController")
public class FilterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FilterController() {
        super();
    }
//thriller,romance,family,adventure,documentary,crime,drama,war
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filter=request.getParameter("filter");
		SearchHistoryDao shd=new SearchHistoryDao();
		HttpSession session =request.getSession();
		shd.insertHistory(filter,(String)session.getAttribute("email1"));
		System.out.println(filter);
		LinkedList<Movie> lst=showPopularMovies.ShowfilteredpopularMovie(filter);
		
		System.out.println(lst.size());
		session.setAttribute("similarmoviename", lst);
		response.sendRedirect("DashBoard.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
