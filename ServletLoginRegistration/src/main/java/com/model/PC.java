package com.model;

import java.util.LinkedList;

public class PC {
	private int pcNo;
	private int sect;
	private int status;
//	private int startTime;
//	private int endTime;
	private LinkedList<Integer> currcategory;
	/*5 to 6 :- 1
	 * 6 to 7 :- 2
	 * 8 to 9:-3
	 * 10 to 11 :-4
	 * */
public PC(int pcNo,int sect) {
	super();
	this.pcNo = pcNo;
	this.sect = sect;
	currcategory=new LinkedList<Integer>();
}

public LinkedList<Integer> getCurrcategory() {
	return currcategory;
}

public void setCurrcategory(LinkedList<Integer> currcategory) {
	this.currcategory = currcategory;
}

public int getSect() {
	return sect;
}
public void setSect(int sect) {
	this.sect = sect;
}

public int getPcNo() {
	return pcNo;
}
public void setPcNo(int pcNo) {
	this.pcNo = pcNo;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
}
