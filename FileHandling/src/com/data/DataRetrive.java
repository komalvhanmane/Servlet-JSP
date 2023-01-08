package com.data;

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

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class DataRetrive {
	
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
        	System.out.println(aa.getValue());
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
	
	public static HashMap<Double, Double> sortByPopularity(HashMap<Double, Double> hm)
    {
        List<Map.Entry<Double, Double> > list =
               new LinkedList<Map.Entry<Double, Double> >(hm.entrySet());
 
        Collections.sort(list, new Comparator<Map.Entry<Double, Double> >() {
            public int compare(Map.Entry<Double, Double> o1,
                               Map.Entry<Double, Double> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        HashMap<Double, Double> temp = new LinkedHashMap<Double, Double>();
        for (Entry<Double, Double> aa : list) {
        	System.out.println(aa.getValue());
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
	
	public static void show(HashMap<Double, Double> hm) {
		HashMap<Double, Double> hm1=sortByPopularity(hm);
		for(int i=0;i<hm1.size();i++) {
			System.out.println(hm1.get(i));
		}
	}
	
	public static List<String> recommend(String movie,LinkedList<Movie> movies,LinkedList<HashMap<Integer,String>> similarity){
		List<String> lst=new LinkedList<>();
		int index=-1;
		for(int i=0;i<movies.size();i++) {
			//System.out.println(movies.get(i).getName()+" "+movie);
			if(movies.get(i).getName().equals(movie)) {
				index=i;
				break;
			}
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
            System.out.println(movies.get(en.getKey()).name);
            i++;
            if(i==5) {
            	break;
            }
        }
		
		return lst;
	}
	
//	public static void readAllDataAtOnce(String file) {
//		try {
//			FileReader filereader=new FileReader(file);
//			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
//			
//			List<String[]> alldata = csvReader.readAll();
//			for(String[] row: alldata) {
//				for(String cell:row) {
//					System.out.print(cell + "\t");
//				}
//				System.out.println();
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args) {
		
		String line = "";
		String splitBy = ",";
		int count=0;
		LinkedList<Movie> lst=new LinkedList<>();
		LinkedList<HashMap<Integer,String>> lst1=new LinkedList<>();
		HashMap<Double, Double> lst2=new HashMap<Double, Double>();
		
		
//		//"C:\Users\admin\Downloads\movies11.csv"
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\Downloads\\movies12.csv"));   
			BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\admin\\Downloads\\similarity_matrix.csv"));   
			while((line = br.readLine()) != null) {
				String movies[]=line.split(splitBy);
			//	System.out.println(movies[1]+" "+" "+" "+movies[5]);
				 Movie m=new Movie(movies[1],movies[2],movies[3],movies[4],movies[5]);
			     lst.add(m);
				//System.out.println(movies[0]+"\t"+movies[1]+"\t"+movies[2]+"\t"+movies[3]);
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
//				System.out.println(movies[0]+"\t"+movies[1]+"\t"+movies[2]+"\t"+movies[3]);				 lst1.add(hmap);
//				 System.out.print("hello");
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
//					System.out.println(movies[0]+"\t"+movies[1]+"\t"+movies[2]+"\t"+movies[3]);				 lst1.add(hmap);
//					 System.out.print("hello");
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
		recommend("Batman",lst,lst1);
		//show(lst2);
	}
}
