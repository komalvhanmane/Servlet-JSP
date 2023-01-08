package com.info;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import com.model.*;
class Pair{
	private double s1;
	private int s2;
	public Pair(double s1, int s2) {
		super();
		this.s1 = s1;
		this.s2 = s2;
	}
	public double getS1() {
		return s1;
	}
	public void setS1(double s1) {
		this.s1 = s1;
	}
	public int getS2() {
		return s2;
	}
	public void setS2(int s2) {
		this.s2 = s2;
	}

}
class MovieComparator implements Comparator<Pair>{
	public int compare(Pair o1, Pair o2) {
		if (o2.getS1()<o1.getS1()) {
			return -1;
		}
		else if (o2.getS1()>o1.getS1()) {
			return 1;
		}
		return 0;
	}
}
public class ShowSimilarMovies {
	//similarity
//	public static PriorityQueue<Pair> sortByValue(PriorityQueue<Pair> hm)
//	{
//		List<Entry<Pair> > list =
//				new LinkedList<Map.Entry<Pair> >(hm.entrySet());
//
//		Collections.sort(list, new Comparator<Map.Entry<Integer, String> >() {
//			public int compare(Map.Entry<Integer, String> o1,
//					Map.Entry<Integer, String> o2)
//			{
//				return (o2.getValue()).compareTo(o1.getValue());
//			}
//		});

//		HashMap<Integer, String> temp = new LinkedHashMap<Integer, String>();
//		for (Entry<Integer, String> aa : list) {
//			//System.out.println(aa.getValue());
//			temp.put(aa.getKey(), aa.getValue());
//		}
//		return temp;
//	}

	public static LinkedList<Movie> recommend(String movie,LinkedList<Movie> movies,LinkedList<PriorityQueue<Pair>> similarity){
		LinkedList<Movie> lst=new LinkedList<>();
		int index=-1;
		System.out.println(similarity.size());
		for(int i=0;i<movies.size();i++) {
			//System.out.println(movies.get(i).getName()+" "+movie);
			if(movies.get(i).getName().equals(movie)) {
				index=i;
				break;
			}
		}
		if(index==-1) {
			return lst;
		}
		System.out.println(movies.size());
		System.out.println(similarity.size()+" "+index);
		PriorityQueue<Pair> hst=similarity.get(index);
		System.out.println(hst.size());
		while(!hst.isEmpty()) {
			int val=hst.poll().getS2();
			lst.add(movies.get(val));
		}
		//		System.out.println(hst1.get(1) );
		//		for(int i=0;i<hst1.size();i++) {
		//			System.out.println(i+" "+hst.get(i));
		//		}
//		int i=0;
//		for (Entry<Integer, String> en : hst1.entrySet()) {
//			//            System.out.println("Key = " + en.getKey() +
//			//                          ", Value = " + en.getValue());
//			//   System.out.println(movies.get(en.getKey()).getName());
//			lst.add(movies.get(en.getKey()));
//			i++;
//			if(i==10) {
//				break;
//			}
//		}

		return lst;
	}


	public static LinkedList<Movie> retrive(String args) {
		String line = "";
		String splitBy = ",";
		int count=0;
		LinkedList<Movie> lst=new LinkedList<>();

		LinkedList<PriorityQueue<Pair>> lst1=new LinkedList<>();
		HashMap<Double, Double> lst2=new HashMap<Double, Double>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\Downloads\\movies12.csv"));   
			BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\admin\\Downloads\\similarity_matrix.csv"));   
			while((line = br.readLine()) != null) {
				String movies[]=line.split(splitBy);
				
				Movie m=new Movie(movies[1],movies[2],movies[3],movies[4],movies[5]);
				lst.add(m);
				count++;
			}
			int count1=0;
			while((line = br1.readLine()) != null) {
				
				String movies[]=line.split(splitBy);
				
				PriorityQueue<Pair> pq=new PriorityQueue<>(1, new MovieComparator());
				for(int i=0;i<movies.length;i++) {
					if(i==lst.size()) {
						break;
					}
					if(movies[i].isEmpty() || movies[i].isBlank()) {
						movies[i]="0";
					}
					Pair p=new Pair(Double.parseDouble(movies[i]),i);
					pq.add(p);
					
				}
				lst1.add(pq);
				count1++;
				if(count1==lst.size()) {
					System.out.println("hello"+lst.size()+" "+lst1.size());
					break;
				}
			}
//			int k=0;
//			count1=0;
//			while((line = br.readLine()) != null) {
//				k++;
//				if(k==1) {
//					continue;
//				}
//				else {
//					
//					String movies[]=line.split(splitBy);
//					
//					lst2.put(Double.parseDouble(movies[1]), Double.parseDouble(movies[3]));
//					count1++;
//					if(count1==4800) {
//						break;
//					}
//				}
//			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception Found :: "+e);
		}
		
		System.out.println("Total movies"+count);
		System.out.println(lst1.size());
		LinkedList<Movie> m=recommend(args,lst,lst1);
		LinkedList<Movie> m1=new LinkedList<>();
//		System.out.println(args);
		System.out.println(m.size());
		for(int i=0;i<10;i++) {
			m1.add(m.get(i));
			System.out.println(m.get(i).getName());
		}
		
		return m1;
	}
	
	public static void main(String[] args) {
		retrive("Batman");
	}
}
