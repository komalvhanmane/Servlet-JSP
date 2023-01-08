package com.Dao;

import java.sql.*;
import java.util.LinkedList;

import com.Info.CustomerInfo;
import com.model.Customer;
import com.model.PC;

public class OperationDao  {
	CustomerInfo ci=new CustomerInfo();
	
	public int create(Customer acobj) throws SQLException{
		Connection con = null;
		con = MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into Customer values(?,?,?,?)");
			ps.setString(1, acobj.getFname());
			ps.setString(2, acobj.getLname());
			ps.setString(3, acobj.getEmail());
			ps.setString(4, acobj.getPassword());
			i=ps.executeUpdate();
			ci.create(acobj);
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
			PreparedStatement ps=con.prepareStatement("select * from Customer where email = ?");
			ps.setString(1, email);
			ResultSet r=ps.executeQuery();
			
			if(r.next()) {
				System.out.println(email+" "+r.getString(3)+" "+pass+" "+r.getString(4));
				if(r.getString(3).equals(email) && r.getString(4).equals(pass)) {
					i=1;
					System.out.println("sdfs");
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Exception : "+e);
		}
		return i;
	}
	public LinkedList<Customer> retrive(String email) {
		LinkedList<Customer> lc=new LinkedList<>();
		Connection con = null;
		con = MyConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from Customer where email=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Customer c=new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				lc.add(c);
			}
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
		return lc;
	}

	
	public int update(int acc) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int delete(int acc) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Customer search(int an0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
