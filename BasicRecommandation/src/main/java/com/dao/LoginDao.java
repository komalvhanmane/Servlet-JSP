package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;

public class LoginDao {
	public int insert(User u) {
	Connection con=MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into User2 values(?,?)");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			i = ps.executeUpdate();
			if(i>0) {
				System.out.println("User Inserted");
			}
			else {
				System.out.println("unable to insert User");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public int validate(User u) {
		Connection con=MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("select * from User2 where email=?");
			ps.setString(1, u.getEmail());
			System.out.println(u.getEmail());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println(u.getPassword()+" "+rs.getString(2));
				if(u.getPassword().equals(rs.getString(2))) {
					i=1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
