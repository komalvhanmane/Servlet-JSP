package com.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SearchHistoryDao;
import com.info.ShowSimilarMovie;
import com.model.History;
import com.model.Movie;

/**
 * Servlet implementation class recommendedMovie
 */
@WebServlet("/recommendedMovie")
public class recommendedMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recommendedMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retriving top 3 search history
		SearchHistoryDao shd=new SearchHistoryDao();
		HttpSession session=request.getSession();
		LinkedList<String> ls=shd.mostSearched((String)session.getAttribute("email1"));
		System.out.println(ls.size());
		LinkedList<LinkedList<Movie>> lst=new LinkedList<>();
		
		for(int i=0;i<ls.size();i++) {
			LinkedList<Movie> lst1=ShowSimilarMovie.retrive(ls.get(i));
			lst.add(lst1);
		}
		LinkedList<Movie> lst2=new LinkedList<>();
		for(int i=0;i<lst.size();i++) {
			for(int j=0;j<lst.get(i).size();j++) {
				lst2.add(lst.get(i).get(j));
			}
		}
		System.out.println("size of final list"+ lst2.size());
		session.setAttribute("similarmovie", lst2);
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
