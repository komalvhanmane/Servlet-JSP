package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.model.Games;

public class GameDao {
	public int create(Games g) throws SQLException {
		Connection con = null;
		con = MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into games values(?,?,?)");
			ps.setInt(1, g.getGameID());
			ps.setFloat(2, (float) g.getPrice());
			ps.setString(3, g.getGameName());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception : "+e);
		}
		return i;
	}
	
	public ArrayList<Games> retrive(){
		ArrayList<Games> lst=new ArrayList<>();
		
		Connection con=null;
		con = MyConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from games ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Games g=new Games(rs.getInt(1),rs.getDouble(2),rs.getString(3));
				lst.add(g);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return lst;
	}
}
