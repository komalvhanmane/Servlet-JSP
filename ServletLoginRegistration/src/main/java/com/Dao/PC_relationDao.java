package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

import com.model.PC;

public class PC_relationDao {
	public int create(int pcNo,int category) {
		int i=0;
		Connection con=null;
		try {
			con=MyConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into psc values(?,?)");
			ps.setInt(1, pcNo);
			ps.setInt(2, category);
			
			i = ps.executeUpdate();
			if(i>0) {
				System.out.println("record inserted into relation seccesfully");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}
	public void add(ArrayList<PC> lst) {
		Connection con=null;
		try {
			con=MyConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from psc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				int category=rs.getInt(2);
				for(int i=0;i<lst.size();i++) {
					if(lst.get(i).getPcNo()==id) {
						lst.get(i).getCurrcategory().add(category);
					}
				}
			}
		}
		catch(Exception e) {
			
		}
	}

}
