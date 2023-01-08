package myappl.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myappl.model.Account;

//data access object
public class BankDao implements AccountInterface{
	Scanner sc=new Scanner(System.in);
	//create
	public int create(Account acobj) {
		Connection con = null;
		con = MyConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into bankdb values(?,?,?,?)");
			ps.setInt(1, acobj.getAccNo());
			ps.setString(2, acobj.getCustName());
			ps.setString(3, acobj.getLastName());
			ps.setDouble(4, acobj.getAcc_bal());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception : "+e);
		}
		return i;
	}

	@Override
	public LinkedList<Account> retrive() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int update(int acc) {
		Connection con=MyConnection.getConnection();
		PreparedStatement pst=null;
		int i=0;
		try {
			System.out.println("Enter the choice \n1-update fname\n2-update lname\n3-update balance");
	        switch (sc.nextInt()){
	            case 1:{
	                pst=con.prepareStatement("update bankdb set fname=? where acno=?");
	                System.out.println("Enter the fname ");
	                pst.setInt(2,acc);
	                pst.setString(1,sc.next());
	                i=pst.executeUpdate();
	                break;
	            }
	            case 2:{
	                pst=con.prepareStatement("update bankdb set lname=? where acno=?");
	                System.out.println("Enter the  lname ");
	                pst.setInt(2,acc);
	                pst.setString(1,sc.next());
	                i=pst.executeUpdate();
	                break;
	            }
	            case 3:{
	                pst=con.prepareStatement("update bankdb set accbal=? where acno=?");
	                System.out.println("Enter the accbal ");
	                pst.setInt(2,acc);
	                pst.setInt(1,sc.nextInt());
	                i=pst.executeUpdate();
	                break;
	            }

	        }
		}catch(Exception e) {
			System.out.println("Exception : "+e);
		}
		
		return i;
	}

	@Override
	public int delete(int acc) {
		Connection con=MyConnection.getConnection();
		PreparedStatement pst;
		 int i=0;
		try {
			pst = con.prepareStatement("delete from bankdb where acno=?");
			pst.setInt(1,acc);
	        i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Account search(int an) {
	Connection con=MyConnection.getConnection();
		PreparedStatement pst;
		Account a=null;
		try {
			pst = con.prepareStatement("select * from bankdb where acno=?");
			pst.setInt(1, an);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				a=new Account(r.getInt(1),r.getString(2),r.getDouble(4),r.getString(3));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception : "+e);
		}
		return a;
//		Connection con=MyConnection.getConnection();
//		PreparedStatement pst;
//		Account a=null;
//		try {
//			pst = con.prepareStatement("select * from bankdb where acno=?");
//			pst.setInt(1, an);
//			ResultSet r=pst.executeQuery();
//			if(r.next()) {
//				a=new Account(r.getInt(1),r.getString(2),r.getDouble(4),r.getString(3));
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("Exception : "+e);
//		}
//		return a;
	}
	 
}
