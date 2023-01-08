package com.datainsert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import com.dao.MovieDao;
import com.dao.MyConnection;
import com.model.Movie;

public class InsertData {
	Connection con=MyConnection.getConnection();
		public int insert(Movie m) {
			
			int i=0;
				System.out.println("Hello");
				try {
					PreparedStatement ps=con.prepareStatement("insert into Movie values(?,?,?,?,?)");
					ps.setInt(1, Integer.parseInt(m.getId()));
					ps.setString(2, m.getName());
					ps.setDouble(3, Double.parseDouble(m.getPopularity()));
					ps.setString(4,m.getGenres() );
					ps.setString(5, m.getCast());
					System.out.println("Hello1"+ps.toString());
				   i=ps.executeUpdate();
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
				
			return i;
		}
		
		public static void main(String[] args) {
			String line="";
			String splitBy = ",";
			int count=0;
			HashMap<Movie, Double> lst2=new HashMap<Movie, Double>();
			
			try {
				BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\Downloads\\movies12.csv"));   
				int k=0;
				while((line = br.readLine()) != null) {
					k++;
					if(k==1) {
						continue;
					}
					else {
						int count1=0;
						String movies[]=line.split(splitBy);
						Movie m=new Movie(movies[1],movies[2],movies[3],movies[4],movies[5]);
						lst2.put(m, Double.parseDouble(movies[3]));
						count1++;
						 if(count1==4800) {
							 break;
						 }
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Exception Found :: "+e);
			}
			Set<Movie> s=lst2.keySet();
			
			InsertData md=new InsertData();
			int count1=0;
			
			for(Movie m:s) {
				if(count1>4000 && count1<4500) {
				md.insert(m);
				}
				count1++;
				System.out.println("komal");
			}

		}
}
