package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.PC;
import com.model.Section;

public class SectionDao {
	public int create(Section acobj) throws SQLException {
		Connection con = null;
		con = MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into Section values(?)");
			ps.setInt(1, acobj.getSecNo());
			
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
			PreparedStatement ps=con.prepareStatement("delete from Section where SecNo=?");
			ps.setInt(1, id);
			i=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
		return i;
	}
}
