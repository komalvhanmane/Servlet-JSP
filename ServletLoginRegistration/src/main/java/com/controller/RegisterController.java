package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import com.model.*;
import com.model.Record;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.PCDao;
import com.Dao.PC_relationDao;
import com.Dao.RegisterDao;
import com.Info.RecordInfo;

/**
 * Servlet implementation class RegisterDao
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String email=request.getParameter("email");
		int gameid=Integer.parseInt(request.getParameter("game"));
		int category=Integer.parseInt(request.getParameter("time"));
		PCDao p=new PCDao();
		ArrayList<PC> lst=p.retriveData();
		PC_relationDao pc=new PC_relationDao();
		pc.add(lst);
		RecordInfo ri=new RecordInfo();
		int id=ri.pcnoreturn(lst, category);
		if(id!=-1) {
			pc.create(id, category);
			Record r=new Record(email,gameid,category,id);
			RegisterDao rd=new RegisterDao();
			int i=rd.create(r);
			if(i>0) {
				response.sendRedirect("Home.jsp");
			}
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
