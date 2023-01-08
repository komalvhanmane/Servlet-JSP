package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.PCDao;
import com.Dao.PC_relationDao;
import com.Dao.RegisterDao;
import com.Info.RecordInfo;
import com.model.PC;
import com.model.Record;

/**
 * Servlet implementation class Register1Controller
 */
public class Register1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register1Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String email=request.getParameter("email");
		int game=Integer.parseInt(request.getParameter("game"));
		int gameid;
		if(game==1) {
			gameid=100;
		}
		else if(game==2) {
			gameid=101;
		}
		else {
			gameid=103;
		}
		int category=Integer.parseInt(request.getParameter("time"));
		PCDao p=new PCDao();
		ArrayList<PC> lst=p.retriveData();
//		for(int i=0;i<lst.size();i++) {
//			System.out.println(lst.get(i).getPcNo());
//			System.out.println(lst.get(i).getCurrcategory());
//		}
		PC_relationDao pc=new PC_relationDao();
		pc.add(lst);
//		for(int i=0;i<lst.size();i++) {
//			System.out.println(lst.get(i).getPcNo());
//			System.out.println(lst.get(i).getCurrcategory());
//		}
		
		RecordInfo ri=new RecordInfo();
		int id=ri.pcnoreturn(lst, category);
		//System.out.println(id);
		if(id!=-1) {
			pc.create(id, category);
			Record r=new Record(email,gameid,category,id);
			RegisterDao rd=new RegisterDao();
			int i=rd.create(r);
			
			if(i>0) {
				HttpSession session=request.getSession();
				session.setAttribute("data", "Record Added");
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
