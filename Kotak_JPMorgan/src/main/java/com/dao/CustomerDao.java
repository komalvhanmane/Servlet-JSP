package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.model.Employee;
import com.model.Login;

public class CustomerDao {
	public int insert(Employee c) {
		int i=0;
		Connection con=MyConnection.getConnection();
		try {
			
			PreparedStatement ps=con.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, c.getEmp_id());
			ps.setString(2, c.getName());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getDOB());
			ps.setString(5, c.getGender());
			ps.setString(6, c.getDesignation());
			ps.setString(7, c.getLevel());
			ps.setString(8, c.getIntervention());
			ps.setString(9, c.getDOJ());
			ps.setString(10, c.getStatus());
			
			  
			i=ps.executeUpdate();
			if(i>0) {
				System.out.println("employee record inserted");
			}
			else{
				System.out.println("unable to insert");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public Employee validate(Login l) {
		int i=0;
		Connection con=MyConnection.getConnection();
		Employee c=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from login_details where email_id=? and password=?");
			ps.setString(1, l.getEmail());
			ps.setString(2, l.getPass());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				i=1;
				PreparedStatement ps1=con.prepareStatement("select * from employees where email_id=?");
				ps1.setString(1, l.getEmail());
				System.out.println("abcd");
				ResultSet rs1=ps1.executeQuery();
				if(rs1.next()) {
					System.out.println("defg");
					c=new Employee(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),rs1.getString(7),rs1.getString(8),rs1.getString(9),rs1.getString(10));
				}
			}
			
			if(i>0) {
				System.out.println("valid user");
				System.out.println("Hello");
			}
			else{
				System.out.println("invalid");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}
	
	public LinkedList<Employee> retrive() {
		LinkedList<Employee> lst=new LinkedList<>();
		int i=0;
		Connection con=MyConnection.getConnection();
		Employee c=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from employees");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				i=1;
				Employee e=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
				lst.add(e);
			}
			if(i>0) {
				System.out.println("valid user");
				System.out.println("Hello");
			}
			else{
				System.out.println("invalid");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;

	}
	public static void main(String[] args) {
		CustomerDao d=new CustomerDao();
//		Customer c=new Customer("vidhi","vaswani","vidhivaswani@gmail.com","vidhi123","4564545445");
//		d.insert(c);
	}
}
