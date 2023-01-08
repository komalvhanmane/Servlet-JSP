package com.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class abcdmain {
	int regNo;
	String lname;
	String fname;
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final  String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String uname = "system";
	private static final String pass="123456789";
	public abcdmain(int regNo, String lname, String fname) {
		super();
		this.regNo = regNo;
		this.lname = lname;
		this.fname = fname;
	}

	public int cone(abcdmain a) {
		int i=0;
		try {
			Connection con = null;
			try {
				Class.forName(driver);//load driver
				con = DriverManager.getConnection(url,uname,pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}//connection to database
	         catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("Connection : "+con);
		PreparedStatement ps=con.prepareStatement("insert into Student values(?,?,?)");
		ps.setInt(1, a.regNo);
		ps.setString(2, a.fname);
		ps.setString(3, a.lname);
		i=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ima error :)");
		}
		return i;
	}
}
