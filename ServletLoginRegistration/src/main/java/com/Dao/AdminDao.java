package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.model.Admin;
import com.model.Customer;
public class AdminDao {
	public int create(Admin acobj) throws SQLException{
		Connection con = null;
		con = MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into Admin values(?,?,?,?,?)");
			ps.setInt(1, acobj.getAid());
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
			PreparedStatement ps=con.prepareStatement("select * from Admin where email = ?");
			ps.setString(1, email);
			System.out.println(email + " "+pass);
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
	
	public LinkedList<Admin> retrive(String email) {
		LinkedList<Admin> lc=new LinkedList<>();
		Connection con = null;
		con = MyConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from Admin where email=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Admin c=new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				lc.add(c);
			}
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
		return lc;
	}
}
