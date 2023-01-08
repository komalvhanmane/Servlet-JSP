package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.info.showPopularMovies;
import com.model.*;


public class MovieDao {
	//insert movie
	public int insert(Movie m) {
		Connection con=MyConnection.getConnection();
		int i=0;
			System.out.println("Hello");
			try {
				//Statement stmt=con.createStatement();
				PreparedStatement ps=con.prepareStatement("insert into Movie values(?,?,?,?,?)");
				ps.setInt(1, Integer.parseInt(m.getId()));
				ps.setString(2, m.getName());
				ps.setDouble(3, Double.parseDouble(m.getPopularity()));
				ps.setString(4,m.getGenres() );
				ps.setString(5, m.getCast());
				System.out.println("Hello1"+ps.toString());
			   i=ps.executeUpdate();
//				String str="insert into Movie values ("+m.getId()+",'"+m.getName()+"',"+m.getPopularity()+",'"+m.getGenres()+"','"+m.getCast()+"')";
//				System.out.println(str);
				//i=stmt.executeUpdate(str);
//			   con.commit();
			   System.out.println("Hello2");
			   if(i>0) {
				   System.out.println("Movie Inserted");
			   }
			   else {
				   System.out.println("unable to insert movie");
			   }
			} catch (Exception e) {
				System.out.println("Exception : "+e);
				System.out.println("Hello2");
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		return i;
	}
	
	public LinkedList<Movie> getPopularMovie() {
		showPopularMovies spm=new showPopularMovies();
		return showPopularMovies.save();
	}
}
