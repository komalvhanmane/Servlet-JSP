package com.model;

import java.util.LinkedList;

public class Section {
	private int secNo;
	private LinkedList<PC> lst;
	public Section(int secNo) {
		super();
		this.secNo = secNo;
		lst=new LinkedList<>();
	}
	public int getSecNo() {
		return secNo;
	}
	public void setSecNo(int secNo) {
		this.secNo = secNo;
	}
	public LinkedList<PC> getLst() {
		return lst;
	}
	public void setLst(LinkedList<PC> lst) {
		this.lst = lst;
	}
	
	
}
