package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.model.PC;

public class PCDao {
	public int create(PC acobj) throws SQLException {
		Connection con = null;
		con = MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into PC values(?,?)");
			ps.setInt(1, acobj.getPcNo());
			ps.setInt(2, acobj.getSect());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception : "+e);
		}
		return i;
	}
	public int delete(int id) throws SQLException {
		Connection con = null;
		con = MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from PC where pcNo=?");
			ps.setInt(1, id);
			i=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
		return i;
	}
	
	public ArrayList<PC> retriveData(){
		ArrayList<PC> lpc=new ArrayList<>();
		Connection con = null;
		con = MyConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from PC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				PC p=new PC(rs.getInt(1),rs.getInt(2));
				lpc.add(p);
			}
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
		return lpc;
	}
}
