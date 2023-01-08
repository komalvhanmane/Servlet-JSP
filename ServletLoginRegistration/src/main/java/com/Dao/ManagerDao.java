package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.model.Customer;
import com.model.Manager;

public class ManagerDao {


	public int create(Manager acobj) throws SQLException {
		Connection con = null;
		con = MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into Manager values(?,?,?,?,?)");
			ps.setInt(1, acobj.getMid());
			ps.setString(2, acobj.getFname());
			ps.setString(3, acobj.getLname());
			ps.setString(4, acobj.getEmail());
			ps.setString(5, acobj.getPassword());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception : "+e);
		}
		return i;
	}

	public int validate(String email,String pass) {
		Connection con = null;
		con = MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("select * from Manager where email = ?");
			ps.setString(1, email);
			ResultSet r=ps.executeQuery();

			if(r.next()) {
				System.out.println(email+" "+r.getString(4)+" "+pass+" "+r.getString(5));
				if(r.getString(4).equals(email) && r.getString(5).equals(pass)) {
					i=1;
					System.out.println("sdfs");
				}
			}

		} catch (SQLException e) {
			System.out.println("Exception : "+e);
		}
		return i;
	}

	public LinkedList<Manager> retrive(String id) {
		LinkedList<Manager> lc=new LinkedList<>();
		Connection con = null;
		con = MyConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from Manager where email=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Manager c=new Manager(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				lc.add(c);
			}
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
		return lc;
	}


	public int update(int acc ,String str,int i) {
		Connection con=null;
		con = MyConnection.getConnection();
		int i1=0;
		PreparedStatement ps;
		try {
			if(i==1) {
				ps=con.prepareStatement("update Manager set fname=? where mid=?");
			}
			else if(i==2) {
				ps=con.prepareStatement("update Manager set lname=? where mid=?");
			}
			else if(i==3) {
				ps=con.prepareStatement("update Manager set email=? where mid=?");
			}
			else {
				ps=con.prepareStatement("update Manager set pass=? where mid=?");
			}
			ps.setString(1,str);
			ps.setInt(2, acc);
			i1=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i1;
	}


	public int delete(int acc) {
		Connection con = null;
		con = MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from Manager where mid = ?");
			ps.setInt(1, acc);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception : "+e);
		}
		return i;
	}


	public Customer search(int an0) {
		// TODO Auto-generated method stub
		return null;
	}


	public int create(Customer acobj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
