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


import com.model.*;

public class ShowSimilarMovie {
	//similarity
	public static HashMap<Integer, String> sortByValue(HashMap<Integer, String> hm)
    {
        List<Map.Entry<Integer, String> > list =
               new LinkedList<Map.Entry<Integer, String> >(hm.entrySet());
 
        Collections.sort(list, new Comparator<Map.Entry<Integer, String> >() {
            public int compare(Map.Entry<Integer, String> o1,
                               Map.Entry<Integer, String> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        HashMap<Integer, String> temp = new LinkedHashMap<Integer, String>();
        for (Entry<Integer, String> aa : list) {
        	//System.out.println(aa.getValue());
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
	
	public static LinkedList<Movie> recommend(String movie,LinkedList<Movie> movies,LinkedList<HashMap<Integer,String>> similarity){
		LinkedList<Movie> lst=new LinkedList<>();
		int index=-1;
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
		//System.out.println(similarity.size());
		HashMap<Integer,String> hst=similarity.get(index);
		HashMap<Integer,String> hst1=sortByValue(hst);
		
//		System.out.println(hst1.get(1) );
//		for(int i=0;i<hst1.size();i++) {
//			System.out.println(i+" "+hst.get(i));
//		}
		int i=0;
		for (Entry<Integer, String> en : hst1.entrySet()) {
//            System.out.println("Key = " + en.getKey() +
//                          ", Value = " + en.getValue());
            System.out.println(movies.get(en.getKey()).getName());
            lst.add(movies.get(en.getKey()));
            
            i++;
            if(i==10) {
            	break;
            }
        }
		
		return lst;
	}
	

public static LinkedList<Movie> retrive(String args) {
		String line = "";
		String splitBy = ",";
		int count=0;
		LinkedList<Movie> lst=new LinkedList<>();
		LinkedList<HashMap<Integer,String>> lst1=new LinkedList<>();
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
			while((line = br1.readLine()) != null) {
				int count1=0;
				String movies[]=line.split(splitBy);
				HashMap<Integer,String> hmap=new HashMap<>();
				for(int i=0;i<movies.length;i++) {
						hmap.put(i, movies[i]);
				}
				lst1.add(hmap);
				count1++;
				 if(count1==4806) {
					 break;
				 }
			}
			int k=0;
			while((line = br.readLine()) != null) {
				k++;
				if(k==1) {
					continue;
				}
				else {
					int count1=0;
					String movies[]=line.split(splitBy);
					lst2.put(Double.parseDouble(movies[1]), Double.parseDouble(movies[3]));
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
		System.out.println("Total movies"+count);
		LinkedList<Movie> m=recommend(args,lst,lst1);
		System.out.println(args);
		return m;
	}
}
