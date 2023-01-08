package com.Info;

import java.util.LinkedList;

import com.model.Customer;

public class CustomerInfo {
	LinkedList<Customer> lst=new LinkedList<>();
	//create
	public void create(Customer c) {
		lst.add(c);
	}
}
