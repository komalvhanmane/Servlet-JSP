package myappl.controller;
import myappl.dao.*;
import myappl.model.*;
import java.util.*;

public class AccountController {
	Scanner sc=new Scanner(System.in);
	
	public Account create() {
		System.out.println("Enter the Account number :: ");
		int acc_no=sc.nextInt();
		System.out.println("Enter the first Name :: ");
		String fname=sc.next();
		System.out.println("Enter the last name :: ");
		String lname=sc.next();
		System.out.println("Enter the Account balance :: ");
		double balance=sc.nextDouble();
		Account a=new Account(acc_no,fname,balance,lname);
		return a;
	}
	
	public int delete() {
		System.out.println("Enter the Account Number :: ");
		int acc=sc.nextInt();
		return acc;
	}
	
	public int update() {
		System.out.println("Enter the Account Number :: ");
		int acc=sc.nextInt();
		return acc;
	}
	
	public int search() {
		System.out.println("Enter the Account Number :: ");
		int acc=sc.nextInt();
		return acc;
	}
	
	public void save(Account a) {
		//this is dynamic polymorphism
		AccountInterface ai=new BankDao();
		int i=ai.create(a);
		if(i>0) {
			System.out.println("Account Created ...");
		}
		else{
			System.out.println("Account Not created...");
		}
	}
	
	public void savedelete(int a) {
		AccountInterface ai=new BankDao();
		int i=ai.delete(a);
		if(i>0) {
			System.out.println("Account deleted successfully !!");
		}
		else {
			System.out.println("Not able to delete!!");
		}
	}
	
	public void saveupdate(int a) {
		AccountInterface ai=new BankDao();
		int i=ai.update(a);
		if(i>0) {
			System.out.println("Updated succesfully!!");
		}
		else {
			System.out.println("Not updated !!");
		}
	}
	
	public void savesearch(int a) {
		AccountInterface ai=new BankDao();
		Account i=ai.search(a);
		if(i!=null) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("Account Number :: "+i.getAccNo());
			System.out.println("Customer Name :: "+i.getCustName()+" "+i.getLastName());
			System.out.println("Account Balance :: "+i.getAcc_bal());
			System.out.println("-----------------------------------------------------------------");
		}
	}
}
