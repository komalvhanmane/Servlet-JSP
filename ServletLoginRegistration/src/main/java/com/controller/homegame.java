package com.controller;
import java.util.*;
import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.GameDao;
import com.model.Games;

/**
 * Servlet implementation class homegame
 */
public class homegame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homegame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		GameDao gd=new GameDao();
		
		ArrayList<Games> g=gd.retrive();
		HttpSession session=request.getSession();
		session.setAttribute("gamelist",g);
		/*ArrayList<Games> g=gd.retrive();
		for(int i=0;i<g.size();i++) {
			System.out.println(g.get(i).getGameID()+" "+g.get(i).getGameName()+" "+g.get(i).getPrice());
		}*/
	//	System.out.println();
//		RequestDispatcher rd=request.getRequestDispatcher("diplaygame.jsp");
//		rd.forward(request, response);
		response.sendRedirect("Home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
