package com.Dao;

import java.sql.SQLException;
import java.util.LinkedList;

import com.model.Customer;

public interface Accountinterface {
	public int create(Customer acobj) throws SQLException;
	LinkedList<Customer> retrive();
	int update(int acc);
	int delete(int acc);
	Customer search(int an0);
}
