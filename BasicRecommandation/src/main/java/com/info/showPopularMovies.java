package com.info;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import com.dao.MovieDao;
import com.model.Movie;

public class showPopularMovies {
	//it is for sorting based on popularity based
	
	public static HashMap<Movie, Double> sortByPopularity(HashMap<Movie, Double> hm)
    {
        List<Map.Entry<Movie, Double> > list =
               new LinkedList<Map.Entry<Movie, Double> >(hm.entrySet());
 
        Collections.sort(list, new Comparator<Map.Entry<Movie, Double> >() {
            public int compare(Map.Entry<Movie, Double> o1,
                               Map.Entry<Movie, Double> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        HashMap<Movie, Double> temp = new LinkedHashMap<Movie, Double>();
        for (Entry<Movie, Double> aa : list) {
        	//System.out.println(aa.getValue());
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
	
	public static LinkedList<Movie>  save() {
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
		//System.out.println("Total movies"+count);
		HashMap<Movie, Double> temp=sortByPopularity(lst2);
		Set<Movie> s=temp.keySet();
		MovieDao md=new MovieDao();
		LinkedList<Movie> lst=new LinkedList<>();
		//Movie m=new Movie(11,"ddf",212,"dff","dsfsd");
		int count1=0;
		for(Movie m:s) {
		//	System.out.println(m.getPopularity());
//			md.insert(m);
			lst.add(m);
		}
//		for(int i=356;i<lst.size();i++) {
//			md.insert(lst.get(i));
//		}
		return lst;
	}
	public static LinkedList<Movie>  ShowfilteredpopularMovie(String filter) {
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
		//System.out.println("Total movies"+count);
		HashMap<Movie, Double> temp=sortByPopularity(lst2);
		Set<Movie> s=temp.keySet();
		MovieDao md=new MovieDao();
		LinkedList<Movie> lst=new LinkedList<>();
		//Movie m=new Movie(11,"ddf",212,"dff","dsfsd");
		int count1=0;
		for(Movie m:s) {
//			if(count1==1) {
//				break;
//			}
			//md.insert(m);
			//System.out.println("h");
			System.out.println(m.getGenres());
			if(m.getGenres().indexOf(filter)!=-1) {
				System.out.println(m.getGenres());
				lst.add(m);
			}
			else {
				//System.out.println(m.getGenres());
			}
			//count1++;
		}
		return lst;
	}
	
	public static LinkedList<Movie>  showsimilarName(String movie) {
		
		//String movie=movi.toLowerCase();
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
					 if(count1==4808) {
						 break;
					 }
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception Found :: "+e);
		}
		
		HashMap<Movie, Double> temp=sortByPopularity(lst2);
		Set<Movie> s=temp.keySet();
		LinkedList<Movie> lst=new LinkedList<>();
		int count2=0;
		boolean flag=false;
		for(Movie m:s) {		
			// System.out.println(m.getName());	
			if( m.getName().equalsIgnoreCase(movie) ||  m.getName().indexOf(movie)!=-1) {
			   //System.out.println(m.getName());	
				lst.add(m);
				flag=true;
			}
		}
//		if(!flag) {
//			for(Movie m:s) {		
//				// System.out.println(m.getName());	
//				if( m.getGenres().indexOf(movie)!=-1 ) {
//				   System.out.println(m.getName());	
//					lst.add(m);
//					flag=true;
//				}
//			}
//		}
//		if(!flag) {
//			for(Movie m:s) {		
//				// System.out.println(m.getName());	
//				if( m.getCast().indexOf(movie)!=-1 ) {
//				 //  System.out.println(m.getName());	
//					lst.add(m);
//					flag=true;
//				}
//			}
//		}
		
		
		return lst;
	}
	
	public static void main(String[] args) {
		save();
//		ShowfilteredpopularMovie("action");
		//showsimilarName("Batman");
	}
	
}
