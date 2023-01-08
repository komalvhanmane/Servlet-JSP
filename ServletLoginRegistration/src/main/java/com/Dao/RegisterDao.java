package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.model.*;
import com.model.Record;
public class RegisterDao {
	public int create(Record r) {
		Connection con=null;
		int i=0;
		try {
			con=MyConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into record values(?,?,?)");
			ps.setString(1,r.getEmail());
			ps.setInt(2, r.getGameID());
			ps.setInt(3, r.getPcNo());
			i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Registered succesfully with PC number :: "+r.getPcNo()+"timing category :: "+r.getCategory());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
