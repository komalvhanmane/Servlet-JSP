package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Stack;

import com.model.History;

public class SearchHistoryDao {
	public int insertHistory(String email,String s) {
		Connection con=MyConnection.getConnection();
		System.out.println("email"+email);
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into history values(?,?,CURRENT_TIMESTAMP)");
			ps.setString(1,email);
			ps.setString(2, s);
			 i=ps.executeUpdate();
			if(i>0) {
				System.out.println("data inserted");
			}
			else {
				System.out.println("unable to insert data");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public Stack<History> retrive(String email) {
		Stack<History> s=new Stack<>();
		Connection con=MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("select * from history where user_email=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				History h=new History(rs.getString(1),rs.getString(2));
				s.push(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	public LinkedList<String> mostSearched(String email) {
		LinkedList<String> lst=new LinkedList<>();
 		Connection con=MyConnection.getConnection();
 		System.out.println("email :: "+email);
		int i=0;
		try {
			//select count(*),str from history  where user_email='vhanmanekomal@gmail.com'  group by str order by count(*) desc;
			PreparedStatement ps=con.prepareStatement("select count(*),str from history  where user_email=?  group by str order by count(*) desc ");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				lst.add(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
}
