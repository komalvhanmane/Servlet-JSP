package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ass4 {
	public void insert(Customer c) {
		Connection con=null;
		con = MyConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into customer values(default,?,?,?)");
			ps.setString(1, c.getC_name());
			ps.setString(2, c.getC_city());
			ps.setString(3, c.getC_mobile());
			
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("record inserted");
			}
			else {
				System.out.println("failed to insert");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		con = MyConnection.getConnection();
		PreparedStatement ps=null;
		try {
			System.out.println("Enter your c_no ");
			int c_no=sc.nextInt();
			System.out.println("Enter choice \n1-name\n2-city\n3-mobile");
			switch(sc.nextInt()) {
			case 1:{
				System.out.println("Enter updated name :: ");
				String name = sc.next();
				ps=con.prepareStatement("update customer set c_name = ? where c_no = ?");
				ps.setString(1,name);
				ps.setInt(2, c_no);
				break;
			}
			case 2:{
				System.out.println("Enter updated city :: ");
				String city = sc.next();
				ps=con.prepareStatement("update customer set c_city = ? where c_no = ?");
				ps.setString(1,city);
				ps.setInt(2, c_no);
				break;
			}
			case 3:{
				System.out.println("Enter updated mobile :: ");
				String mobile = sc.next();
				ps=con.prepareStatement("update customer set c_mobile = ? where c_no = ?");
				ps.setString(1,mobile);
				ps.setInt(2, c_no);
				break;
			}
			}
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("record updated");
			}
			else {
				System.out.println("failed to update");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int cid) {
		Connection con=null;
		con = MyConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("delete from customer where c_no=?");
			ps.setInt(1,cid);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("record deleted");
			}
			else {
				System.out.println("failed to delete");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Customer> displayall() {
		ArrayList<Customer> a1=new ArrayList<>();
		Connection con=null;
		con = MyConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from customer");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Customer c=new Customer(rs.getString(2),rs.getString(3),rs.getString(4));
				c.setC_no(rs.getInt(1));
				a1.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a1;
	}
	public ArrayList<Customer> search(int cid) {
		ArrayList<Customer> a1=new ArrayList<>();
		Connection con=null;
		con = MyConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from customer where c_no=?");
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Customer c=new Customer(rs.getString(2),rs.getString(3),rs.getString(4));
				c.setC_no(rs.getInt(1));
				a1.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a1;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Ass4 a=new Ass4();
		do {
			System.out.println("Enter the choice \n1-Insert\n2-Update\n3-Delete\n4-search\n4-display");
			switch(sc.nextInt()) {
			case 1:{
				System.out.println("Enter Customer Details ::");
				System.out.println("Enter  c_name , c_city , c_mobile  ");
				Customer c=new Customer(sc.next(),sc.next(),sc.next());
				a.insert(c);
				break;
			}
			case 2:{
				a.update();
				break;
			}
			case 3:{
				System.out.println("Enter c_no :: ");
				a.delete(sc.nextInt());
				break;
			}
			case 4:{
				System.out.println("Enter c_no :: ");
				ArrayList<Customer> a1=a.search(sc.nextInt());
				for(int i=0;i<a1.size();i++) {
					System.out.println("-----------------------------------------");
					System.out.println("c_no        :: "+a1.get(i).getC_no());
					System.out.println("c_name   :: "+a1.get(i).getC_name());
					System.out.println("c_city      :: "+a1.get(i).getC_city());
					System.out.println("c_mobile :: "+a1.get(i).getC_mobile());
				}
				break;
			}
			case 5:{
				ArrayList<Customer> a1=a.displayall();
				for(int i=0;i<a1.size();i++) {
					System.out.println("-----------------------------------------");
					System.out.println("c_no        :: "+a1.get(i).getC_no());
					System.out.println("c_name   :: "+a1.get(i).getC_name());
					System.out.println("c_city      :: "+a1.get(i).getC_city());
					System.out.println("c_mobile :: "+a1.get(i).getC_mobile());
				}
				break;
			}
			}
			System.out.println("Do you want to continue press 1");
		}while(sc.nextInt()==1);
		
		
	}
}
