package com.Info;

import java.util.ArrayList;
import java.util.LinkedList;

import com.model.PC;

public class RecordInfo {
	public int pcnoreturn(ArrayList<PC> lst,int k) {
	
		int pcno=-1;
		for(int i=0;i<lst.size();i++) {
//			if(lpc.get(i).getCurrcategory().size()==0) {
//				return lpc.get(i).getPcNo();
//			}
			
			int j=0;
			for(j=0;j<lst.get(i).getCurrcategory().size();j++) {
				System.out.println(lst.get(i).getCurrcategory().get(j));
				if(lst.get(i).getCurrcategory().get(j)==k) {
					break; 
				}
			}
			if(j==lst.get(i).getCurrcategory().size()) {
				return lst.get(i).getPcNo();
			}
		}
		return pcno;
	}
}
