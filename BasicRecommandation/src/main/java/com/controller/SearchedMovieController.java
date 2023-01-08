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

@WebServlet("/SearchedMovieController")
public class SearchedMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public SearchedMovieController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchMovie=request.getParameter("searchmovie");
		SearchHistoryDao shd=new SearchHistoryDao();
		HttpSession session=request.getSession();
		int i=shd.insertHistory((String)session.getAttribute("email1"),searchMovie);
		if(i>0) {
			System.out.println("history updated");
		}
		else {
			System.out.println("history nnot updated");
		}
		System.out.println(searchMovie);
		LinkedList<Movie> lst=showPopularMovies.showsimilarName(searchMovie);
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
